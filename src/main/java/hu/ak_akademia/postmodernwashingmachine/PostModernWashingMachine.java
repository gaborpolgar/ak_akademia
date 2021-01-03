package hu.ak_akademia.postmodernwashingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostModernWashingMachine {

    private boolean machineOn;
    private boolean openedDoor;
    private State state;
    private List<Clothes> tumbler;

    public PostModernWashingMachine() {
        machineOn = false;
        openedDoor = false;
        state = State.OFF;
        tumbler = new ArrayList<>();
    }

    public void switchOn() {
        if (!machineOn) {
            machineOn = true;
            state = State.ON;
            System.out.println("A mosógép bekapcsolódik.");
        } else{
            System.out.println("The waschmashine already switched on. ");
        }
    }

    public void switchOff() {
        machineOn = false;
        state = State.OFF;
        System.out.println("A mosógép kikapcsolódik.");
    }

    public void openDoor() {
        if (machineOn) {
            if (!(state == State.WASHING)) {
                openedDoor = true;
                System.out.println("A mosógép ajtaja kinyitódik.");
            } else {
                System.out.println("Open the door not allowed, while Cleaning in progress.");
            }
        }
    }

    public void close() {
        if (machineOn) {
            if (openedDoor) {
                openedDoor = false;
                System.out.println("A mosógép ajtaja becsukódik");
            } else {
                System.out.println("Closing the door not allowed, while the machine's door is closed.");
            }
        }
    }

    public void load(Clothes... clothes) {
        if (machineOn) {
            tumbler.addAll(Arrays.asList(clothes));
            System.out.println("A mosógépbe az alábbi ruhák kerülnek betöltésre: \n" + tumbler.toString());
        }
    }

    public List<Clothes> unload() {
            List<Clothes> done = null;
        if (machineOn) {
            done = new ArrayList<>(tumbler);
            tumbler.clear();
        }
        System.out.println("A mosógépből kivéve: \n" + done.toString());
            return done;
    }

    public void iron() {
        if (machineOn) {
            for (Clothes clothes : tumbler) {
                clothes.iron();
                System.out.println(clothes.getName() + " kivasalva.");
            }
        }
    }

    public void dry() {
        if (machineOn) {
            for (Clothes clothes : tumbler) {
                    clothes.dry();
            }
        }
    }

    private String check() {
        if (machineOn) {
            if (tumbler.isEmpty()) {
                System.out.println("A mosógép üresen nem indítható.");
                return null;
            }
            boolean color = false;
            boolean white = false;
            int dirtySum = 0;
            for (Clothes clothes : tumbler) {
                if (clothes.getColor() == Color.COLORFUL) {
                    color = true;
                } else if (clothes.getColor() == Color.WHITE) {
                    white = true;
                }
                dirtySum += clothes.getDirty();
            }
            if (color && white) {
                System.out.println("A mosógép vegyes ruhákkal nem indítható.");
            } else if (dirtySum > 800) {
                System.out.println("A program túl koszos ruhákkal nem indítható.");
            } else if (dirtySum < 50) {
                System.out.println("A betöltött ruhák tiszták, a mosógép indítása nem indokolt.");
            } else {
                return "OK";
            }
        }
            return null;
    }

    public void startWash() {
        if (machineOn || check().equals("OK") ) {
                int dirtySum = 0;
                state = State.WASHING;
                do {
                    dirtySum = 0;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (Clothes clothes : tumbler) {
                        clothes.clean();
                        dirtySum += clothes.getDirty();
                    }
                } while ((dirtySum > 30));
                state = State.OFF;
            }
        }
    }
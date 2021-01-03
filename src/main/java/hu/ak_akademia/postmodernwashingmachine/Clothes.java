package hu.ak_akademia.postmodernwashingmachine;

public abstract class Clothes implements Washable {

    private int dirty;
    private Color color;
    private String name;
    private int durability;
    private boolean isIroned;
    private boolean isRaunchy;
    private int wet;
    private static int DUR_CUT_RATE;

    public Clothes(String name, Color color, int dirty) {
        this.name = name;
        this.color = color;
        this.dirty= dirty;
        isIroned = false;
        isRaunchy = false;
        this.durability = 100;
        this.wet=0;
    }

    public int getDurCutRate() {
        return DUR_CUT_RATE;
    }

    public void setWet(int wet) {
        this.wet = wet;
    }

    public int getDirty() {
        return dirty;
    }

    public void setDirty(int dirty) {
        this.dirty = dirty;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isIroned() {
        return isIroned;
    }

    public boolean isRaunchy() {
        return isRaunchy;
    }

    public int getWet() {
        return wet;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public void clean() {
        System.out.println(getName() + " mosása....");
        setDirty(getDirty()-1);
        setWet(getWet() + 1);
        System.out.println("A " + getName() + " koszossága " + getDirty() + " értékre csökkent.");
        if(!(getDurability() <= 0)) {
            setDurability(getDurability() - getDurCutRate());
            System.out.println("A " + getName() + " tartóssága " + getDurability() +" értékre csökkent.");
        } else{
            isRaunchy = true;
            System.out.println("A " + getName() + " elszakadt.");
        }
    }

    @Override
    public void dry() {
        do{
        System.out.println(getName() + " szárítása....");
        setWet(getWet() - 1);
    } while (getWet() != 0) ;
        System.out.println("A " + getName() + " teljesen megszáradt.");
    }

    @Override
    public void iron() {
        isIroned = true;
        System.out.println("A " + getName() + " kivasalásra került.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Neve: " + getName());
        sb.append(" " + color.getColor() );
        sb.append(" A piszkossága: " + getDirty());
        sb.append(" A tartóssága: " + getDurability());
        sb.append(" A Nedvessége: " + getWet());
        sb.append(isRaunchy ? "Szakadt " : "ép ");
        sb.append(isIroned ? "vasalt \n" : "vasalatlan \n");
        return sb.toString();
    }

}

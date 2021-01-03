package hu.ak_akademia.postmodernwashingmachine;

public class Shirt extends Clothes implements Washable {

    private int dirty;
    private Color color;

    private String name;
    private int durability;
    private boolean isIroned;
    private boolean isRaunchy;
    private int wet;
    private static final int DUR_CUT_RATE = 4;


    public Shirt(String name, Color color, int dirty) {
        super(name, color, dirty);
        durability = super.getDurability();
        isIroned = super.isIroned();
        wet = super.getWet();
        isRaunchy = super.isRaunchy();
        }

    public int getDurCutRate() {
        return Shirt.DUR_CUT_RATE;
    }

    @Override
    public int getDirty() {
        return super.getDirty();
    }

    @Override
    public void setDirty(int dirty) {
        super.setDirty(dirty);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getDurability() {
        return super.getDurability();
    }

    @Override
    public boolean isIroned() {
        return super.isIroned();
    }

    @Override
    public boolean isRaunchy() {
        return super.isRaunchy();
    }

    @Override
    public int getWet() {
        return super.getWet();
    }

    @Override
    public void setDurability(int durability) {
        super.setDurability(durability);
    }

    @Override
    public void clean() {
        super.clean();
    }

    @Override
    public void dry() {
        super.dry();
    }

    @Override
    public void iron() {
        super.iron();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

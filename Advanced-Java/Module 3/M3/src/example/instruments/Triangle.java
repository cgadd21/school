package example.instruments;

public class Triangle extends NonPitchedPercussion {
    private int size;
    private boolean beaterIncluded;

    public Triangle() {
    }

    public Triangle(String brand, String model, int year, boolean playable, String strikerType, String surfaceType, boolean orchestral, int size, boolean beaterIncluded) {
        super("Instruments.Triangle", brand, model, year, playable, strikerType, surfaceType, orchestral);
        this.size = size;
        this.beaterIncluded = beaterIncluded;
    }

    public int getSize() {
        return size;
    }

    public boolean isBeaterIncluded() {
        return beaterIncluded;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBeaterIncluded(boolean beaterIncluded) {
        this.beaterIncluded = beaterIncluded;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Size: " + size + "; Beater included? " + beaterIncluded;
    }

    @Override
    public void determineService() {
        if(getYear() >= 2005 && !beaterIncluded){
            System.out.println("This triangle requires a new beater.");
        }
    }

    @Override
    public boolean readyToReplace() {
        if(getYear() < 1990 || (getYear() < 2005 && !beaterIncluded)){
            return true;
        }
        return false;
    }
}

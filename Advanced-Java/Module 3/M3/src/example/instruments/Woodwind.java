package example.instruments;

public abstract class Woodwind extends PitchedInstrument{
    private boolean reed;
    private int padReplacementYear;

    public Woodwind() {
    }

    public Woodwind(String name, String brand, String model, int year, boolean playable, String key, String lowestNote, String highestNote, boolean reed, int padReplacementYear) {
        super(name, brand, model, year, playable, key, lowestNote, highestNote);
        this.reed = reed;
        this.padReplacementYear = padReplacementYear;
    }

    public boolean isReed() {
        return reed;
    }

    public int getPadReplacementYear() {
        return padReplacementYear;
    }

    public void setReed(boolean reed) {
        this.reed = reed;
    }

    public void setPadReplacementYear(int padReplacementYear) {
        this.padReplacementYear = padReplacementYear;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Reed Instruments.Instrument? " + reed +
                "; Year of last pad replacement: " + padReplacementYear;

    }
}

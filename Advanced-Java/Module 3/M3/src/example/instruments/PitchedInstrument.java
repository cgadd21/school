package example.instruments;

public abstract class PitchedInstrument extends Instrument {
    private String key;
    private String lowestNote;
    private String highestNote;

    public PitchedInstrument() {
    }

    public PitchedInstrument(String name, String brand, String model, int year, boolean playable, String key, String lowestNote, String highestNote) {
        super(name, brand, model, year, playable);
        this.key = key;
        this.lowestNote = lowestNote;
        this.highestNote = highestNote;
    }

    public String getKey() {
        return key;
    }

    public String getLowestNote() {
        return lowestNote;
    }

    public String getHighestNote() {
        return highestNote;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLowestNote(String lowestNote) {
        this.lowestNote = lowestNote;
    }

    public void setHighestNote(String highestNote) {
        this.highestNote = highestNote;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nKey: " + key + "; Range: " + lowestNote + "-" + highestNote;
    }


}

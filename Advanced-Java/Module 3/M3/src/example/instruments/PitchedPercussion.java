package example.instruments;

public abstract class PitchedPercussion extends PitchedInstrument {
    private boolean tunable;
    private String malletType;
    private String strikingSurface;

    public PitchedPercussion() {
    }

    public PitchedPercussion(String name, String brand, String model, int year, boolean playable, String key, String lowestNote, String highestNote, boolean tunable, String malletType, String strikingSurface) {
        super(name, brand, model, year, playable, key, lowestNote, highestNote);
        this.tunable = tunable;
        this.malletType = malletType;
        this.strikingSurface = strikingSurface;
    }

    public boolean isTunable() {
        return tunable;
    }

    public String getMalletType() {
        return malletType;
    }

    public String getStrikingSurface() {
        return strikingSurface;
    }

    public void setTunable(boolean tunable) {
        this.tunable = tunable;
    }

    public void setMalletType(String malletType) {
        this.malletType = malletType;
    }

    public void setStrikingSurface(String strikingSurface) {
        this.strikingSurface = strikingSurface;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Mallet Type: " + malletType + "; Surface Material: " + strikingSurface +
                "Instruments.Tunable Instruments.Instrument? " + tunable;
    }


}

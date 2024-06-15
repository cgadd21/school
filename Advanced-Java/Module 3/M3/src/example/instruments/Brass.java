package example.instruments;

public abstract class Brass extends PitchedInstrument {
    private String mouthpiece;
    private boolean significantlyDented;

    public Brass() {
    }

    public Brass(String name, String brand, String model, int year, boolean playable, String key, String lowestNote, String highestNote, String mouthpiece, boolean significantlyDented) {
        super(name, brand, model, year, playable, key, lowestNote, highestNote);
        this.mouthpiece = mouthpiece;
        this.significantlyDented = significantlyDented;
    }

    public String getMouthpiece() {
        return mouthpiece;
    }

    public void setMouthpiece(String mouthpiece) {
        this.mouthpiece = mouthpiece;
    }

    public boolean isSignificantlyDented() {
        return significantlyDented;
    }

    public void setSignificantlyDented(boolean significantlyDented) {
        this.significantlyDented = significantlyDented;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Mouthpiece Size: " + mouthpiece +
                "\nSignificant Dents? " + significantlyDented;
    }

}

package example.instruments;

public abstract class NonPitchedPercussion extends Instrument{
    private String strikerType;  //hand/mallet/stick
    private String surfaceType;  //membrane/wood/metal/plastic/other
    private boolean orchestral;

    protected NonPitchedPercussion() {
    }

    protected NonPitchedPercussion(String name, String brand, String model, int year, boolean playable, String strikerType, String surfaceType, boolean orchestral) {
        super(name, brand, model, year, playable);
        this.strikerType = strikerType;
        this.surfaceType = surfaceType;
        this.orchestral = orchestral;
    }

    public String getStrikerType() {
        return strikerType;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public boolean isOrchestral() {
        return orchestral;
    }

    public void setStrikerType(String strikerType) {
        this.strikerType = strikerType;
    }

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    public void setOrchestral(boolean orchestral) {
        this.orchestral = orchestral;
    }

    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Striker Type: " + strikerType +
                "; Instruments.Instrument Surface: " + surfaceType +
                "\nOrchestral? " + orchestral;
    }
}

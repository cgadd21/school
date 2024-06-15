package example.instruments;

public class Trumpet extends Brass implements Tunable{

    private boolean pinkyRing;
    private int corkReplacementYear;

    public Trumpet() {
    }

    public Trumpet(String brand, String model, int year, boolean playable, String key, String lowestNote, String highestNote, String mouthpiece, boolean significantlyDented, boolean pinkyRing, int corkReplacementYear) {
        super("Instruments.Trumpet", brand, model, year, playable, key, lowestNote, highestNote, mouthpiece, significantlyDented);
        this.pinkyRing = pinkyRing;
        this.corkReplacementYear = corkReplacementYear;
    }

    public boolean isPinkyRing() {
        return pinkyRing;
    }

    public void setPinkyRing(boolean pinkyRing) {
        this.pinkyRing = pinkyRing;
    }

    public int getCorkReplacementYear() {
        return corkReplacementYear;
    }

    public void setCorkReplacementYear(int corkReplacementYear) {
        this.corkReplacementYear = corkReplacementYear;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Attached Pinky Ring? "  + pinkyRing +
                "\nYear Spit Valve Corks Replaced: " + corkReplacementYear;
    }

    @Override
    public void determineService() {
        if(corkReplacementYear < 2015){
            System.out.println("Instruments.Trumpet needs new spit valve corks and a bath.");
        }
    }

    @Override
    public boolean readyToReplace() {
        if(isSignificantlyDented()){
            return true;
        }
        return false;
    }

    @Override
    public String getTuningInfo() {
        if(getKey().equals("Bb")) {
            return "Best tuned using C and G. Tuning slide should be adjusted accordingly.";
        } else if (getKey().equals("C")){
            return "Best tuned using Bb and F. Tuning slide should be adjusted accordingly.";
        } else {
            return "Need more information.";
        }
    }

    @Override
    public boolean isTuned(int frequency) {
        if(frequency == A_440){
            return true;
        } else {
            return false;
        }
    }
}

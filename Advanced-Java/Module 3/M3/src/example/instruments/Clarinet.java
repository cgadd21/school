package example.instruments;

public class Clarinet extends Woodwind {
    private String type;
    private String bodyMaterial;

    public Clarinet() {
    }


    public Clarinet(String brand, String model, int year, boolean playable, String key, String lowestNote, String highestNote, boolean reed, int padReplacementYear, String type, String bodyMaterial) {
        super("Instruments.Clarinet", brand, model, year, playable, key, lowestNote, highestNote, reed, padReplacementYear);
        this.type = type;
        this.bodyMaterial = bodyMaterial;
    }

    public String getType() {
        return type;
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Type: " + type + "; Body: " + bodyMaterial;
    }

    @Override
    public void determineService() {
        if(getPadReplacementYear() < 2016){
            System.out.println("This clarinet's pads need replaced.");
        }
    }

    @Override
    public boolean readyToReplace() {
        if(getYear() < 1990 && type.equals("Bb")){
            return true;
        }
        return false;
    }


}

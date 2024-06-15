public class iPad extends Products{
    private int screenSize;
    private boolean smartConnector;

    public iPad() {
    }

    public iPad(String color, int releaseYear, int screenSize, boolean smartConnector) {
        super(color, releaseYear);
        this.screenSize = screenSize;
        this.smartConnector = smartConnector;
    }

    public int screenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isSmartConnector() {
        return smartConnector;
    }

    public void setSmartConnector(boolean smartConnector) {
        this.smartConnector = smartConnector;
    }

    @Override
    public String toString() {
        if(!smartConnector){
            return super.toString() +
            "\nThe iPad's screen is " + screenSize + " inches." +
            "\nThe iPad doesn't have a smart connector." + "\n";
        }
        return super.toString() +
        "\nThe iPad's screen is " + screenSize + " inches."+
        "\nThe iPad does have a smart connector." + "\n";
    }

    @Override
    public void readyToReplace() {
        if(getReleaseYear() < 2018 ){
            System.out.println("This iPad needs to be replaced.\n");
        }
    }

}


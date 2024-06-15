package example.instruments;

import java.util.GregorianCalendar;

public abstract class Instrument implements Comparable<Instrument>{
    private String name;
    private String brand;
    private String model;
    private int year;
    private boolean playable;

    protected Instrument() {
    }

    protected Instrument(String name, String brand, String model, int year, boolean playable) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.playable = playable;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    @Override
    public String toString() {
        return year + " " + brand + " " + model + " " + name +
                "\nPlayable? " + playable;
    }
    //Abstract methods - these will be different for each child class
    //therefore I'll let each child class define these as they need.
    //Instruments.Instrument class does not need a definition since no Instruments.Instrument objects
    //will ever be made to call on these.  They will just provide a template
    //for how child classes should override them.

    public abstract void determineService();

    public abstract boolean readyToReplace();

    GregorianCalendar today = new GregorianCalendar();
    //made final so that child classes cannot override it
    public final int returnAge(){
        int currentYear = today.get(GregorianCalendar.YEAR);
        int age = currentYear - year;
        return age;
    }

    //used for comparison purposes for Collections.sort()
    @Override
    public int compareTo(Instrument o) {
        if(this.getYear() == o.getYear()){
            return 0;
        } else if (this.getYear() > o.getYear()){
            return 1;
        } else {
            return -1;
        }
    }

    //The version below does the same thing as the
    //version above, but utilizes the Integer compare
    //method to eliminate redundant code.
    /*@Override
    public int compareTo(Instruments.Instrument o) {
        return Integer.compare(this.year, o.year);
    }*/

    //In case we want to compare by multiple factors...
    //First sort by year, then by instrument name, alphabetically
    //Then by instrument model, alphabetically
/*    @Override
    public int compareTo(Instruments.Instrument o) {
        int result = Integer.compare(this.year, o.year);
        if(result != 0){
            return result;
        }
        result = this.getName().compareTo(o.getName());
        if(result != 0){
            return result;
        }
        return this.getModel().compareTo(o.getModel());
    }*/
}

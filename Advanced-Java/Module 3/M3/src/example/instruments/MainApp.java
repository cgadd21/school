package example.instruments;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Instrument> instruments = new ArrayList<>();
        instruments.add(new Clarinet("Yamaha", "YCL-255", 2018, true, "Bb", "D3", "Bb6", true, 2018, "Bb", "ABS Resin"));
        instruments.add(new SnareDrum("Pearl", "Piccolo", 2010, true, "Wooden Stick", "Plastic Membrane", true, 13.0, 3.0, 9));
        instruments.add(new Trumpet("Bach", "Stradivarius", 1960, false, "Bb", "F#3", "G6", "3C", true, true, 1980));
        instruments.add(new Clarinet("Yamaha", "YCL-255", 2016, true, "Bb", "D3", "Bb6", true, 2018, "Bb", "ABS Resin"));

        for(Instrument temp : instruments){
            System.out.println(temp);
            System.out.println(temp.getName() + " is " + temp.returnAge() + " years old.");
            temp.determineService();
            if(temp.readyToReplace()){
                System.out.println("This instrument should be sold, donated, or recycled.");
            }
            System.out.println();
        }

        //Using the Instruments.Tunable interface methods
        /*int count = 1;
        for(Instruments.Instrument temp : instruments){
            System.out.print(count + ". ");
            count++;
            if(temp instanceof Instruments.Trumpet){
                System.out.println(((Instruments.Trumpet)temp).getTuningInfo());
                if(((Instruments.Trumpet)temp).isTuned(445)){
                    System.out.println("Tuned and ready.");
                } else {
                    System.out.println("Instruments.Trumpet needs tuned.");
                }
            } else {
                System.out.println("We don't care about this instrument.");
            }
        }*/
        System.out.println("*****************************************");
        System.out.println("Pre-sort");
        for(Instrument temp : instruments){
            System.out.println(temp.getName() + " " +
                    temp.getBrand() + " " +
                    temp.getModel() + " " +
                    temp.getYear());
        }
        Collections.sort(instruments);
        System.out.println("After sorting");
        for(Instrument temp : instruments){
            System.out.println(temp.getName() + " " +
                    temp.getBrand() + " " +
                    temp.getModel() + " " +
                    temp.getYear());
        }

    }

}

import java.util.Random;

public class KelvinTempSensor {
    private final int MINREADING = 23315;
    private final int MAXREADING = 38315;
    private final int DEFAULT = 29315;

    private int currentReading;
    private boolean increasing = true;
    private Random rand = new Random();

    public KelvinTempSensor() {
        currentReading = DEFAULT;
    }

    public int reading() {
        final double CUTOFF = 0.8;
        final int MAXCHANGE = 200;
        final int MINCHANGE = 100;
        int temperatureChange;

        if (rand.nextDouble() > CUTOFF) {
            increasing =! increasing;
        }

        temperatureChange = rand.nextInt(MAXCHANGE - MINCHANGE) + MAXCHANGE;
        currentReading = currentReading + temperatureChange * (increasing ? 1 : -1);

        if(currentReading >= MAXREADING) {
            currentReading = MAXREADING;
            increasing = false;
        } else if (currentReading <= MINREADING) {
            currentReading = MINREADING;
            increasing = true;
        }

        return currentReading ;
    }
}

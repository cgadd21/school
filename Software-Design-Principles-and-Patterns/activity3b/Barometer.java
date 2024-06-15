import java.util.Random;

public class Barometer {
    private final double MIN = 27.0;
    private final double MAX = 32.0;
    private final double DEFAULT = 29.92;

    private double currentPressure;
    private boolean increasing = true;
    private Random rand = new Random();

    public Barometer() {
        currentPressure = DEFAULT;
    }
    
    public double pressure() {
        final double CUTOFF = 0.75;
        final double MAXDELTA = 0.2;
        double pressureChange;

        if (rand.nextDouble() > CUTOFF) {
            increasing =! increasing;
        }

        pressureChange = rand.nextDouble() * MAXDELTA;
        currentPressure = currentPressure + pressureChange * (increasing ? 1 : -1);

        if(currentPressure >= MAX) {
            currentPressure = MAX;
            increasing = false;
        } else if (currentPressure <= MIN) {
            currentPressure = MIN;
            increasing = true;
        }

        return currentPressure;
    }
}

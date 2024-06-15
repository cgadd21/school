
import java.util.Observable;

@SuppressWarnings("deprecation")
public class WeatherStation extends Observable implements Runnable {

    private final KelvinTempSensor sensor;
    private final Barometer barometer;

    private final long PERIOD = 1000;
    private final int KTOC = -27315;

    private int currentReading;
    private double currentPressure;

    public WeatherStation() {
        sensor = new KelvinTempSensor();
        barometer = new Barometer();
        currentReading = sensor.reading();
        currentPressure = barometer.pressure();
    }

    public void run() {
        while( true ) {
            try {
                Thread.sleep(PERIOD);
            } catch (Exception e) {}

            synchronized(this) {
                currentReading = sensor.reading();
                currentPressure = barometer.pressure();
            }
            setChanged();
            notifyObservers();
        }
    }

    public synchronized double getKelvin() {
        return currentReading / 100.0;
    }

    public synchronized double getCelsius() {
        return (currentReading + KTOC) / 100.0;
    }

    public synchronized double getFahrenheit() {
        return (currentReading + KTOC) / 100.0 * 1.8 + 32;
    }

    public synchronized double getInches() {
        return currentPressure;
    }

    public synchronized double getMillibars() {
        return currentPressure * 33.864;
    }
}

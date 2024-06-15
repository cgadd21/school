import java.util.Observable;

@SuppressWarnings("deprecation")
public class WeatherStation extends Observable implements Runnable {

    private final KelvinTempSensor sensor;

    private final long PERIOD = 1000;
    private final int KTOC = -27315;

    private int currentReading;

    public WeatherStation() {
        sensor = new KelvinTempSensor();
        currentReading = sensor.reading();
    }

    public void run() {
        while( true ) {
            try {
                Thread.sleep(PERIOD);
            } catch (Exception e) {}

            synchronized(this) {
                currentReading = sensor.reading();
            }
            setChanged();
            notifyObservers();
        }
    }

    public synchronized double getCelsius() {
        return (currentReading + KTOC) / 100.0;
    }

    public synchronized double getKelvin() {
        return currentReading / 100.0;
    }
}

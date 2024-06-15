import java.util.Observer;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class TextUI implements Observer {
    private final WeatherStation station;

    public TextUI(WeatherStation station) {
        this.station = station;
        this.station.addObserver(this);
    }

    public void update(Observable obs, Object ignore) {
        if(station != obs) {
            return;
        }
        
        System.out.printf (
            "Temperature: %6.2f C %6.2f F %6.2f K%nPressure: %9.2f inches %6.2f mbar%n%n",
            station.getCelsius(), station.getFahrenheit(), station.getKelvin(), station.getInches(), station.getMillibars()
        );
    }
}

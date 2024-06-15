import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Observer;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class SwingUI extends JFrame implements Observer {
    private final WeatherStation station;
    private JLabel celsiusField;
    private JLabel kelvinField;
    private JLabel fahrenheitField;
    private JLabel inchesField;
    private JLabel millibarsField;

    private static Font labelFont = new Font(Font.SERIF, Font.PLAIN, 40);

    public SwingUI(WeatherStation station) {
        super("Weather Station");
        this.setLayout(new GridLayout(1,0));
        JPanel panel;

        panel = new JPanel(new GridLayout(2,1));
        this.add(panel);
        createLabel(" Kelvin ", panel);
        kelvinField = createLabel("", panel);

        panel = new JPanel(new GridLayout(2,1));
        this.add(panel);
        createLabel(" Celsius ", panel);
        celsiusField = createLabel("", panel);

        panel = new JPanel(new GridLayout(2,1));
        this.add(panel);
        createLabel(" Fahrenheit ", panel);
        fahrenheitField = createLabel("", panel);

        panel = new JPanel(new GridLayout(2,1));
        this.add(panel);
        createLabel(" Inches ", panel);
        inchesField = createLabel("", panel);

        panel = new JPanel(new GridLayout(2,1));
        this.add(panel);
        createLabel(" Millibars ", panel);
        millibarsField = createLabel("", panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        this.station = station;
        this.station.addObserver(this);
    }

    public void setKelvinJLabel(double temperature) {
        kelvinField.setText(String.format("%6.2f", temperature));
    }

    public void setCelsiusJLabel(double temperature) {
        celsiusField.setText(String.format("%6.2f", temperature));
    }

    public void setFahrenheitJLabel(double temperature) {
        fahrenheitField.setText(String.format("%6.2f", temperature));
    }

    public void setInchesJLabel(double pressure) {
        inchesField.setText(String.format("%6.2f", pressure));
    }

    public void setMillibarsJLabel(double pressure) {
        millibarsField.setText(String.format("%6.2f", pressure));
    }

    private JLabel createLabel(String title, JPanel panel) {
        JLabel label = new JLabel(title);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(labelFont);
        panel.add(label);

        return label;
    }

    public void update(Observable obs, Object ignore) {
        if(station != obs) {
            return;
        }

        setCelsiusJLabel(station.getCelsius());
        setKelvinJLabel(station.getKelvin());
        setFahrenheitJLabel(station.getFahrenheit());
        setInchesJLabel(station.getInches());
        setMillibarsJLabel(station.getMillibars());
    }
}

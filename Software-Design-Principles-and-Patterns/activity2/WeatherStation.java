import java.util.Scanner;

public class WeatherStation {
    private final KelvinTempSensor sensor;
    private final int KTOC = -27315;

    private int reading;
    public double celsius;
    public double kelvin;

    public WeatherStation() {
        sensor = new KelvinTempSensor();
    }

    public void getTemp() {
        reading = sensor.reading();
        celsius = (reading + KTOC) / 100.0;
        kelvin = reading / 100.0;
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        AWTUI awt = new AWTUI();
        SwingUI swing = new SwingUI();
        Text text = new Text();
        Scanner scanner = new Scanner(System.in);

        System.out.println("How could you like to display your data?\n1. AWT\n2. Swing\n3. Text");
        int displayOption = scanner.nextInt();
        scanner.close();

        awt.setVisible(displayOption == 1);
        swing.setVisible(displayOption == 2);
        text.setVisible(displayOption == 3);

        while(true) {
            try {
                Thread.sleep(1000);

                weatherStation.getTemp();

                if(awt.isVisible()) {
                    awt.setCelsiusJLabel(weatherStation.celsius);
                    awt.setKelvinJLabel(weatherStation.kelvin);
                }

                if(swing.isVisible()) {
                    swing.setCelsiusJLabel(weatherStation.celsius);
                    swing.setKelvinJLabel(weatherStation.kelvin);
                }

                if(text.isVisible()) {
                    text.setCelsius(weatherStation.celsius);
                    text.setKelvin(weatherStation.kelvin);
                    text.print();
                }
            } catch (Exception e) {}
        }
    }
}
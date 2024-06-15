public class App {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        Thread thread = new Thread(ws);
        new TextUI(ws);
        new SwingUI(ws);
        thread.start();
    }
}

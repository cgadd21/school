package Phase2;

public class MainApp4 {
    public static void main(String[] args) {

        new Thread(new PrintChar('A', 10000)).start();
        new Thread(new PrintChar('B', 10000)).start();
        new Thread(new PrintChar('C', 10000)).start();
        new Thread(new PrintChar('D', 10000)).start();
        new Thread(new PrintChar('E', 10000)).start();
        new Thread(new PrintChar('F', 10000)).start();

    }
}

package Phase2;

public class MainApp3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintChar('A', 10000));
        Thread thread2 = new Thread(new PrintChar('B', 10000));
        Thread thread3 = new Thread(new PrintChar('C', 10000));
        Thread thread4 = new Thread(new PrintChar('D', 10000));
        Thread thread5 = new Thread(new PrintChar('E', 10000));
        Thread thread6 = new Thread(new PrintChar('F', 10000));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

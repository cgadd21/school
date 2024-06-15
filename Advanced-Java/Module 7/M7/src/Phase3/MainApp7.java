package Phase3;

public class MainApp7 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("A");
            }
        });

        thread1.start();

        //The start methods being called on a new Thread with no name that is using lambda to define the run method
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("B");
            }
        }).start();
    }
}

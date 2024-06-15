package Phase3;

public class MainApp5 {
    public static void main(String[] args) {
        Runnable printA = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    System.out.print("A");
                }
            }
        };

        Thread thread1 = new Thread(printA);
        thread1.start();
        //OR
        new Thread(printA).start();
    }
}

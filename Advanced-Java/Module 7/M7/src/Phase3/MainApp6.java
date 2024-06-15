package Phase3;

public class MainApp6 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    System.out.print("A");
                }
            }
        });

        thread1.start();
    }
}

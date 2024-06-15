package Phase3;

public class MainApp8 {
    public static void main(String[] args) {

        //calling static method from within run method - long way
        new Thread(new Runnable(){
            @Override
            public void run() {
                printStuff('A', 10000);
            }
        }).start();

        //calling static method from within run method using lambda
        new Thread(()->printStuff('B', 10000)).start();
        new Thread(()->printStuff('C', 10000)).start();
        new Thread(()->printStuff('D', 10000)).start();
        new Thread(()->printStuff('E', 10000)).start();
        new Thread(()->printStuff('F', 10000)).start();
    }

    public static void printStuff(char letter, int times){
       for (int i = 0; i < times; i++) {
           System.out.print(letter);
       }
    }
}

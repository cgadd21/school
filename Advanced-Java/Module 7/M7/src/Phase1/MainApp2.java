package Phase1;

public class MainApp2 {
    public static void main(String[] args) {
        PrintChar task1 = new PrintChar('A', 10000);
        PrintChar task2 = new PrintChar('B', 10000);
        PrintChar task3 = new PrintChar('C', 10000);
        PrintChar task4 = new PrintChar('D', 10000);
        PrintChar task5 = new PrintChar('E', 10000);
        PrintChar task6 = new PrintChar('F', 10000);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        Thread thread4 = new Thread(task4);
        Thread thread5 = new Thread(task5);
        Thread thread6 = new Thread(task6);
        /*Setting thread priorities does not guarantee a particular order.
          Think of it more as a suggestion...
         */
        thread1.setPriority(Thread.MIN_PRIORITY);
/*        thread2.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread4.setPriority(Thread.NORM_PRIORITY);
        thread5.setPriority(Thread.MAX_PRIORITY);*/
        thread6.setPriority(Thread.MAX_PRIORITY);

/*        System.out.println(thread1.getPriority());
        System.out.println(thread2.getPriority());
        System.out.println(thread3.getPriority());
        System.out.println(thread4.getPriority());
        System.out.println(thread5.getPriority());
        System.out.println(thread6.getPriority());*/

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

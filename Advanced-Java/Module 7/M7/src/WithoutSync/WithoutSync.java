package WithoutSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithoutSync {
    public static void main(String[] args) {
        //The object to be accessed
        Account account = new Account();

        //The defined task of adding one dollar to the account balance
        Runnable addDollar = new Runnable() {
            @Override
            public void run() {
                account.deposit(1.00);
            }
        };

        //The thread pool so that we can run this task 10000 times
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            exec.execute(addDollar);
        }
        exec.shutdown();

        //Check to see if threads are still running...
        while (!exec.isTerminated()) {
            //Just waiting until threads are done...
            //Empty loop runs until all thread are done...
        }
        System.out.println("What is the balance? " + account.getBalance());
    }
}

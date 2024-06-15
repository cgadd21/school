package WithSyncLocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithSyncLocking {
    public static void main(String[] args) {
        Account account = new Account();

        Runnable addDollar = new Runnable() {
            @Override
            public void run() {
                account.deposit(1.00);
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10000; i++){
            exec.execute(addDollar);
        }
        exec.shutdown();

        while(!exec.isTerminated()) {
            //Just waiting until threads are done...
        }
        System.out.println("What is the balance? " + account.getBalance());
    }
}

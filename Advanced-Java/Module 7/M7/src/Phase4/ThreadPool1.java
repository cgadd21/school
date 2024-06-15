package Phase4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool1 {
    public static void main(String[] args) {
        //Creating a thread pool with fixed allows you to control
        //how many threads can run at once.  Only 3 will run at a time.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new PrintChar('A', 1000));
        executor.execute(new PrintChar('B', 1000));
        executor.execute(new PrintChar('C', 1000));
        executor.execute(new PrintChar('D', 1000));
        executor.execute(new PrintChar('E', 1000));
        executor.execute(new PrintChar('F', 1000));
        executor.execute(new PrintChar('G', 1000));
        executor.execute(new PrintChar('H', 1000));

        executor.shutdown();
    }
}

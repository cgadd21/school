package Phase4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool2 {
    public static void main(String[] args) {
        //Creating a thread pool with cached allows you to let
        //more threads run at a time while still reusing those as they
        //finish.
        ExecutorService executor = Executors.newCachedThreadPool();

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

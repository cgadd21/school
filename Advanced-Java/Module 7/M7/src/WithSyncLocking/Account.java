package WithSyncLocking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private double balance = 0;

    public Account() {
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        lock.lock();
        balance += amount;
        lock.unlock();
    }
}

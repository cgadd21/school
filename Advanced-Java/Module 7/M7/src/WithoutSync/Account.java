package WithoutSync;

public class Account {
    private double balance = 0;

    public Account() {
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
}

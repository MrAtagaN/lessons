package multithreading.dead_lock;


import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    private volatile int balance;
    private AtomicInteger failTransactions;

    public Account(int balance) {
        this.balance = balance;
    }

    /**
     * Снять дениги
     */
    public void withdraw(int amount) {
        balance -= amount;
    }

    /**
     * Положить деньги
     */
    public void deposit(int amount) {
        balance += amount;
    }

    public void incrementFails() {
        failTransactions.addAndGet(1);
    }

    public int getBalance() {
        return balance;
    }

    public AtomicInteger getFailTransactions() {
        return failTransactions;
    }


}

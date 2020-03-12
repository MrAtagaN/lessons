package multithreading.executors;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    Lock lock = new ReentrantLock();
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

    public Lock getLock() {
        return lock;
    }
}

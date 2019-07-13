package core.multithreading.core;


public class Account {

    private volatile int balance;

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

    public int getBalance() {
        return balance;
    }
}

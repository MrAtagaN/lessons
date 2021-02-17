package multithreading.dead_lock;


/**
 * DEAD LOCK
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        final Account account_1 = new Account(10_000);
        final Account account_2 = new Account(10_000);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                transfer(account_1, account_2, 1);
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                transfer(account_2, account_1, 1);
            }
        });
        thread2.start();

        thread.join();
        thread2.join();
        System.out.println("ACCOUNT 1 AMOUNT: " + account_1.getBalance());
        System.out.println("ACCOUNT 2 AMOUNT: " + account_2.getBalance());
    }


    /**
     * Перевести деньги с одного аккаунта на другой
     */
    public static void transfer(Account acc1, Account acc2, int amount) {
        if (acc1.getBalance() < amount) {
            throw new RuntimeException("NO MONEY ON ACCOUNT");
        }

        //DEAD LOCK  , чтобы избежать нужно блокировать объекты в одном порядке (например по id)
        //В консоле вызвать jconsole в папке Java\jdk1.8.0_211\lib
        synchronized (acc1) {
            synchronized (acc2) {
                acc1.withdraw(amount);
                acc2.deposit(amount);
                System.out.println("TRANSFER MONEY: " + amount);
            }
        }
    }

}

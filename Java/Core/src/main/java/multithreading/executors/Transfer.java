package multithreading.executors;

import java.util.concurrent.Callable;

public class Transfer implements Callable<Boolean> {

    private Account accountFrom;
    private Account accountTo;
    private int amount;

    public Transfer(Account accountFrom, Account accountTo, int amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        if (accountFrom.getBalance() < amount) {
            throw new RuntimeException("NO MONEY ON ACCOUNT");
        }
        if (Math.random() > 0.9) {
            throw new RuntimeException("RANDOM EXCEPTION");  //случайный Exception
        }
        System.out.println("TRY TO LOCK accountFrom");
        if (accountFrom.getLock().tryLock()) {
            try {
                System.out.println("TRY TO LOCK accountTo");
                if (accountTo.getLock().tryLock()) {
                    try {
                        accountFrom.withdraw(amount);
                        accountTo.deposit(amount);
                        System.out.println("TRANSFER MONEY: "+ amount);
                        return true;
                    } finally {
                        System.out.println("UNLOCK accountTo");
                        accountTo.getLock().unlock();
                    }
                } else {
                    return false;
                }
            } finally {
                System.out.println("UNLOCK accountFrom");
                accountFrom.getLock().unlock();
            }
        } else {
            return false;
        }

//        accountFrom.withdraw(amount);
//        accountTo.deposit(amount);
//        LOG.info("TRANSFER MONEY: {}", amount);
//        return true;
    }
}

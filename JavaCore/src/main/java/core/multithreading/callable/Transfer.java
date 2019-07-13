package core.multithreading.callable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;


public class Transfer implements Callable<Boolean> {

    public static final Logger LOG = LoggerFactory.getLogger(Transfer.class);
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

        if (accountFrom.getLock().tryLock() && accountTo.getLock().tryLock()) {
            try {
                accountFrom.withdraw(amount);
                accountTo.deposit(amount);
                LOG.info("TRANSFER MONEY: {}", amount);
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
                return true;
            }

        } else {
            accountFrom.getLock().unlock();
            accountTo.getLock().unlock();
            return false;
        }

    }
}

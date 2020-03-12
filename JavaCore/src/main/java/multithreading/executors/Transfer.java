package multithreading.executors;

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
        if (Math.random() > 0.9) {
            throw new RuntimeException("RANDOM EXCEPTION");  //случайный Exception
        }
        LOG.info("TRY TO LOCK accountFrom");
        if (accountFrom.getLock().tryLock()) {
            try {
                LOG.info("TRY TO LOCK accountTo");
                if (accountTo.getLock().tryLock()) {
                    try {
                        accountFrom.withdraw(amount);
                        accountTo.deposit(amount);
                        LOG.info("TRANSFER MONEY: {}", amount);
                        return true;
                    } finally {
                        LOG.info("UNLOCK accountTo");
                        accountTo.getLock().unlock();
                    }
                } else {
                    return false;
                }
            } finally {
                LOG.info("UNLOCK accountFrom");
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

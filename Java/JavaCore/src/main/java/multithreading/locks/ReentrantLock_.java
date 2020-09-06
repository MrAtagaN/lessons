package multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLock_ {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();

            boolean tryLock = lock.tryLock(1000, TimeUnit.MICROSECONDS);
            System.out.println(tryLock);

            Condition condition = lock.newCondition();
            //вызывается в блоках между lock и unlock
            condition.await(); //аналог wait
            condition.signal(); //аналог notify


        } finally {
            lock.unlock();
        }
    }
}

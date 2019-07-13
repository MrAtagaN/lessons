package core.multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        lock.tryLock(1000, TimeUnit.MICROSECONDS);
        try {

        } finally {
            lock.unlock();
        }
    }
}

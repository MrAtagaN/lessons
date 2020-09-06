package multithreading.locks;

import java.util.concurrent.CountDownLatch;


public class CountDownLatch_ {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Worker(countDownLatch).start();
        new Worker(countDownLatch).start();
        new Worker(countDownLatch).start();

        countDownLatch.await(); //ждем пока счетчик countDownLatch не будет 0
        System.out.println("All work is done");
    }


    static class Worker extends Thread {

        private CountDownLatch countDownLatch;

        public Worker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("Do work");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End work");
            countDownLatch.countDown();
        }
    }
}

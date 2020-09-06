package multithreading.locks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * https://javarush.ru/groups/posts/2111-threadom-java-ne-isportishjh--chastjh-vi---k-barjheru
 */
public class CyclicBarrier_ {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Runner(cyclicBarrier).start();
        new Runner(cyclicBarrier).start();
        new Runner(cyclicBarrier).start();

        //cyclicBarrier можно переиспользовать
        //new Runner(cyclicBarrier).start();
        //new Runner(cyclicBarrier).start();
        //new Runner(cyclicBarrier).start();
    }


    static class Runner extends Thread {

        private CyclicBarrier cyclicBarrier;

        public Runner(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("Ready to start");
            try {
                Thread.sleep(500);
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Start run");
        }
    }
}

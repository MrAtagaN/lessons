package collections.list.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * {@link CopyOnWriteArrayList}
 *
 * Тест скорости чтения CopyOnWriteArrayList двумя потоками
 */
public class CopyOnWriteArrayList_ {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list2 = new CopyOnWriteArrayList<>();

        fillList(list1, 100);
        fillList(list2, 100);

        System.out.println("List synchronized:");
        checkList(list1);

        System.out.println("CopyOnWriteArrayList:");
        checkList(list2);
    }


    private static void checkList(List<Integer> list) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Long> future = executorService.submit(new ListRunner(0, 50, list, latch));
        Future<Long> future2 = executorService.submit(new ListRunner(50, 100, list, latch));

        latch.countDown();

        System.out.println("Thread 1: " + future.get() / 1000 + "ms");
        System.out.println("Thread 2: " + future2.get() / 1000 + "ms");

        executorService.shutdown();
    }


    private static class ListRunner implements Callable<Long> {

        private int start;
        private int end;
        private List<Integer> list;
        CountDownLatch latch;

        public ListRunner(int start, int end, List<Integer> list, CountDownLatch latch) {
            this.start = start;
            this.end = end;
            this.list = list;
            this.latch = latch;
        }

        @Override
        public Long call() throws Exception {
            latch.await();
            long time = System.nanoTime();
            for (int i = start; i < end; i++) {
                list.get(i);
            }
            return System.nanoTime() - time;
        }
    }


    private static void fillList(List<Integer> list, int number) {
        for (int i = 0; i < number; i++) {
            list.add(number);
        }
    }
}

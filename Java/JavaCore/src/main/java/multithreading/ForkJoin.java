package multithreading;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Cуммирование всех чисел
 *
 * forkJoinPool.invoke(ForkJoinTask) - выполняет переданную задачу, запускает compute()
 *
 * RecursiveTask extends ForkJoinTask
 * compute - основная операция вычисления
 * fork - вызвать метод compute в другой нити (асинхронно)
 * join - ждать результата fork
 */
public class ForkJoin {

    private static long numOfOperations = 1_000_000_000L;
    private static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println("Number of threads: " + numOfThreads);
        System.out.println("Executing...");
        long start = System.currentTimeMillis();

        //обычный цикл
//        BigInteger result = BigInteger.valueOf(0);
//        for (long i = 0; i < numOfOperations; i++) {
//            result = result.add(BigInteger.valueOf(i));
//        }
//        System.out.println(result); //499999999500000000  Execution time: 26537 ms

        //forkJoin
        ForkJoinPool forkJoinPool = new ForkJoinPool(numOfThreads);
        BigInteger forkJoinResult = forkJoinPool.invoke(new MyFork(0, numOfOperations));
        System.out.println(forkJoinResult); //499999999500000000  Execution time: 15609 ms

        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
    }


    /**
     * compute() - операция вычисления
     * fork() - вызвать метод compute в другой нити
     * join() - ждать результата compute
     */
    static class MyFork extends RecursiveTask<BigInteger> {

        private long from;
        private long to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected BigInteger compute() {
            // если данные разбиты достаточно мелко (часть операций <= количество всех операций/количество нитей),
            // то выполняем операцию
            if ((to - from) <= numOfOperations / numOfThreads) {
                BigInteger result = BigInteger.valueOf(0);
                for (long i = from; i < to; i++) {
                    result = result.add(BigInteger.valueOf(i));
                }
                return result;
            } else { //иначе разбивам на две части. Сначала одну часть запускаем в новом потоке, затем у второй части
                     //вызываем compute(). Возвращаем результат суммы двух частей
                long middle = (from + to) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                MyFork secondHalf = new MyFork(middle, to);
                firstHalf.fork();
                BigInteger compute = secondHalf.compute();
                return firstHalf.join().add(compute);
            }
        }
    }
}

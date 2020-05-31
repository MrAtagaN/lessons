package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * {@link Callable} - асинхроная задача, которая должна вернуть результат
 * Методы:
 * call - метод возвращающий результат
 *
 *
 * {@link Future} - интерфейс для работы с асинхронной задачей, которая должна вернуть результат
 * Методы:
 * cancel -
 * isCancelled -
 * isDone -
 * get -
 *
 *
 * {@link FutureTask} - Класс имплементирующий интерфейс {@link Future} и {@link Runnable}
 * Его можно запускать в отдельном потоке
 *
 */
public class Callable_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        //запускаем futureTask в отдельном потоке
        new Thread(futureTask).start();

        //ждем выполнения
        System.out.println(futureTask.get());
    }


    /**
     * Вычисление, которое нужно выполнять в отдельном потоке
     */
    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("compute...");
            Thread.sleep(2000);
            return 100;
        }
    }
}

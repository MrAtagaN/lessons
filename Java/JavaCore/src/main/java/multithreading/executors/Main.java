package multithreading.executors;

import java.util.concurrent.*;

/**
 * {@link Executors} - фабрика создающая {@link ExecutorService}
 * Методы:
 *
 * ScheduledThreadPool
 * FixedThreadPool
 * SingleThreadExecutor
 * CachedThreadPool
 *
 *
 * {@link Executor}
 * Методы:
 * execute - выполнить команду, ничего не возвращает
 *
 * {@link ExecutorService}
 * Методы:
 * shutdown -
 * awaitTermination -
 * invokeAll -
 * isTerminated -
 * shutdownNow -
 *
 * submit - возвращает объект {@link Future}. При вызове у него get - получаем значение
 *  или ждём пока завершится метод, или получаем исключение нити
 *
 *
 * https://javarush.ru/groups/posts/2078-threadom-java-ne-isportishjh--chastjh-v---executor-threadpool-fork-join-pool
 */
public class Main {

    public static void main(String[] args) {
        final Account account_1 = new Account(10_000);
        final Account account_2 = new Account(10_000);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++) {
            //запускаем таски
            Future<Boolean> future = executorService.submit(new Transfer(account_1, account_2, 1));

            // выводим ответ
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(future.get());  // получаем значение или ждём его , или получаем исключение нити
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("EXCEPTION IN TASK");
                }
            });
            thread.start();
        }

        executorService.shutdown();
        System.out.println("END");
    }
}

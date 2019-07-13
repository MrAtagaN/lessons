package core.multithreading.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {

    public static void main(String[] args) {
        final Account account_1 = new Account(10_000);
        final Account account_2 = new Account(10_000);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++) {
            //запускаем таски
            Future<Boolean> future = executorService.submit(new Transfer(account_1, account_2, 1));

            // выводим ответ
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }).start();

        }

        executorService.shutdown();
        System.out.println("END");
    }
}

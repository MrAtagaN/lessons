package core.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * https://habr.com/ru/post/213319/
 */
public class CompletableFuture_ {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        /**
         * Интерфейс непосредственной записи
         */

        //если не завершен, то устанавливает возвращаемое значение
        completableFuture.complete(2);

        //вернуть ошибку
        completableFuture.completeExceptionally(new RuntimeException());
        completableFuture.cancel(true);

        //completableFuture c результатом
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.completedFuture(2);

        /**
         * Интерфейс непосредственного чтения
         */

        //Проверяет, был ли уже записан результат
        completableFuture.isDone();

        //Ждет, если результат еще не записан, и возвращает значение
        completableFuture.get();

        completableFuture.isCancelled();

        //возвращает результат немедленно. Если результат еще не записан, возвращает значение параметра valueIfAbsent
        completableFuture.getNow(2);

        //примерное число других CompletableFuture, ждущих заполнения данного
        completableFuture.getNumberOfDependents();

        /**
         * Интерфейс асинхронного выполнения
         */
        //Запускается задача с функцией Supplier. Запуск задачи производится на стандартном пуле потоков
        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            return 2;
        });

        //Запускается задача Runnable
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("--");
        });




    }


}

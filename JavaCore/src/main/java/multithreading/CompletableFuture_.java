package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * {@link CompletableFuture} - Асинхронное выполнение методов, возвращающих результат.
 * Можно делать цепочки последовательного выполнения методов.
 * Можно ждать выполнения нескольких асинхронных методов.
 *
 *
 * Непосредственная запись
 *
 * complete(value) - если не завершен, то устанавливает возвращаемое значение
 * completeExceptionally() - вернуть ошибку
 * cancel() -
 *
 *
 * Непосредственное чтение
 *
 * isDone() - проверяет, был ли уже записан результат
 * get() - ждет, если результат еще не записан, и возвращает значение
 * isCancelled() -
 * getNow(valueIfAbsent) - возвращает результат немедленно. Если результат еще не записан,
 *   возвращает значение параметра valueIfAbsent
 *
 *
 * Асинхронное выполнение
 *
 * supplyAsync(Supplier<U>) - запускается задача с функцией Supplier
 * runAsync(Runnable) - запускается задача Runnable
 *
 *
 * Асинхронное выполнение с аргументом из предыдущего completableFuture
 *
 * thenApply(Function) - принимает аргумент из completableFuture и возвращает результат
 * thenAccept(Consumer) - принимает аргумент из completableFuture и ничего не возвращает
 *
 * anyOf(CompletableFuture...) - возвращает новый completableFuture, когда выполнится любой из аргументов
 * applyToEither(otherFuture, Function) - возвращает новый completableFuture, который заполняется когда выполнится данный
 *   completableFuture либо completableFuture, переданный параметром other
 *
 * thenCombine(otherFuture, BiFunction) - передаваемый аргумент completableFuture и otherFuture
 *   передаются в функцию BiFunction
 *
 * allOf(CompletableFuture...) - возвращает CompletableFuture, завершающееся по завершению всех completableFuture в списке параметров
 *
 *
 * https://habr.com/ru/post/213319/
 * youtube.com/watch?v=hqR41XVx3kM
 * https://javarush.ru/groups/posts/2065-threadom-java-ne-isportishjh--chastjh-iv---callable-future-i-druzjhja
 */
public class CompletableFuture_ {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        writeResult();
        readResult();
        asyncExecute();
        asyncChainExecute();
        waitAsyncExecute();
    }



    /**
     * Интерфейс непосредственной записи
     */
    private static void writeResult() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        //если не завершен, то устанавливает возвращаемое значение
        completableFuture.complete(3);

        //вернуть ошибку
        completableFuture.completeExceptionally(new RuntimeException());
        completableFuture.cancel(true);

        //completableFuture c результатом (статический метод)
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.completedFuture(2);
    }


    /**
     * Интерфейс непосредственного чтения
     */
    private static void readResult() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        //проверяет, был ли уже записан результат
        completableFuture.isDone();

        //ждет, если результат еще не записан, и возвращает значение
        completableFuture.get();

        completableFuture.isCancelled();

        //возвращает результат немедленно. Если результат еще не записан, возвращает значение параметра valueIfAbsent
        completableFuture.getNow(2);

        //примерное число других CompletableFuture, ждущих заполнения данного
        completableFuture.getNumberOfDependents();
    }


    /**
     * Асинхронное выполнение
     */
    private static void asyncExecute() {
        //Запускается задача Supplier. Запуск задачи производится на стандартном пуле потоков
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return 2;
        });

        //Запускается задача Runnable
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("--");
        });
    }


    /**
     * Асинхронное выполнение с аргументом из предыдущего completableFuture
     */
    private static void asyncChainExecute() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        //принимает аргумент из completableFuture и возвращает результат
        completableFuture.thenApply((compl) -> {return compl + 2;});

        //принимает аргумент из completableFuture и ничего не возвращает
        completableFuture.thenAccept((compl) -> {
            System.out.println(2);
        });


        completableFuture.thenCombine(null,null);
        completableFuture.applyToEither(null,null); //TODO
    }


    /**
     * Ожидание выполнения нескольких асинхронных задач
     */
    private static void waitAsyncExecute() {
        CompletableFuture.anyOf();
        CompletableFuture.allOf();
    }


}

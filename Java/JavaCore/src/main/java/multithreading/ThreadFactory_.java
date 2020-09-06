package multithreading;

import java.util.concurrent.ThreadFactory;

/**
 * Интерфейс {@link ThreadFactory}
 * Метод:
 * newThread - возвращает нить
 */
public class ThreadFactory_ {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };

        threadFactory.newThread(() -> System.out.println("Hello")).start();
    }
}

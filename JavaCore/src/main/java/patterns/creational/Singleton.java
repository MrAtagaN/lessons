package patterns.creational;

/**
 * https://habr.com/ru/post/129494/
 * https://habr.com/ru/post/27108/
 */
public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }

    private Singleton() {
    }
}

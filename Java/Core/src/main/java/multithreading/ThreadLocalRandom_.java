package multithreading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * {@link ThreadLocalRandom}
 */
public class ThreadLocalRandom_ {

    public static void main(String[] args) {
        System.out.println("Random int: " + ThreadLocalRandom.current().nextInt());

        System.out.println("Mills in day: " + TimeUnit.DAYS.toMillis(1));
    }
}

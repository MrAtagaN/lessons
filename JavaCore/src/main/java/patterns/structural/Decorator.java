package patterns.structural;

import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * (Wrapper)
 * Декоратор оборачивает некоторый класс и предоставляет такой же или расширенный интерфейс.
 * Иногда декоратор называют "умным заместителем" (smart proxy). Т.е. декоратор может притворяться
 * оригинальным классом и при этом расширять его функциональность.
 */
public class Decorator {

    public static void main(String[] args) {
        InputStream inputStream = System.in;

        //BufferedInputStream - декоратор
        InputStream inputStream2 = new BufferedInputStream(System.in);

    }
}

package core.exceptions;


import java.util.Arrays;

/**
 * {@link Throwable} -
 *
 * Методы {@link Throwable}:
 *
 * addSuppressed -
 * getSuppressed -
 * fillInStackTrace -
 * getCause -
 * getLocalizedMessage -
 * getMessage -
 * getStackTrace -
 * initCause -
 * printStackTrace -
 * setStackTrace -
 */
public class Throwable_ {

    public static void main(String[] args) throws Throwable {
        Throwable throwable = new Throwable(new IndexOutOfBoundsException("my message"));
        System.out.println(throwable.getCause());
        System.out.println(throwable.getMessage());
        System.out.println(throwable.getLocalizedMessage());
        System.out.println(Arrays.toString(throwable.getStackTrace()));


    }
}

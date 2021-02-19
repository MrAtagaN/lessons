package core.IO;

/**
 * {@link System} - потоки стандартного ввода, стандартного вывода и вывода ошибок;
 * доступ к внешним свойствам и переменным среды; средство загрузки файлов и библиотек;
 * метод для быстрого копирования части массива.
 *
 * Методы System:
 *
 * arraycopy -
 * clearProperty -
 * console -
 * currentTimeMillis -
 * exit -
 * gc -
 * getenv -
 * getProperty -
 * getProperties -
 * setProperties -
 * setSecurityManager -
 * getSecurityManager -
 * identityHashCode -
 * lineSeparator -
 * inheritedChannel -
 * load -
 * loadLibrary -
 * mapLibraryName -
 * nanoTime -
 * runFinalization -
 * setErr -
 * setIn -
 * setOut -
 *
 *
 */
public class System_ {

    public static void main(String[] args) {
        System.arraycopy(new int[5],0,new int[5], 0 ,100);

    }
}

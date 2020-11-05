package core.IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * InputStream - абстрактный класс читающий байты
 *
 * Методы inputStream:
 * available() - Количество непрочитанных байт
 * read() - считать следующий байт
 * read(byte[]) - считывает байты из потока в массив, возвращает количество считанных байт
 * markSupported() - поддерживает ли поток механизм меток
 * mark() - поставить метку в определенную позицию
 *
 *
 * BufferedInputStream - буферезированный inputStream, обертка позволяющая оптимизировать работу
 */
public class InputStream_OutputStream {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("TODO.txt");
        System.out.println("available() " + inputStream.available());
        System.out.println("markSupported() " + inputStream.markSupported());
        System.out.println("read() " + inputStream.read());
        byte[] b = new byte[1024];
        System.out.println("read(byte[]) " + inputStream.read(b) + "\r\n");
        inputStream.close();

        //Считывание файла InputStream
        try (InputStream inputStream2 = new FileInputStream("TODO.txt")) {
            byte[] buf = new byte[256];
            int countOfRead;
            while ((countOfRead = inputStream2.read(buf)) > 0) { // или != -1
                //выведем в консоль
                for (int i = 0; i < countOfRead; i++) {
                    System.out.print((char) buf[i]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("-----------------------------------");

        //Считывание файла BufferedInputStream
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("TODO.txt"))) {
            byte[] buf = new byte[256];
            int countOfRead;
            while ((countOfRead = bufferedInputStream.read(buf)) > 0) {
                //выведем в консоль
                for (int i = 0; i < countOfRead; i++) {
                    System.out.print((char) buf[i]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

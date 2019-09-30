package core.IO;

import java.io.*;

/**
 * InputStreamReader - читает символы из потока
 * StringReader - читает символы из строки
 * FileReader - читает символы из файла
 *
 * BufferedReader - буферезированный ридер, обертка позволяющая работать с строками
 *
 * https://javarush.ru/quests/lectures/questcollections.level01.lecture07
 * BufferedReader
 * https://javarush.ru/quests/lectures/questcollections.level02.lecture05
 * StringReader
 * https://javarush.ru/quests/lectures/questcollections.level02.lecture03
 *
 */
public class Reader_Writer {

    public static void main(String[] args) throws IOException {

        System.out.println("считывание файла FileReader: ");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("TODO.txt"));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            System.out.println(line);
        }
        bufferedReader.close();
        System.out.println("---------------------------------------");


        System.out.println("считывание из строки StringReader: ");
        BufferedReader bufferedReader2 = new BufferedReader(new StringReader("STRING TEST"));
        String line2 = bufferedReader2.readLine();
        System.out.println(line2);
        bufferedReader2.close();
        System.out.println("---------------------------------------");


        System.out.println("считывание с консоли InputStreamReader: ");
        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(System.in));
        String line3 = bufferedReader3.readLine();
        System.out.println(line3);
        bufferedReader3.close();
        System.out.println("---------------------------------------");


    }
}

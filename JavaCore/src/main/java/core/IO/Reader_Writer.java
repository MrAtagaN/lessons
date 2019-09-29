package core.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://javarush.ru/quests/lectures/questcollections.level01.lecture07
 * BufferedReader
 * https://javarush.ru/quests/lectures/questcollections.level02.lecture05
 * StringReader
 * https://javarush.ru/quests/lectures/questcollections.level02.lecture03
 *
 *
 * InputStreamReader - адаптер байт к символам
 * StringReader - адаптер строки к символам
 *
 * BufferedReader - адаптер символов к строкам
 *
 */
public class Reader_Writer {

    public static void main(String[] args) throws IOException {
        //считывание с консоли
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        System.out.println(line);


    }
}

package patterns.structural;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class Adapter {

    public static void main(String[] args) throws FileNotFoundException {
        //Arrays.asList преобразует массив к интерфейсу List
        String[] array = {"One", "Two", "Three"};
        List<String> strings = Arrays.asList(array);
        strings.set(0, "1");
        System.out.println(Arrays.toString(array));


        //InputStreamReader преобразует InputStream к интерфейсу Reader
        InputStream fileInputStream = new FileInputStream("TODO.txt");
        Reader inputStreamReader = new InputStreamReader(fileInputStream);

    }
}

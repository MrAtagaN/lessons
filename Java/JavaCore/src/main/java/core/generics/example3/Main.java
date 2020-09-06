package core.generics.example3;

import java.util.ArrayList;
import java.util.List;

/**
 * Нельзя параметризировать классы:
 * Наследующиеся от Throwable
 * Анонимные классы
 * Enum
 */
public class Main {

    public static void main(String[] args) {
        Integer i = 2;
        Class <? extends Integer> c  = i.getClass();

        //List<Number>[] list = new ArrayList<Integer>[10]; //Generic array creation
        List<?>[] list = new ArrayList<?>[10];

        //Можно класть только null
        List<? extends Number> numbers = new ArrayList<>();
        numbers = new ArrayList<Long>();
        numbers = new ArrayList<Integer>();
        numbers = new ArrayList<Double>();
        //Компилятор не знает чем параметризоват List
        //numbers.add(233L);

        //Можно класть ? extends Number: Integer, Double, Long..
        List<? super Number> numbers2 = new ArrayList<>();

    }
}

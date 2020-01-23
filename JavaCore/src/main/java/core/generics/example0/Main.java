package core.generics.example0;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        List<? extends Number> nums = ints;
    }


    /**
     * Вы не можете добавить какой-либо объект в список <? extends T>, потому что вы не можете гарантировать,
     * на какой тип List он действительно указывает, поэтому вы не можете гарантировать, что объект разрешен в
     * этом List. Единственная «гарантия» заключается в том, что вы можете только читать с нее, и вы получите T
     * или подкласс T.
     */
    public static void main2(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        //nums.add(3.14); // compile-time error
    }

    /**
     *  Вы не можете прочитать конкретный тип T (например, число) из списка <? super T> потому что вы не можете
     *  гарантировать, на какой список он действительно указывает. Единственная «гарантия», которую вы имеете,
     *  заключается в том, что вы можете добавить значение типа T (или любой подкласс T), не нарушая целостность
     *  указанного списка.
     */
    public static <T> T getFirst(List<? super T> list) {
       // return list.get(0); // compile-time error
        return null;
    }
}

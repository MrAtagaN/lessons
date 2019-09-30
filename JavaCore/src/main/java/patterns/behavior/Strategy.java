package patterns.behavior;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


public class Strategy {

    public static void main(String[] args) {
        MyComparator myComparator = new MyComparator();
        Map<String,Integer> map = new TreeMap<>(myComparator);
        map.put("eeee",23);
        map.put("aa",10);
        map.put("dd",10);
        map.put("fff",10);
        map.put("g",10);

        map.forEach((key, value) -> {
            System.out.println(key+ "  " + value);
        });
    }


    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() -  o2.length();
        }
    }
}

package core.string;

/**
 * String.copyValueOf() -
 * String.format() -
 * String.join() - соединяет строки, вставляя между ними разделитель
 *
 *
 */
public class String_ {

    public static void main(String[] args) {
        String a ="Hello";
        final String b ="Hel";
        String c ="lo";
        String d ="Hello";

        System.out.println(a == d); //true
        System.out.println(a == b + c); //false
        System.out.println(a == b + "lo"); //true

//        String.copyValueOf()
//        String.format()
//        String.join()

//        a.charAt()
//        a.codePointAt()
//        a.codePointBefore()
//        a.codePointCount()
//        a.codePoints()
//        a.compareTo()
//        a.compareToIgnoreCase()
//        a.concat()
//        a.contains()
//        a.intern()
//        a.matches()
//        a.offsetByCodePoints()
//        a.replace()
//        a.split()
//        a.substring()

    }
}

package core.string;

public class String_ {

    public static void main(String[] args) {
        String a ="Hello";
        final String b ="Hel";
        String c ="lo";
        String d ="Hello";

        System.out.println(a == d);
        System.out.println(a == b + c);
        System.out.println(a == b + "lo");
    }
}

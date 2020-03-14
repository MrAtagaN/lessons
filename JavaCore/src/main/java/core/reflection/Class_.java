package core.reflection;

public class Class_ {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class_.class;
        System.out.println(clazz.getName());
        Class clazz2 = Class.forName(clazz.getName());

        clazz = clazz.getClass(); // Class
        System.out.println(clazz.getName());
    }
}

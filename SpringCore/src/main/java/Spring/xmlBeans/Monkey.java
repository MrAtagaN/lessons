package Spring.xmlBeans;


/**
 * Бин созданный через xml конфиг
 */
public class Monkey {

    private int age;

    public Monkey() {
    }

    public Monkey(int age) {
        this.age = age;
    }

    public void say() {
        System.out.println("Monkey is " + age +"!");
    }


}

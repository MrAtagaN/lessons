package Spring.xmlBeans;


/**
 * Бин prototype создаваемый через xml конфиг
 */
public class Cat {

    private static int count = 0;

    private int number;

    public Cat() {
        this.count++;
        this.number = count;
    }

    public void say() {
        System.out.println("Cat number " + number + " say \"Meaw\"!");
    }
}

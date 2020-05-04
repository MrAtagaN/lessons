package Spring.xmlBeans;


/**
 * Бин созданный через xml конфиг, фабричным методом
 */

public class Bird {

    private Bird() {
    }

    public static Bird getBird() {
        return new Bird();
    }

    public void say() {
        System.out.println("Bird say \"chick-chirik\"!");
    }
}

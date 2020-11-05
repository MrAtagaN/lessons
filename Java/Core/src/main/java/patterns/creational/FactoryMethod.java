package patterns.creational;


public class FactoryMethod {

    private FactoryMethod() {}

    public static FactoryMethod getInstance() {
        return new FactoryMethod();
    }
}

package patterns.creational;


public class FactoryMethod {
    public Coffee createCoffee(CoffeeType type) {
        Coffee coffee = null;

        switch (type) {
            case AMERICANO:
                coffee = new Americano();
                break;
            case ESPRESSO:
                coffee = new Espresso();
                break;
            case CAPPUCCINO:
                coffee = new Cappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new CaffeLatte();
                break;
        }

        return coffee;
    }


    interface Coffee {

    }

    class Americano implements Coffee {

    }

    class Espresso implements Coffee {

    }

    class Cappuccino implements Coffee {

    }

    class CaffeLatte implements Coffee {

    }

    enum CoffeeType {
        AMERICANO,
        ESPRESSO,
        CAPPUCCINO,
        CAFFE_LATTE
    }
}
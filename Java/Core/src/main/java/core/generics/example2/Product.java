package core.generics.example2;

/**
 * Рекурсивное расширение типа
 */
public class Product<T extends Product<T>> implements Comparable<T> {

    protected String name;
    protected int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}

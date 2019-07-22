package core.generics.example2;

/**
 * Параметризированный тип. Наследование типа, интерфейса
 */
public class Container<T extends Product<T>> {

    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

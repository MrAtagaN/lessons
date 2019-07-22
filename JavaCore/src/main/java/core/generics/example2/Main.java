package core.generics.example2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // пример 1
        Container<Camera> cameraContainer = new Container<>();
        cameraContainer.setItem(new Camera());

        Container<Phone> phoneContainer = new Container<>();
        phoneContainer.setItem(new Phone());

        // пример 2
        List<Camera> cameras = new ArrayList<>();
        cameras.add(new Camera());
        find(cameras, new Camera());
        find(cameras, new Phone());
    }

    /**
     * ? extends Product - лююой тип ограниченный сверху
     * T - конкретный тип без наследования
     */
    private static boolean find(List<? extends Product> list, Product findingProduct) {
        for (Product product : list) {
            if (product.equals(findingProduct)) {
                return true;
            }
        }
        return false;
    }
}

package core.annotations.example;

import core.annotations.MyService;

/**
 * Пример аннотаций над класом
 */
public class Example {

    public static void main(String[] args) {
        inspectMyServiceAnnotation(ExampleClass.class);
        inspectMyServiceAnnotation(ExampleClass2.class);
    }


    /**
     * Проверка аннотации {@link MyService} над классом
     */
    public static void inspectMyServiceAnnotation(Class<?> tClass) {
        if (tClass.isAnnotationPresent(MyService.class)) {
            MyService annotation = tClass.getAnnotation(MyService.class);
            System.out.println("Над классом " + tClass.getSimpleName() + " есть аннотация MyService");
            System.out.println("Значение поля name: " + annotation.name());
            System.out.println("Значение поля lazyLoad: " + annotation.lazyLoad());
        } else {
            System.out.println("Над классом " + tClass.getSimpleName() + " нет аннотации MyService");
        }
        System.out.println();
    }
}

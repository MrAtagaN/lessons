package core.annotations;

import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        //inspectService(String.class);
    }

    /**
     * Пример использования аннотаций
     */
    public static void inspectService(Class<?> tClass) {
        tClass.getAnnotations(); // возвращает аннотации только данного класа
        tClass.getDeclaredAnnotations(); // возвращает все аннотации родительских классов
        tClass.isAnnotationPresent(Service.class); // есть ли у класса аннотация
        Service annotation = tClass.getAnnotation(Service.class);// возвращает аннотацию в виде объекта


        // пример использования
        if (tClass.isAnnotationPresent(Service.class)) {
            Service annotation2 = tClass.getAnnotation(Service.class);
            System.out.println("Значение name аннотации: " + annotation2.name() + " над классом " + tClass.getSimpleName());
        } else {
            System.out.println("Аннотации Service у класса " + tClass.getSimpleName() + "не найдено");
        }

        Method[] declaredMethods = tClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Init.class)) {
                System.out.println("Метод "+method.getName()+" аннотирован Init");
            } else {
                System.out.println("Метод "+method.getName()+" НЕ аннотирован Init");
            }
        }

        System.out.println("//====================//");
    }

}



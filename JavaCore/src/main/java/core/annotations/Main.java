package core.annotations;

public class Main {

    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }

    /**
     * class.getAnnotations(); - возвращает аннотации только данного класа
     * class.getDeclaredAnnotations(); - возвращает все аннотации родительских классов
     * class.isAnnotationPresent(Service.class); - есть ли у класса аннотация
     * class.getAnnotation(Service.class); - возвращает аннотацию в виде объекта
     */
    public static void inspectService(Class<?> tClass) {
        tClass.getAnnotations(); // возвращает аннотации только данного класа
        tClass.getDeclaredAnnotations(); // возвращает все аннотации родительских классов
        tClass.isAnnotationPresent(Service.class); // есть ли у класса аннотация
        //Service annotation = tClass.getAnnotation(Service.class);// возвращает аннотацию в виде объекта

        if (tClass.isAnnotationPresent(Service.class)) {
            Service annotation = tClass.getAnnotation(Service.class);
            System.out.println("Значение name аннотации: " + annotation.name() + " над классом " + tClass.getSimpleName());
        } else {
            System.out.println("Аннотации Service у класса " + tClass.getSimpleName() + "не найдено");
        }

    }

}



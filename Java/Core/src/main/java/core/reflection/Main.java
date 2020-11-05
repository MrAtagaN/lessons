package core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Рефлексия позволяет:
 *
 * Узнать/определить класс объекта;
 * Получить информацию о модификаторах класса, полях, методах, константах, конструкторах и суперклассах;
 * Выяснить, какие методы принадлежат реализуемому интерфейсу/интерфейсам;
 * Создать экземпляр класса, причем имя класса неизвестно до момента выполнения программы;
 * Получить и установить значение поля объекта по имени;
 * Вызвать метод объекта по имени.
 *
 * Методы:
 * getSimpleName
 * getAnnotation
 * isAnnotation
 * isAnnotationPresent
 * desiredAssertionStatus
 * getClassLoader
 * getCanonicalName
 * getSigners
 * isAssignableFrom
 *
 * Возвращают все, в том числе и private, protected:
 * getDeclaredField
 * getDeclaredMethod
 * getDeclaredConstructor
 *
 * Возвращают только public, в том числе родительских классов:
 * getField
 * getMethod
 * getConstructor
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {

        Person person = new Person();

        // Получаем значение поля у объекта person
        Field field = person.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String name = (String) field.get(person);
        System.out.println("name = " + name);

        // Сетаем значение поля у объекта person
        Field field2 = person.getClass().getDeclaredField("name");
        field2.setAccessible(true);
        field2.set(person, "new value");
        String name2 = (String) field2.get(person);
        System.out.println("name2 = " + name2);


        // Вызываем метод printData у объекта person
        Method method = person.getClass().getDeclaredMethod("printData");
        method.setAccessible(true);
        method.invoke(person);


        // Создаем экземпляр класса Person
        Class clazz = Class.forName(Person.class.getName());
        person = (Person) clazz.newInstance();


        // Создаем экземпляр класса Person c параметрами
        Class clazz2 = Class.forName(Person.class.getName());
        Class[] params = {String.class, int.class};
        Constructor construct = clazz2.getDeclaredConstructor(params);
        construct.setAccessible(true);
        person = (Person) construct.newInstance("default2", 25);


        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("Параметры конструкторов: ");
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print("param: " + paramType.getName() + " ");
            }
            System.out.println();
        }

        System.out.println("Родительский класс: " + Person.class.getSuperclass());
    }
}

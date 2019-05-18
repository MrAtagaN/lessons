package gson;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Gson
 */
public class Main {

    public static void main(String[] args) {

        //primitives();

        jsonObjects();

    }


    private static void jsonObjects() {
        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address);

        Gson gson = new Gson();
        //Сериализация
        String json = gson.toJson(person);

        System.out.println("json = " + json);

        //Десериализация
        Person person2 = gson.fromJson(json, Person.class);
        System.out.println("person2 = " + person2);
    }


    private static void primitives() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(123));    // 123
        System.out.println(gson.toJson("hello")); // "hello"
        System.out.println(gson.toJson(10L));    // 10

        System.out.println(gson.fromJson("1", int.class));
        System.out.println(gson.fromJson("\"world\"", String.class));
        System.out.println(gson.fromJson("true", Boolean.class));

        System.out.println(gson.toJson(new int[] {10, 100})); // [10,100]

        int[] array = gson.fromJson("[10,100]", int[].class);
        Arrays.stream(array).forEach(str -> {
            System.out.print(str + " ");
        });

        System.out.println();
    }


}

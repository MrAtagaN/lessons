package gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Gson
 */
public class Main {

    public static void main(String[] args) {

        //primitives();

        jsonObjects();

        gsonBuilder();

    }


    private static void gsonBuilder() {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat(DateFormat.SHORT, DateFormat.SHORT)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        //Сериализация
        String json = gson.toJson(person);
        System.out.println("Custom json = " + json);
    }


    private static void jsonObjects() {
        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

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

        System.out.println(gson.toJson(new int[]{10, 100})); // [10,100]

        int[] array = gson.fromJson("[10,100]", int[].class);
        Arrays.stream(array).forEach(str -> {
            System.out.print(str + " ");
        });

        System.out.println();
    }


}

package libs.gson;

import com.google.gson.*;
import com.google.gson.annotations.*;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * {@link Gson}
 *
 * fromJson
 * toJson
 * htmlSafe
 * serializeNulls
 * excluder
 * fieldNamingStrategy
 * getAdapter
 * toJsonTree
 *
 *
 * {@link JsonElement} - Абстрактный класс - неопределенный элемент json
 * реализации: JsonArray, JsonNull, JsonObject, JsonPrimitive
 *
 *
 * {@link JsonObject} -
 *
 *
 * {@link GsonBuilder}
 *
 *
 * Аннотации:
 * {@link SerializedName} -
 * {@link Until} -
 * {@link Since} -
 * {@link JsonAdapter} -
 * {@link Expose} -
 *
 */
public class Main {

    public static void main(String[] args) {
        //primitives();
        jsonElementValue();
        jsonObjects();
        gsonBuilder();
        jsonElementValue2();
    }


    /**
     * Получение значения атрибута из json
     */
    private static void jsonElementValue() {
        Gson gson = new Gson();
        String json = createJson();

        // Дессериализация
        // Получаем jsonElement. Это по сути атрибут в json
        // Из jsonElement можно получить примитив, коллекцию, jsonObject
        JsonElement jsonElement = gson.fromJson(json, JsonElement.class);

        // Получаем jsonObject. Это по сути сам json (структура)
        // Из jsonObject можно получить jsonObject, коллекцию jsonObject, jsonElement
        JsonObject jsonObject = jsonElement.getAsJsonObject().get("address").getAsJsonObject();
        JsonElement countryElement = jsonObject.get("country");

        System.out.println("country = " + countryElement);
    }


    /**
     * Получение значения атрибута из json (Плохой способ)
     */
    private static void jsonElementValue2() {
        Gson gson = new Gson();
        String json = createJson();

        // Дессериализация
        // Получаем jsonElement. Это по сути атрибут в json
        JsonElement jsonElement = gson.toJsonTree(new Gson().fromJson(json, Map.class).get("address"));

        // Получаем jsonObject. Это по сути сам json (структура)
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement countryElement = jsonObject.get("country");

        System.out.println("country = " + countryElement);
    }


    /**
     * Кастомный объект gson (сериализатор)
     */
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

    /**
     * Маппинг json на Класс
     */
    private static void jsonObjects() {
        Gson gson = new Gson();
        String json = createJson();

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

    }

    /**
     * Json для тестов, сериализация объектов Address, Person
     */
    private static String createJson() {
        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        Gson gson = new Gson();
        //Сериализация
        String json = gson.toJson(person);

        System.out.println("json = " + json);

        return json;
    }


}

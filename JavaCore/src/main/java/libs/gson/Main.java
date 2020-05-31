package libs.gson;

import com.google.gson.*;
import com.google.gson.annotations.*;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * {@link Gson}
 *
 * fromJson - дессериализация
 * toJson - сериализация в json
 *
 * {@link JsonElement} - Абстрактный класс - неопределенный элемент json
 * реализации:
 * {@link JsonArray} - List элементов JsonElement
 * {@link JsonNull} - json c null значением
 * {@link JsonObject} - LinkedTreeMap (String, JsonElement). Ключ - имя элемента, Значение абстрактный элемент
 * {@link JsonPrimitive} -
 *
 *
 * {@link GsonBuilder} -
 * htmlSafe -
 * complexMapKeySerialization -
 * excluder -
 * fieldNamingStrategy -
 * getAdapter -
 * toJsonTree -
 * serializeNulls - сериализовывать null поля, по умолчанию пропускает
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
        primitives();
        jsonMapToObjects();
        jsonElementValue();
        customGsonBuilder();
    }


    /**
     * Получение значения атрибута из json
     */
    private static void jsonElementValue() {
        System.out.println("\n=== jsonElementValue ===");
        String json =
                "{                                              " +
                "  \"name\": \"AtagaN\",                        " +
                "  \"age\": 25,                                 " +
                "  \"phone\": 43453232323232323,                " +
                "  \"address\": {                               " +
                "    \"country\": \"Russia\",                   " +
                "    \"city\": \"Moscow\",                      " +
                "    \"street\": \"Tverskaya\",                 " +
                "    \"home\": 10                               " +
                "  },                                           " +
                "  \"birthday\": \"May 31, 2020 4:49:51 PM\"    " +
                "}";

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        JsonObject address = jsonObject.get("address").getAsJsonObject();
        System.out.println("address: " + address);

        JsonElement countryElement = address.get("country");
        System.out.println("country: " + countryElement);

        int phone = jsonObject.get("phone").getAsInt(); //Ошибка: значение не 43453232323232323, а 217580099 (Integer.MAX_VALUE)
        System.out.println("phone: "+ phone);
    }


    /**
     * Кастомный объект gson (сериализатор)
     */
    private static void customGsonBuilder() {
        System.out.println("\n=== customGsonBuilder ===");

        Gson gson = new Gson();
        System.out.println("default gson parametrs: ");
        System.out.println("htmlSafe: " + gson.htmlSafe()); //htmlSafe: true



        Gson customGson = new GsonBuilder()
                .disableHtmlEscaping() //сетает htmlSafe false
                .enableComplexMapKeySerialization() //сетает complexMapKeySerialization true
                .serializeNulls() //сетает serializeNulls true
                .setDateFormat(DateFormat.SHORT, DateFormat.SHORT)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        //Сериализация
        String json = customGson.toJson(person);
        System.out.println("\nCustom json serialization : " + json);
    }

    /**
     * Маппинг json на Класс
     */
    private static void jsonMapToObjects() {
        System.out.println("\n=== jsonMapToObjects ===");

        String json =
                "{                                              " +
                "  \"NAME\": \"AtagaN\",                        " +
                "  \"age\": 24,                                 " +
                "  \"phone\": 43453,                            " +
                "  \"address\": {                               " +
                "    \"COUNTRY\": \"Russia\",                   " +
                "    \"city\": \"Moscow\",                      " +
                "    \"street\": \"Tverskaya\",                 " +
                "    \"home\": 10                               " +
                "  },                                           " +
                "  \"birthday\": \"May 31, 2020 4:49:51 PM\"    " +
                "}";
        Gson gson = new Gson();

        //Десериализация
        Person person = gson.fromJson(json, Person.class);
        System.out.println("person: " + person);
    }


    private static void primitives() {
        System.out.println("\n=== primitives ===");

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
            System.out.println(str + " ");
        });

    }

}

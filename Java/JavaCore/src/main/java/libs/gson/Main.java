package libs.gson;

import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.internal.Excluder;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * {@link Gson}
 *
 * fromJson - дессериализация
 * toJson - сериализация в json
 *
 * excluder - возвращает класс {@link Excluder}, который пропускает при сериализации определенные объекты и поля
 *
 * {@link JsonElement} - Абстрактный класс. Обобщенный элемент json
 * реализации:
 * {@link JsonArray} - List элементов JsonElement
 * {@link JsonNull} - json c null значением
 * {@link JsonObject} - LinkedTreeMap (String, JsonElement). Ключ - имя элемента, Значение абстрактный элемент
 * {@link JsonPrimitive} -
 *
 *
 * {@link GsonBuilder} - создает объект gson с заданными параметрами
 * htmlSafe -
 * setVersion - версия сериализатора (gson), используется вместе с @Until и @Since
 * complexMapKeySerialization -
 * excluder -
 * fieldNamingStrategy -
 * getAdapter -
 * serializeNulls - сериализовывать null поля, по умолчанию пропускает
 *
 *
 * Аннотации:
 * {@link SerializedName} - параметр в json которое нужно сериализовать в поле класса.
 *  alternate - другие параметры в json для того же поля класса
 * {@link Until} - сериализовывать поле до определенной версии gson (поле version в {@link Excluder})
 * {@link Since} - сериализовывать поле после определенной версии gson (поле version в {@link Excluder})
 * {@link JsonAdapter} -
 * {@link Expose} - сериализует/десериализует только поля с этой аннотацией,
 *                  при включенном excludeFieldsWithoutExposeAnnotation
 *
 */
public class Main {

    public static void main(String[] args) {
        primitives();
        jsonMapToObjects();
        jsonElementValue();
        customGsonBuilder();
        expose();
    }


    /**
     * Получение значения атрибута из json
     */
    private static void jsonElementValue() {
        System.out.println("\n=== jsonElementValue ===");

        //{
        //  "name": "AtagaN",
        //  "age": 25,
        //  "phone": 43453232323232323,
        //  "birthday": "May 31, 2020 4:49:51 PM",
        //  "address": {
        //    "country": "Russia",
        //    "city": "Moscow",
        //    "street": "Tverskaya",
        //    "home_number": 10
        //  }
        //}

        String json =   "{" +
                        "  \"name\": \"AtagaN\",                       " +
                        "  \"age\": 25,                                " +
                        "  \"phone\": 43453232323232323,               " +
                        "  \"birthday\": \"May 31, 2020 4:49:51 PM\",  " +
                        "  \"address\": {                              " +
                        "    \"country\": \"Russia\",                  " +
                        "    \"city\": \"Moscow\",                     " +
                        "    \"street\": \"Tverskaya\",                " +
                        "    \"home_number\": 10                       " +
                        "  }                                           " +
                        "}                                             ";

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
                .disableHtmlEscaping() //не менять html символы
                .enableComplexMapKeySerialization() //сетает complexMapKeySerialization true
                .serializeNulls() //сериализовывать null поля
                .setDateFormat(DateFormat.SHORT, DateFormat.SHORT) //формат даты
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) //меняет название полей
                .setPrettyPrinting() //форматированный вывод
                .setVersion(1.0) //версия сериализатора (gson), используется вместе с @Until и @Since
                .create();

        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        //Сериализация
        String json = customGson.toJson(person);
        System.out.println("\nCustom json serialization :\n" + json);
    }


    /**
     * Маппинг json на Класс
     */
    private static void jsonMapToObjects() {
        System.out.println("\n=== jsonMapToObjects ===");

        //{
        //  "name": "AtagaN",
        //  "age": 25,
        //  "phone": 434532,
        //  "birthday": "May 31, 2020 4:49:51 PM",
        //  "address": {
        //    "country": "Russia",
        //    "city": "Moscow",
        //    "street": "Tverskaya",
        //    "home_number": 10
        //  }
        //}

        String json =
                "{                                             " +
                "  \"name\": \"AtagaN\",                       " +
                "  \"age\": 25,                                " +
                "  \"phone\": 434532,                          " +
                "  \"birthday\": \"May 31, 2020 4:49:51 PM\",  " +
                "  \"address\": {                              " +
                "    \"country\": \"Russia\",                  " +
                "    \"city\": \"Moscow\",                     " +
                "    \"street\": \"Tverskaya\",                " +
                "    \"home_number\": 10                       " +
                "  }                                           " +
                "}                                             ";
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


    private static void expose() {
        System.out.println("\n=== expose ===");

        User user = new User();
        user.setFirstName("Max");
        user.setLastName("Ivanov");
        user.setEmailAddress("Moscow");
        user.setPassword("12345678");

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String json = gson.toJson(user);
        System.out.println("user: " + json);
    }

}

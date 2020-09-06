package libs.jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.fasterxml.jackson.core.JsonParser.Feature.*;
import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;

/**
 * {@link JsonNode} - Абстрактный класс. Обобщенный элемент json
 *
 * {@link ObjectNode} - LinkedTreeMap (String, JsonNode). Ключ - имя элемента, Значение абстрактный элемент
 *
 *
 *
 * Аннотации:
 * {@link JsonProperty} - параметр в json которое нужно сериализовать в поле класса.
 * {@link JsonGetter} - является альтернативой аннотации @JsonProperty
 * {@link JsonPropertyOrder} - указать порядок свойств при сериализации
 * {@link JsonValue} - указывает один метод, который библиотека будет использовать для сериализации всего экземпляра
 * {@link JsonSerialize} - указывает пользовательский сериализатор, который будет использоваться при маршалинге сущности
 * {@link JsonCreator} - для настройки конструктора / фабрики, используемых при десериализации.
 * {@link JsonDeserialize} - указывает на использование собственного десериализатора
 * {@link JsonAlias} - одно или несколько альтернативных имен для свойства во время десериализации
 * {@link JsonIgnoreProperties} - аннотация уровня класса, которая отмечает свойство или список свойств, которые Джексон будет игнорировать
 * {@link JsonIgnore} - используется для пометки свойства, которое следует игнорировать на уровне поля
 * {@link JsonInclude} - для исключения свойств с пустыми / нулевыми / значениями по умолчанию.
 * {@link JsonAutoDetect} - переопределить семантику по умолчанию, какие свойства видимы, а какие нет.
 * {@link JsonFormat} - указывает формат при сериализации значений даты и времени
 * {@link JsonIdentityInfo} -  для решения проблем бесконечной рекурсии
 *
 *
 * Отличия от Gson:
 * требует конструктор по умолчанию,
 * не читает одинарные ковычки,
 * не читает формат даты "6/2/20 9:35 PM"
 *
 * https://www.baeldung.com/jackson-annotations
 */
public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        jsonMapToObjects();
        jsonElementValue();
        writeValueAsString();
    }

    private static void jsonMapToObjects() throws JsonProcessingException {
        System.out.println("\n=== jsonMapToObjects ===");

        //{
        //  "name": "AtagaN",
        //  "age": 25,
        //  "phone": 4345,
        //  "birthday": "2020-12-12T10:20",
        //  "address": {
        //    "city": "Moscow",
        //    "street": "Tverskaya",
        //    "home_number": 10
        //  }
        //}

        String json =
                "{                                             " +
                "  \"name\": \"AtagaN\",                       " +
                "  \"age\": 25,                                " +
                "  \"phone\": 4345,                            " +
                "  \"birthday\": \"2020-12-12T10:20\",         " +
                "  \"address\": {                              " +
                "    \"city\": \"Moscow\",                     " +
                "    \"street\": \"Tverskaya\",                " +
                "    \"home_number\": 10                       " +
                "  }                                           " +
                "}                                             ";

        ObjectMapper objectMapper = new ObjectMapper();
        //Десериализация
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println("person: " + person);
    }



    private static void jsonElementValue() throws JsonProcessingException {
        System.out.println("\n=== jsonElementValue ===");

        //{
        //  "name": "AtagaN",
        //  "age": 25,
        //  "phone": 434512341234,
        //  "birthday": "2020-12-12T10:20",
        //  "address": {
        //    "city": "Moscow",
        //    "street": "Tverskaya",
        //    "home_number": 10
        //  }
        //}

        String json =
                        "{                                             " +
                        "  \"name\": \"AtagaN\",                       " +
                        "  \"age\": 25,                                " +
                        "  \"phone\": 434512341234,                    " +
                        "  \"birthday\": \"2020-12-12T10:20\",         " +
                        "  \"address\": {                              " +
                        "    \"city\": \"Moscow\",                     " +
                        "    \"street\": \"Tverskaya\",                " +
                        "    \"home_number\": 10                       " +
                        "  }                                           " +
                        "}                                             ";

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
        JsonNode address = jsonNode.get("address");
        JsonNode city = address.get("city");
        String cityString = city.asText();

        System.out.println("city: " + cityString);

        JsonNode phone = jsonNode.get("phone");
        System.out.println("phone: " + phone.asInt());  //ошибка, 720644338
    }

    private static void writeValueAsString() throws JsonProcessingException {
        System.out.println("\n=== writeValueAsString ===");

        Address address = new Address("Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(ALLOW_SINGLE_QUOTES, true);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm a z");
        objectMapper.setDateFormat(df);

        String json = objectMapper.writeValueAsString(person);
        System.out.println("s = " + json);

    }

    private static void config() {
        new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .enable(ALLOW_UNQUOTED_FIELD_NAMES)
                .enable(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)
                .enable(SerializationFeature.WRAP_EXCEPTIONS)
                .enable(DeserializationFeature.WRAP_EXCEPTIONS)
                .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
                .enable(ALLOW_UNQUOTED_CONTROL_CHARS)
                .enable(ALLOW_UNQUOTED_FIELD_NAMES)
                .enable(ALLOW_SINGLE_QUOTES)
                .enable(DeserializationFeature.USE_LONG_FOR_INTS)
                .findAndRegisterModules();
    }
}

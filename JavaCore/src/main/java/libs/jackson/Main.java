package libs.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * {@link JsonNode} - Абстрактный класс. Обобщенный элемент json
 *
 * {@link ObjectNode} - LinkedTreeMap (String, JsonNode). Ключ - имя элемента, Значение абстрактный элемент
 *
 *
 *
 * Аннотации:
 * {@link JsonProperty} - параметр в json которое нужно сериализовать в поле класса.
 *
 *
 * Отличия от Gson:
 * требует конструктор по умолчанию,
 * не читает одинарные ковычки,
 * не читает формат даты "6/2/20 9:35 PM"
 */
public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        jsonMapToObjects();
        jsonElementValue();
    }

    private static void jsonMapToObjects() throws JsonProcessingException {
        System.out.println("\n=== jsonMapToObjects ===");

        //{
        //  "name": "AtagaN",
        //  "age": 25,
        //  "phone": 4345,
        //  "birthday": "May 31, 2020 4:49:51 PM",
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
        //  "phone": 4345,
        //  "birthday": "May 31, 2020 4:49:51 PM",
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

        JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
        JsonNode address = jsonNode.get("address");
        JsonNode city = address.get("city");
        String cityString = city.asText();

        System.out.println("city: " + cityString);
    }
}

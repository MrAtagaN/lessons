package libs.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 *
 *
 * Отличия от Gson: требует конструктор по умолчанию, не читает одинарные ковычки, не читает формат даты "6/2/20 9:35 PM"
 */
public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        jsonMapToObjects();
    }

    private static void jsonMapToObjects() throws JsonProcessingException {
        System.out.println("\n=== jsonMapToObjects ===");

        String json =
                        "{                                       " +
                        "  \"name\": \"AtagaN\",                 " +
                        "  \"age\": 24,                          " +
                        "  \"phone\": 43453,                     " +
                        "  \"birthday\": \"2020-12-12T10:20\",   " +
                        "  \"address\": {                        " +
                        "    \"street\": \"Tverskaya\",            " +
                        "    \"city\": \"Moscow\",               " +
                        "    \"home\": 10                        " +
                        "  }                                     " +
                        "}                                       ";

        ObjectMapper objectMapper = new ObjectMapper();
        //Десериализация
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println("person: " + person);
    }
}

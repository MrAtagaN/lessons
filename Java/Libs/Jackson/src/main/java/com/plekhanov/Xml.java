package com.plekhanov;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.Date;

import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES;

public class Xml {

    public static void main(String[] args) throws IOException {
        writeValueAsString();
        jsonElementValue();
    }


    private static void writeValueAsString() throws JsonProcessingException {
        System.out.println("\n=== writeValueAsString ===");

        XmlMapper xmlMapper = new XmlMapper();
        Address address = new Address("Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        String xml = xmlMapper.writeValueAsString(person);
        xmlMapper.configure(ALLOW_SINGLE_QUOTES, true);
        System.out.println("xml = " + xml);
    }

    private static void jsonElementValue() throws IOException {
        System.out.println("\n=== jsonElementValue ===");

        String xml =
                "<Person>                                   " +
                "    <name>AtagaN</name>                    " +
                "    <age>24</age>                          " +
                "    <phone>43453</phone>                   " +
                "    <address>                              " +
                "        <city>Moscow</city>                " +
                "        <street>Tverskaya</street>         " +
                "        <home_number>10</home_number>      " +
                "    </address>                             " +
                "    <birthday>1591221013956</birthday>     " +
                "</Person>                                   ";

        XmlMapper xmlMapper = new XmlMapper();
        ObjectNode objectNode = xmlMapper.readValue(xml, ObjectNode.class);
        JsonNode address = objectNode.get("address");
        JsonNode city = address.get("city");
        String cityString = city.asText();

//        XmlMapper xmlMapper = new XmlMapper();
//        JsonNode jsonNode = xmlMapper.readTree(string.getBytes());
//        ObjectMapper objectMapper = new ObjectMapper();
//        String value = objectMapper.writeValueAsString(jsonNode);


        System.out.println("city = " + cityString);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(objectNode));
    }
}

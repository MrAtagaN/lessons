package com.plekhanov;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {

    public static String TEST_JSON_STRING =
            "{\"id\":\"123\",\"address\":{\"city\":\"Moscow\",\"street\":\"Tverskaya\"}}";

    public static void main(String[] args) {
        JSONObject json = new JSONObject(TEST_JSON_STRING);
        String xml = XML.toString(json);
        System.out.println(xml);
    }
}

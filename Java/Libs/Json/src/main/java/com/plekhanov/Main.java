package com.plekhanov;

import org.json.JSONObject;
import org.json.XML;

public class Main {

    public static void main(String[] args) {
        String jsonString = "{\"id\":\"123\",\"address\":{\"city\":\"Moscow\",\"street\":\"Tverskaya\"}}";

        JSONObject json = new JSONObject(jsonString);
        String xml = XML.toString(json);

        System.out.println(xml);
    }
}

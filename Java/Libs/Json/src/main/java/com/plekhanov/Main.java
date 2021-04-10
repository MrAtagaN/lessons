package com.plekhanov;

import org.json.JSONObject;
import org.json.XML;

public class Main {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING =
            "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

    public static void main(String[] args) {
        String jsonString = "{\"id\":\"123\",\"address\":{\"city\":\"Moscow\",\"street\":\"Tverskaya\"}}";

        JSONObject json = new JSONObject(jsonString);
        String xml = XML.toString(json);

        System.out.println(xml);

        JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
        String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        System.out.println(jsonPrettyPrintString);
    }
}

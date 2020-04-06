package XSD;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class SchemaValidation {

    public static void main(String[] args) {
        Schema test = SchemaLoader.load(new JSONObject("{\n" +
                "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
                "  \"title\": \"SrvGetSpasiboClientInfoRq\",\n" +
                "  \"description\": \"Описание\",\n" +
                "  \"type\": \"object\",\n" +
                "  \"required\": [\n" +
                "    \"header\",\n" +
                "    \"body\"\n" +
                "  ],\n" +
                "  \"properties\": {\n" +
                "    \"header\": {\n" +
                "      \"description\": \"Блок для JMS-заголовков\",\n" +
                "      \"type\": \"object\",\n" +
                "      \"required\": [\n" +
                "        \"ServiceName\",\n" +
                "        \"ServiceDescription\",\n" +
                "        \"ServiceVersion\",\n" +
                "        \"OperationName\",\n" +
                "        \"SPName\",\n" +
                "        \"ServiceNamespace\",\n" +
                "        \"RqUID\",\n" +
                "        \"RqTm\",\n" +
                "        \"SCName\"\n" +
                "      ],\n" +
                "      \"properties\": {\n" +
                "        \"ServiceName\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"const\": \"SrvGetSpasiboClientInfo\"\n" +
                "        },\n" +
                "        \"ServiceDescription\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"ServiceVersion\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"const\": \"001\"\n" +
                "        },\n" +
                "        \"OperationName\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"const\": \"GetSpasiboClientInfo\"\n" +
                "        },\n" +
                "        \"SPName\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"enum\": [\n" +
                "            \"urn:sbrfsystems:99-vp\",\n" +
                "            \"urn:sbrfsystems:99-asfm\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"ServiceNamespace\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"enum\": [\n" +
                "            \"srv://sbg.sbr/federal\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"RqUID\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"pattern\": \"[a-f0-9]{32}\"\n" +
                "        },\n" +
                "        \"RqTm\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"pattern\": \"\\\\d{4}-\\\\d\\\\d-\\\\d\\\\dT\\\\d\\\\d:\\\\d\\\\d:\\\\d\\\\d(.[\\\\d]{1,6})?(([+\\\\-]\\\\d\\\\d:\\\\d\\\\d)|Z)?\"\n" +
                "        },\n" +
                "        \"SCName\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"enum\": [\n" +
                "            \"urn:sbrfsystems:99-vp\"\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"additionalProperties\": false\n" +
                "    },\n" +
                "    \"body\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"description\": \"Тело запроса\",\n" +
                "      \"required\": [\n" +
                "        \"GetSpasiboClientInfoRq\"\n" +
                "      ],\n" +
                "      \"properties\": {\n" +
                "        \"GetSpasiboClientInfoRq\": {\n" +
                "          \"type\": \"object\",\n" +
                "          \"required\": [\n" +
                "            \"RqUID\",\n" +
                "            \"RqTm\",\n" +
                "            \"SPName\",\n" +
                "            \"Identifier\"\n" +
                "          ],\n" +
                "          \"properties\": {\n" +
                "            \"RqUID\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"minLength\": 32,\n" +
                "              \"maxLength\": 32,\n" +
                "              \"pattern\": \"[a-f0-9]{32}\"\n" +
                "            },\n" +
                "            \"RqTm\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"pattern\": \"\\\\d{4}-\\\\d\\\\d-\\\\d\\\\dT\\\\d\\\\d:\\\\d\\\\d:\\\\d\\\\d(.[\\\\d]{1,6})?(([+\\\\-]\\\\d\\\\d:\\\\d\\\\d)|Z)?\"\n" +
                "            },\n" +
                "            \"SPName\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"maxLength\": 50\n" +
                "            },\n" +
                "            \"SystemId\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"maxLength\": 50\n" +
                "            },\n" +
                "            \"SubSystem\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"maxLength\": 50\n" +
                "            },\n" +
                "            \"Identifier\": {\n" +
                "              \"type\": \"object\",\n" +
                "              \"required\": [\n" +
                "                \"Id\",\n" +
                "                \"Type\"\n" +
                "              ],\n" +
                "              \"properties\": {\n" +
                "                \"Id\": {\n" +
                "                  \"type\": \"string\",\n" +
                "                  \"maxLength\": 255\n" +
                "                },\n" +
                "                \"Type\": {\n" +
                "                  \"type\": \"string\",\n" +
                "                  \"maxLength\": 255\n" +
                "                }\n" +
                "              }\n" +
                "            },\n" +
                "            \"ShowBonusBalance\": {\n" +
                "              \"type\": \"boolean\"\n" +
                "            },\n" +
                "            \"ListOfPersonalFields\": {\n" +
                "              \"type\": \"array\",\n" +
                "              \"items\": {\n" +
                "                \"type\": \"object\",\n" +
                "                \"required\": [\n" +
                "                  \"PersonalFields\"\n" +
                "                ],\n" +
                "                \"properties\": {\n" +
                "                  \"PersonalFields\": {\n" +
                "                    \"type\": \"string\",\n" +
                "                    \"maxLength\": 255\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            },\n" +
                "            \"ListOfTimeDependentAttributes\": {\n" +
                "              \"type\": \"array\",\n" +
                "              \"items\": {\n" +
                "                \"type\": \"object\",\n" +
                "                \"required\": [\n" +
                "                  \"TimeDependentAttributes\"\n" +
                "                ],\n" +
                "                \"properties\": {\n" +
                "                  \"TimeDependentAttributes\": {\n" +
                "                    \"type\": \"string\",\n" +
                "                    \"maxLength\": 255\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            },\n" +
                "            \"ListOfEntityAttributes\": {\n" +
                "              \"type\": \"array\",\n" +
                "              \"items\": {\n" +
                "                \"type\": \"object\",\n" +
                "                \"required\": [\n" +
                "                  \"EntityAttributes\"\n" +
                "                ],\n" +
                "                \"properties\": {\n" +
                "                  \"EntityAttributes\": {\n" +
                "                    \"type\": \"string\",\n" +
                "                    \"maxLength\": 255\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"additionalProperties\": false\n" +
                "    }\n" +
                "  },\n" +
                "  \"additionalProperties\": false\n" +
                "}"));
        test.validate(new JSONObject(
                "{\n" +
                        "  \"header\": {\n" +
                        "    \"ServiceName\": \"SrvGetSpasiboClientInfoRq\",\n" +
                        "    \"ServiceDescription\": \"description\",\n" +
                        "    \"ServiceVersion\": \"001\",\n" +
                        "    \"OperationName\": \"GetSpasiboClientInfo\",\n" +
                        "    \"SPName\": \"urn:sbrfsystems:99-asfm\",\n" +
                        "    \"SCName\": \"urn:sbrfsystems:99-vp\",\n" +
                        "    \"ServiceNamespace\": \"srv://sbg.sbr/federal\",\n" +
                        "    \"RqUID\": \"1de9814ae3dc9907bf8e52e01b769485\",\n" +
                        "    \"RqTm\": \"2020-04-06T13:07:19\"\n" +
                        "  },\n" +
                        "  \"body\": {\n" +
                        "    \"GetSpasiboClientInfoRq\": {\n" +
                        "      \"RqUID\": \"1de9814ae3dc9907bf8e52e01b769485\",\n" +
                        "      \"RqTm\": \"2020-04-06T13:07:19\",\n" +
                        "      \"SPName\": \"urn:sbrfsystems:99-vp\",\n" +
                        "      \"Identifier\": {\n" +
                        "        \"Id\": \"123456789\",\n" +
                        "        \"Type\": \"Something\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}"));
    }
}

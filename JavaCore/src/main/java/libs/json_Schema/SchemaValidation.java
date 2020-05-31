package libs.json_Schema;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Описание схемы для валидации json
 *
 * https://json-schema.org/understanding-json-schema/
 *
 * null
 * { "type": "null" }
 *
 * { "type": ["number", "string"] }
 *
 *
 * object
 * {
 *   "type": "object",
 *   "properties": {
 *     "name":      { "type": "string" },
 *     "email":     { "type": "string" },
 *     "address":   { "type": "string" },
 *     "telephone": { "type": "string" }
 *   },
 *   "required": ["name", "email"],
 *   "additionalProperties": false,
 *   "propertyNames": {
 *     "pattern": "^[A-Za-z_][A-Za-z0-9_]*$"
 *   }
 *
 * }
 *
 *
 * integer
 * { "type": "integer" }
 *
 *
 * number
 * {
 *   "type": "number",
 *   "multipleOf": 1.0
 *   "minimum": 0,
 *   "maximum": 100,
 *   "exclusiveMaximum": true // не включать maximum (100)
 * }
 *
 *
 * string
 * {
 *   "type": "string",
 *   "enum": ["val1", "val2"],
 *   "minLength": 2,
 *   "maxLength": 3,
 *   "pattern": "^(\\([0-9]{3}\\))?[0-9]{3}-[0-9]{4}$"
 * }
 *
 *
 * array
 * {
 *   "type": "array",
 *   "items": {
 *     "type": "number"
 *   },
 *   "uniqueItems": true
 * }
 *
 */
public class SchemaValidation {

    private static final String SCHEMA_PATH = "JavaCore\\src\\main\\resources\\SrvGetSpasiboClientInfoRqSchema.json";
    private static final String JSON_PATH = "JavaCore\\src\\main\\resources\\SrvGetSpasiboClientInfoRq.json";

    public static void main(String[] args) throws IOException {
        //Загрузка схемы
        String stringSchema = new String(Files.readAllBytes(Paths.get(SCHEMA_PATH)));
        Schema schema = SchemaLoader.load(new JSONObject(stringSchema));

        //Загрузка json
        String stringRequest = new String(Files.readAllBytes(Paths.get(JSON_PATH)));
        JSONObject jsonRequest = new JSONObject(stringRequest);

        //Валидация
        schema.validate(jsonRequest);
    }
}

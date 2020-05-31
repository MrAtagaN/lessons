package libs.json_Schema;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SchemaValidation {

    public static void main(String[] args) throws IOException {
        //Загрузка схемы
        String stringSchema = new String(Files.readAllBytes(Paths.get("JavaCore\\src\\main\\resources\\SrvGetSpasiboClientInfoRqSchema.json")));
        Schema schema = SchemaLoader.load(new JSONObject(stringSchema));

        //Загрузка json
        String stringRequest = new String(Files.readAllBytes(Paths.get("JavaCore\\src\\main\\resources\\SrvGetSpasiboClientInfoRq.json")));
        JSONObject jsonRequest = new JSONObject(stringRequest);

        //Валидация
        schema.validate(jsonRequest);
    }
}

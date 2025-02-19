package JSONPrograms.HandsOnPracticeProblems;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;


 class VlidateFields {
    public static void main(String[] args) {
        String schemaJson = "{"
                + "\"type\": \"object\","
                + "\"properties\": {"
                + "  \"email\": {\"type\": \"string\", \"format\": \"email\"}"
                + "},"
                + "\"required\": [\"email\"]"
                + "}";

        String validEmailJson = "{ \"email\": \"test@example.com\" }";
        String invalidEmailJson = "{ \"email\": \"invalid-email\" }";

        validateEmail(schemaJson, validEmailJson);
        validateEmail(schemaJson, invalidEmailJson);
    }

    public static void validateEmail(String schemaJson, String jsonData) {
        try {
            Schema schema = SchemaLoader.load(new JSONObject(schemaJson));
            schema.validate(new JSONObject(jsonData));
            System.out.println("Valid JSON: " + jsonData);
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + jsonData);
            System.out.println("Reason: " + e.getMessage());
        }
    }
}

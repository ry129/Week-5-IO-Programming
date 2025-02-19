package JSONPrograms.PracticeProblems.ValidateJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class ValidateByJackson {
    public static void main(String[] args) {
        String filePath = "D:\\capgemini\\Week05-Capgemini\\Day02\\src\\main\\java\\JSONPrograms\\PracticeProblems\\ValidateJson\\JsonData";
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File(filePath));
            if(rootNode.has("name") && rootNode.has("email")) {
                if (rootNode.get("name").isTextual() && rootNode.get("email").isTextual()) {
                    System.out.println("Valid JSON Structure");
                    System.out.println(rootNode.get("name").asText());
                    System.out.println(rootNode.get("email").asText());
                } else {
                    System.out.println("Invalid Field Types");
                }
            }
                else {
                    System.out.println("Invalid JSON Structure");
                }

            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
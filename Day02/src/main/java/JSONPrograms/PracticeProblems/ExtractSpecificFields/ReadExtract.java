package JSONPrograms.PracticeProblems.ExtractSpecificFields;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

// POJO class to map JSON data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore extra fields
class User {
    private String name;
    private String email;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

 class ReadJsonExtractDetails {
    public static void main(String[] args) {
        String filePath = "D:\\capgemini\\Week05-Capgemini\\Day02\\src\\main\\java\\JSONPrograms\\PracticeProblems\\ExtractSpecificFields\\Json.data";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file and map it to List of User objects
            List<User> users = objectMapper.readValue(new File(filePath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));

            // Print name and email only
            for (User user : users) {
                System.out.println("Name: " + user.getName() + ", Email: " + user.getEmail());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

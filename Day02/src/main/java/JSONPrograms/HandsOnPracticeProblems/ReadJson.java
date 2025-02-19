package JSONPrograms.HandsOnPracticeProblems;






import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

    class ReadJson{
        public static void main(String[] args) {
            try {

                ObjectMapper objectMapper = new ObjectMapper();


                Map<String, Object> data = objectMapper.readValue(new File("data.json"), Map.class);


                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




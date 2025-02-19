package JSONPrograms.HandsOnPracticeProblems;

import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

 class JsonToXML {
    public static void main(String[] args) {
        try {
            // Read JSON data from file
            String jsonContent = new String(Files.readAllBytes(Paths.get("data.json")));

            // Convert JSON string to JSONObject
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Convert JSONObject to XML string
            String xmlContent = XML.toString(jsonObject);

            // Print the XML output
            System.out.println("<root>" + xmlContent + "</root>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

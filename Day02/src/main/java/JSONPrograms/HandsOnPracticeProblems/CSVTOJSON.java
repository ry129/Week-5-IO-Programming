package JSONPrograms.HandsOnPracticeProblems;

import com.opencsv.CSVReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVTOJSON {
    public static void main(String[] args) {
        String csvFile = "data.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> data = reader.readAll();

            String[] headers = data.get(0); // Get column headers

            List<Map<String, String>> records = new ArrayList<>();
            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                Map<String, String> record = new HashMap<>();
                for (int j = 0; j < headers.length; j++) {
                    record.put(headers[j], row[j]);
                }
                records.add(record);
            }

            // Convert List to JSON
            ObjectMapper mapper = new ObjectMapper();
            String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);
            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

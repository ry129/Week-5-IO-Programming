package JSONPrograms.HandsOnPracticeProblems;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class JSONReport {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/your_database";
            String user = "root";
            String password = "password";

            String query = "SELECT id, name, age FROM employees";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                List<Map<String, Object>> records = new ArrayList<>();

                while (rs.next()) {
                    Map<String, Object> record = new HashMap<>();
                    record.put("id", rs.getInt("id"));
                    record.put("name", rs.getString("name"));
                    record.put("age", rs.getInt("age"));
                    records.add(record);
                }

                // Convert List to JSON
                ObjectMapper mapper = new ObjectMapper();
                String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);
                System.out.println(jsonOutput);

            } catch (SQLException | com.fasterxml.jackson.core.JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }



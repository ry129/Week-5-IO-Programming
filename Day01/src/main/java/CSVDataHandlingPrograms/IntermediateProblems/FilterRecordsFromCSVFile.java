package CSVDataHandlingPrograms.IntermediateProblems;

import java.io.*;

public class FilterRecordsFromCSVFile {
    public static void main(String[] args) {
        String inputFile = "students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (Double.parseDouble(columns[3]) > 80) {
                  System.out.println("Name : " + columns[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

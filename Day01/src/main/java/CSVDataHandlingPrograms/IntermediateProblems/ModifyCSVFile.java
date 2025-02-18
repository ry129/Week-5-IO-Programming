package CSVDataHandlingPrograms.IntermediateProblems;
import java.io.*;

public class ModifyCSVFile {
    public static void main(String[] args) {
        String path = "employee.csv";
       String newfile = "output.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(newfile))
        ) {
            String line;
            line = br.readLine();
           writer.write(line + "\n"); // Write header

            while ((line = br.readLine()) != null) {
                String[] col = line.split(",");

                if (col.length < 4) {
                    System.out.println("Skipping line (insufficient data): " + line);
                    continue;
                }

                double salary = Double.parseDouble(col[3].trim());
                salary += salary * 0.1;
                col[3] = String.format("%.2f", salary); // Format to 2 decimal places

                String res = col[0] + "," + col[1] + "," + col[2] + "," + col[3];
                writer.write(res + "\n");
            }

            System.out.println("CSV file processed successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error !!! " + e.getMessage());
        }
    }
}

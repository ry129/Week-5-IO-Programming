package CSVDataHandlingPrograms.AdvanceProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath="regexFileData";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        String phoneRegex ="^\\d{10}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line=br.readLine();
            while((line=br.readLine())!=null){

                String[] tokens = line.split(",");
                if(tokens.length<4){
                    System.out.println("Invalid Data");
                    continue;
                }
                String email = tokens[2].trim();
                String phone = tokens[3].trim();

              Matcher emailMatcher = emailPattern.matcher(email);
              Matcher phoneMatcher = phonePattern.matcher(phone);

              if (!emailMatcher.matches() || !phoneMatcher.matches()) {
                    System.out.println("Invalid record: " + line);
                }

            }
        }
        catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

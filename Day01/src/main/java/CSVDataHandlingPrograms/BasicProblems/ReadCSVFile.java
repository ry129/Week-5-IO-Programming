package CSVDataHandlingPrograms.BasicProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class ReadCSVFile {
    public static void main(String[] args) {
        String filePath="students.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line=br.readLine())!=null){
                String [] columns = line.split(",");
                System.out.println("ID:" + columns[0] + " , Name:" + columns[1] + " , Age:" + columns[2] + ", Marks:" + columns[3]);

            }
        }
        catch(IOException e){
            e.printStackTrace();

        }

    }
}
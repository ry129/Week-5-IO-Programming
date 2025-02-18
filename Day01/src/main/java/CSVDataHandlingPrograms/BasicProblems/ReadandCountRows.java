package CSVDataHandlingPrograms.BasicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadandCountRows {
    public static void main(String[] args) {
        String filePath="students.csv";
        int count =0;
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;
            while((line=br.readLine())!=null){
                String [] columns = line.split(",");
                System.out.println("ID:" + columns[0] + " , Name:" + columns[1] + " , Age:" + columns[2] + ", Marks:" + columns[3]);
                count++;
            }
            System.out.println("Number of Records are :  " + (count-1));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

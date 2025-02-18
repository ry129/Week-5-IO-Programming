package CSVDataHandlingPrograms.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchForRecord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Employee Name: ");
        String name = sc.nextLine();
        String fileName = "employee.csv";

        try(BufferedReader br=new BufferedReader(new FileReader(fileName))) {
            String line ;
            line = br.readLine();
            while((line = br.readLine())!=null){
                String[] record = line.split(",");
                if(name.equals(record[1])){
                    System.out.println("Deparment is : "+record[2] + " , Salary is : "+record[3]);
                    break;
                }
            }
            System.out.println("No Records Found");
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

}



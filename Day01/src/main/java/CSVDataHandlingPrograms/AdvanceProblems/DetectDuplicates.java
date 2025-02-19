
package com.advancedproblems.detectduplicates;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {
   public static void main(String[] args) {
       String filePath = "C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\advancedproblems\\detectduplicates\\student.csv";
       Set<String> uniqueIds = new HashSet<>(); 
       List<String[]> duplicateEntries = new ArrayList<>(); 

       try {
           FileReader fr = new FileReader(filePath);
           CSVReader reader = new CSVReader(fr);
           String[] header = reader.readNext(); 

           String[] nextLine;
           while ((nextLine = reader.readNext()) != null) {
               String id = nextLine[0];

               
               if (!uniqueIds.add(id)) {
                   duplicateEntries.add(nextLine); 
               }

           }

           
           if (!duplicateEntries.isEmpty()) {
               System.out.println("Duplicate Records Based on ID:");
               for (String[] row : duplicateEntries) {
                   System.out.println(Arrays.toString(row));
               }
           } else {
               System.out.println("No duplicate records found.");
           }

       } catch (IOException | CsvValidationException e) {
          e.printStackTrace();
       }
   }
}


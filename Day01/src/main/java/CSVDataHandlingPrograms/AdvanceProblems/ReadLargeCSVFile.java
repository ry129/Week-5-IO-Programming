
package com.advancedproblems.CSVchunkprocessor;

import java.io.*;

public class LargeCSVReader {
   public static void main(String[] args) {
       String filePath = "C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\advancedproblems\\CSVchunkprocessor\\largefile.csv";
       int batchSize = 100; 
       int count = 0;

       try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
           String line;
           br.readLine(); 

           while ((line = br.readLine()) != null) {
               count++;

               
               System.out.println("Processing Record: " + count);


               if (count % batchSize == 0) {
                   System.out.println("Processed " + count + " records so far...");
               }
           }

           System.out.println("Total Records Processed: " + count);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}


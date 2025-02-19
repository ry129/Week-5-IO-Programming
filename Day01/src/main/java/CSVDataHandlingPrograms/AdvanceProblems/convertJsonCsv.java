
package com.advancedproblems.jsonCSVconverter;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {

   
   public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
       try {
           
           BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
           StringBuilder jsonContent = new StringBuilder();
           String line;
           while ((line = reader.readLine()) != null) {
               jsonContent.append(line);
           }
           reader.close();

          
           JSONArray jsonArray = new JSONArray(jsonContent.toString());

        
           CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));

         
           if (jsonArray.length() > 0) {
               JSONObject firstObject = jsonArray.getJSONObject(0);
               List<String> header = new ArrayList<>(firstObject.keySet());
               writer.writeNext(header.toArray(new String[0]));

               
               for (int i = 0; i < jsonArray.length(); i++) {
                   JSONObject student = jsonArray.getJSONObject(i);
                   List<String> row = new ArrayList<>();
                   for (String key : header) {
                       row.add(student.optString(key, ""));
                   }
                   writer.writeNext(row.toArray(new String[0]));
               }
           }

           writer.close();
           System.out.println("JSON data has been written to CSV file: " + csvFilePath);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

  
   public static void csvToJson(String csvFilePath, String jsonFilePath) {
       try {
           
           CSVReader reader = new CSVReader(new FileReader(csvFilePath));
           List<String[]> rows = reader.readAll();
           reader.close();

           // Create JSON array
           JSONArray jsonArray = new JSONArray();
           String[] header = rows.get(0); 

          
           for (int i = 1; i < rows.size(); i++) {
               JSONObject studentJson = new JSONObject();
               String[] row = rows.get(i);

               for (int j = 0; j < header.length; j++) {
                   studentJson.put(header[j], row[j]);
               }

               jsonArray.put(studentJson);
           }

          
           BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFilePath));
           writer.write(jsonArray.toString(4)); 
           writer.close();

           System.out.println("CSV data has been written to JSON file: " + jsonFilePath);
       } catch (IOException | CsvException e) {
           e.printStackTrace();
       }
   }

   public static void main(String[] args) {
       // File paths for JSON and CSV
       String jsonFilePath = "C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\advancedproblems\\jsonCSVconverter\\student.json";
       String csvFilePath = "C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\advancedproblems\\jsonCSVconverter\\student.csv";

       // Convert JSON to CSV
       jsonToCsv(jsonFilePath, csvFilePath);

       // Convert CSV back to JSON
       String newJsonFilePath = "C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\advancedproblems\\jsonCSVconverter\\student_converter.json";
       csvToJson(csvFilePath, newJsonFilePath);
   }
}


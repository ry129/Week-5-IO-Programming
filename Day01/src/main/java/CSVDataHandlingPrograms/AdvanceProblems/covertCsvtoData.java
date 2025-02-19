
package com.advancedproblems.convertCSVintoobject;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Student {
   private int id;
   private String name;
   private String age;
   private int marks;

 
   public Student(int id, String name, String age, int marks) {
       this.id = id;
       this.name = name;
       this.age = age;
       this.marks = marks;
   }

   
   @Override
   public String toString() {
       return "Student{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age='" + age + '\'' +
               ", marks=" + marks +
               '}';
   }
}

public class ConvertCSVToObject {
   public static void main(String[] args) {
       String filePath = "C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\advancedproblems\\convertCSVintoobject\\studentdetatils.csv";
       List<Student> studentList = new ArrayList<>();

       
       try {
           FileReader fr = new FileReader(filePath);
           CSVReader csvReader = new CSVReader(fr);

           
           String[] header = csvReader.readNext();

           String[] nextLine;
           while ((nextLine = csvReader.readNext()) != null) {
               if (nextLine.length < 4) continue; 

               int id = Integer.parseInt(nextLine[0].trim());
               String name = nextLine[1].trim();
               String age = nextLine[2].trim();
               int marks = Integer.parseInt(nextLine[3].trim());

              
               Student student = new Student(id, name, age, marks);
               studentList.add(student);
           }

       } catch (IOException | CsvValidationException | NumberFormatException e) {
           System.err.println("Error reading CSV file: " + e.getMessage());
       }

     
       System.out.println("\nStudent List:");
       for (Student student : studentList) {
           System.out.println(student);
       }
   }
}


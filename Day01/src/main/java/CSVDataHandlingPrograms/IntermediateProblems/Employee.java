package CSVDataHandlingPrograms.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Employee {
    String id;
    String name;
    String department;
    double salary;

    Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + department + ", " + salary;
    }
}
class SortCSVBySalary {
    public static void main(String[] args) {
        String filePath = "employee.csv"; // Path to your CSV file
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String id = data[0].trim();
                    String name = data[1].trim();
                    String department = data[2].trim();
                    double salary = Double.parseDouble(data[3].trim());
                    employees.add(new Employee(id, name, department, salary));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        if (employees.isEmpty()) {
            System.out.println("No valid employee records found.");
            return;
        }

        // Sort by salary in descending order
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(employees.get(i));
        }
    }
}

package JSONPrograms.PracticeProblems.ObjectListToArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;
class Student{
    String name;
    int age;
    String email;

    Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public Student() {

    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
}
public class listToArrayJson {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("John Smith", 22, "john@gmail.com"));
        list.add(new Student("John Doe", 20, "john@gmail.com"));
        list.add(new Student("Sam ", 23, "john@gmail.com"));
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println(jsonArray);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

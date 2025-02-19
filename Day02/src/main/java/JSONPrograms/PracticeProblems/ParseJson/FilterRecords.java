package JSONPrograms.PracticeProblems.ParseJson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


class Person {
    private String name;
    private int age;
    private String email;


    public Person() {
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

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

class FilterRecords {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String filename ="D:\\capgemini\\Week05-Capgemini\\Day02\\src\\main\\java\\JSONPrograms\\PracticeProblems\\ParseJson\\people";

        try {

            List<Person> people = mapper.readValue(new File(filename), new TypeReference<List<Person>>() {});


            List<Person> filteredPeople = people.stream().filter(person -> person.getAge() > 25).collect(Collectors.toList());
            filteredPeople.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

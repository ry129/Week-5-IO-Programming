package JSONPrograms.PracticeProblems.CreateJSONObject;
import org.json.JSONObject;
import org.json.JSONArray;
public class objectUsingArray {
    public static void main(String[] args) {

        JSONArray subjects = new JSONArray();
        subjects.put("Java");
        subjects.put("C++");
        subjects.put("Python");
        subjects.put("JavaScript");


        JSONObject user = new JSONObject();
        user.put("Name", "John");
        user.put("Age", 23);
        user.put("subjects", subjects);
        System.out.println(user.toString());

    }


}

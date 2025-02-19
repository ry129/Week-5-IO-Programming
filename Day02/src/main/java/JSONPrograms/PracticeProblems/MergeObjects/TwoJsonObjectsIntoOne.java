package JSONPrograms.PracticeProblems.MergeObjects;
import org.json.JSONObject;
public class TwoJsonObjectsIntoOne {
    public static JSONObject Object1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Alice");
        jsonObject.put("age", 25);
        jsonObject.put("email", "alice@example.com");
         return jsonObject;
    }
    public static JSONObject Object2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Grade", 'A');
        jsonObject.put("Gender", "female");
        jsonObject.put("Phone", "905678999");
       return jsonObject;
    }
    public static void main(String[] args) {
       JSONObject obj1 = Object1();
       JSONObject obj2 = Object2();

        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }

        // Print the merged JSON object
        System.out.println("Merged JSON Object: " + obj1.toString());
    }
}



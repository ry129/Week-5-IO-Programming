package JSONPrograms.PracticeProblems.CreateJavaObjectintoJson;
import com.fasterxml.jackson.databind.ObjectMapper;

 class Car{
    public String CarName;
    public String CarModel;
    public int CarYear;
     Car(String CarName, String CarModel, int CarYear) {
         this.CarName = CarName;
         this.CarModel = CarModel;
         this.CarYear = CarYear;
     }
 }
public class JavaObjectToJSON {
     public static void main(String[] args) {
         try{
             ObjectMapper mapper = new ObjectMapper();
             Car car=new Car("Safari","234A56",2020);
             String jsonString = mapper.writeValueAsString(car);
             System.out.println(jsonString);
         }
         catch(Exception e){
             e.printStackTrace();
         }
     }
}

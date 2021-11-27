import org.json.*;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;


public class MainApp {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("C:/Users/Gustavo/Desktop/ws/programming/courses/java-studies/challenge-cross/src/main/finalFile.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray file = (JSONArray) jsonObject.get("Array");

            Iterator<JSONObject> iterator = file.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}

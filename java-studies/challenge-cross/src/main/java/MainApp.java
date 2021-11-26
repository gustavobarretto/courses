import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainApp {
    public static void main(String[] args) {

        for(int i = 8000; i <= 10000; i++) {

            try {
                URL url = new URL("http://challenge.dienekes.com.br/api/numbers?page=" + i);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/json");
                if(connection.getResponseCode() != 200) {
                    throw new RuntimeException("Failed: HTTP Error code: " + connection.getResponseCode());
                }

                InputStreamReader in = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(i);
                    System.out.println(output);
                }
                connection.disconnect();


            } catch(Exception e) {

            }

        }
        System.out.println("Cabou 10.000");

    }

}

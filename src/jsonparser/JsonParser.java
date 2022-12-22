package jsonparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * JsonParser
 */
public class JsonParser {

    public static void main(String[] args) throws IOException {
        String post_id = null;
        String message = null;
        String postName = null;
        String jsonFileName = "src/jsonparser/sampleJsonfile.json";
        BufferedReader reader = new BufferedReader(new FileReader(jsonFileName));
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            stringBuilder.append(new String(buffer));
            buffer = new char[10];
        }
        reader.close();

        String content = stringBuilder.toString();
        //System.out.println(content);

        JSONObject obj = new JSONObject(content);
       // System.out.println(obj);

        String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        System.out.println("Page Name" + pageName);

        JSONArray arr = obj.getJSONArray("posts"); // notice that `"posts": [...]`
        for (int i = 0; i < arr.length(); i++)
        {
            post_id = arr.getJSONObject(i).getString("post_id");
            message = arr.getJSONObject(i).getString("message");
            postName = arr.getJSONObject(i).getString("nameOfPersonWhoPosted");
           
        }
        System.out.println("Post Id: "+ post_id);
        System.out.println("Message: "+ message);
        System.out.println("Name Of Person Who Posted: " + postName);

    }
}
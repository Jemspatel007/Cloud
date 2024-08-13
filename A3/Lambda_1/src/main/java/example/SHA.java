package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

import static example.Hashing.generateSHA256;
import static example.Response.executePostRequest;

public class SHA implements RequestHandler<Map<String, String>, Map<String, String>> {

    @Override
    public Map<String, String> handleRequest(Map<String, String> input, Context context) {
        String url = input.get("course_uri");
        String action = input.get("action");
        String value = input.get("value");
        String hashedValue = generateSHA256(value);

        Map<String, String> output = new HashMap<>();
        output.put("banner", "B00984406");
        output.put("result", hashedValue);
        output.put("arn", "arn:aws:lambda:us-east-1:297323627892:function:SHA");
        output.put("action", action);
        output.put("value", value);

        String jsonResponse = new Gson().toJson(output);

        executePostRequest(url, jsonResponse);

        return output;
    }
}
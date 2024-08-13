package example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Response {

    static void executePostRequest(String endpoint, String jsonPayload) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost postRequest = new HttpPost(endpoint);
            postRequest.setEntity(new StringEntity(jsonPayload, "UTF-8"));
            postRequest.setHeader("Content-Type", "application/json");
            try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                System.out.println("Response Status: " + response.getStatusLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
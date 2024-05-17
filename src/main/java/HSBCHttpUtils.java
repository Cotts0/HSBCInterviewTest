import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HSBCHttpUtils {
    final static HttpClient client = HttpClient.newHttpClient();

    public static String doGet(String url) {
        try {
            System.out.println("to url:" + url + "  send request --- start ----");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println("Catch http exception--->" + e.getCause());
        }
        return null;
    }
}

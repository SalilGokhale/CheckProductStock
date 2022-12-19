import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://www.lakeland.co.uk/21736/dry-soon-3-tier-heated-airer"))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String webPage = (String) response.body();

            if (webPage.contains("Sorry, due to unprecedented demand we are now sold out of this item!")) {
                System.out.println("Product not in stock!");
            } else {
                System.out.println("Product is in stock!");
            }
        } catch (Exception e) {

        }

    }
}
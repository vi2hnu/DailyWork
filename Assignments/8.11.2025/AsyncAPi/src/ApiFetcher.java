import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ApiFetcher implements Callable<String> {
    private final URL url;
    public ApiFetcher(String url) throws MalformedURLException {
        this.url = new URL(url);
    }
    public String fetch() throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        String response = "";
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            response += scanner.nextLine();
        }
        return response;
    }

    @Override
    public String call() throws Exception {
        try {
            String response = fetch();
            return response;
        } catch (IOException e) {
           return e.getMessage();
        }
    }
}

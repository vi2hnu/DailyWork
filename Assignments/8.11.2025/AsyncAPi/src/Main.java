import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args){
        String url1 = "https://fake-json-api.mock.beeceptor.com/users";
        String url2 = "https://fake-json-api.mock.beeceptor.com/companies";
        ExecutorService executor = Executors.newFixedThreadPool(1);
        try{
            ApiFetcher api1 = new ApiFetcher(url1);
            ApiFetcher api2 = new ApiFetcher(url2);
            Future<String> response1 = executor.submit(api1);
            Future<String> response2 = executor.submit(api2);
            System.out.println("Response 1= "+response1.get());
            System.out.println("Response 2= "+response2.get());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
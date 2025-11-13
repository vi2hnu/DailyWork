import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(scanner.next());
        }
        list.stream().filter(s -> s.contains("a")).forEach(s -> System.out.println(s));
    }
}

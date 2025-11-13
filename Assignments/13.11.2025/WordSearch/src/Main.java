import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        File file = new File("input.txt");
        StringBuilder lines = new StringBuilder();
        try{
            Scanner input = new Scanner(file);
            while(input.hasNextLine()) {
                lines.append(input.nextLine());
                lines.append(" ");
            }
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        List<String> linesArray = List.of(lines.toString().split("\\W+"));
        long numberOfIndia = linesArray.stream()
                .filter(word->word.equalsIgnoreCase("India"))
                .count();

        System.out.println(numberOfIndia);
    }
}
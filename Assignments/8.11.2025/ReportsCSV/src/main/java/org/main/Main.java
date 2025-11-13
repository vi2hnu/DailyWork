package org.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main
{
    public static void main( String[] args ) {
        /*
            form the csv file
                0 = no.
                1 = date
                2 = category
                3 = item name
                4 = number of amount
                5 = single price
                6 = total price
         */
        File file = new File("src/main/resources/random_sales_data.csv");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                ArrayList<String> row = new ArrayList<>(Arrays.asList(line.split(",")));
                data.add(row);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        System.out.println("Enter the date to find the items sold that on day: (yyyy-mm-dd)");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        data.stream()
                .forEach(
                        x->{
                            if(x.get(1).equals(date)){
                                System.out.println(x.get(3));
                            }
                        }
                );
        System.out.println();
        Map<String,Double> items = data.stream()
                .collect(Collectors.groupingBy(row->row.get(3),Collectors.summingDouble(row->Double.parseDouble(row.get(6)))));
        System.out.println("All products sold and their total:");
        items.forEach((k,v)->{System.out.println(k+","+v);});
        System.out.println();
        
       Map<String,Long> count = data.stream()
               .collect(Collectors.groupingBy(row->row.get(3),Collectors.counting()));
       long mostSold =  Collections.max(count.values());
       List<String> mostSoldItems = count.keySet().stream()
               .filter(x->count.get(x).equals(mostSold))
               .toList();
       System.out.println("Most sold item/items "+mostSoldItems);
    }
}

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/appLogs.log");
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<String>> logs = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //check if empty
                logs.add(new ArrayList<String>(Arrays.asList(line.split(" "))));
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        //check for arraylist is empty
        boolean exit = false;
        LogParser parser = new LogParser(logs);
        while(!exit){
            System.out.println("1)Trace 2)Debug 3)Info 4)Warn 5)Error 6)Fatal 7)exit");
            System.out.println("Enter command:");
            int choice = input.nextInt();
            //string util
            switch (choice) {
                case 1:
                    parser.getData("trace");
                    break;
                case 2:
                    parser.getData("debug");
                    break;
                case 3:
                    parser.getData("info");
                    break;
                case 4:
                   parser.getData("warn");
                   break;
                case 5:
                    parser.getData("error");
                    break;
                case 6:
                    parser.getData("fatal");
                    break;
                case 7:
                    exit = true;
            }
        }
    }
}

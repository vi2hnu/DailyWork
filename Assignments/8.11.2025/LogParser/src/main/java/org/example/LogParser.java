package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class LogParser {
    private ArrayList<ArrayList<String>>logs;
    public LogParser(ArrayList<ArrayList<String>> logs) {
        this.logs = logs;
//        for(int i=0;i<logs.get(0).size();i++){
//            System.out.println(logs.get(0).get(i)+" "+i);
//        }
    }
    public void getData(String data){
        System.out.println("All "+ data+ " Level logs:");
        String input = "["+data.toUpperCase()+"]";  //trace [TRACE] []
        logs.stream()
                .filter(x->x.get(2).equals(input))
                .forEach(System.out::println);

        Map<String,Long> dict = logs
                .stream()
                .filter(x->x.get(2).equals(input))
                .collect(Collectors.groupingBy(x->x.get(3),Collectors.counting()));

        if(dict.isEmpty()){ //try to use map util
            System.out.println("No logs found");
            return;
        }
        long maxValue = Collections.max(dict.values());

        List<String> app = dict.entrySet().stream()
                .filter(e -> e.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Most logged app/apps "+ app);
    }
}

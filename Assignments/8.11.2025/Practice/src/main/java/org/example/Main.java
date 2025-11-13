package org.example;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class Main {
    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.add("Alice");
//        names.add("Bob");
//        names.add("Charlie");
//        names.add("");
//        names.add(" ");
//        names.add("David");
//        names.add("Alice");
//        System.out.println(names.stream()
//                .max(Comparator.comparing(String::length)).get());
//
//        names.stream()
//                .collect(Collectors.toSet())
//                .stream()
//                .sorted()
//                .forEach(System.out::println);

//        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        nums.add(4);
//        nums.add(5);
//        nums.add(6);
//        nums.add(7);
//        nums.add(8);
//        nums.add(9);
//        nums.add(10);
//
//        double x = nums.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//        System.out.println(x);

        String line = "the quick brown fox jumps over the lazy dog";
        Map<Character,Long> dict = line.chars()
                                        .mapToObj(c -> (char) c)
                                        .collect(Collectors.groupingBy(x->x,Collectors.counting()));
        Long maxValue = Collections.max(dict.values());
        System.out.println(dict.keySet().stream().filter(x->dict.get(x)==maxValue).collect(Collectors.toList()));
    }
}

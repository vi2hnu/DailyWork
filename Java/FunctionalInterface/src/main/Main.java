package main;

import java.util.*;
import java.util.function.*;

public class Main {
	public static void main(String[] args) {
		Predicate<String> check =  x->x.startsWith("J");
		Consumer<String> consumer = x->System.out.println(x);
		Function<String,String> hello = x->x.substring(0,1);
		
		if(check.test("James")==true) {
			System.out.println("Yes");
		}
		consumer.accept("Hello");
		System.out.println(hello.apply("Hello"));
		ArrayList<String> accounts = new ArrayList<String>();
		accounts.add(null);
		accounts.stream().sorted().forEach(System.out::println);
		
	}
}

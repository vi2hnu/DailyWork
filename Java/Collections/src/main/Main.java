package main;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<>();
		map.put("Amazon", "John");
		map.put("google", "Doe");
		map.put("TCS","Roy");
		map.put("IDFC", "Paul");
		map.put("Meta","mark");
		int found = 0;
		for(String i: map.keySet()) {
			if(i=="Cognizant") {
				found=1;
				if(map.get(i)=="Ram") {
					System.out.println("Ram is working in Cognizant");
				}
			}
		}
		if(found==0) {
			map.put("Cognizant","Ram");
			System.out.println("Cognizant added");
		}
		
	}
}

package main;
import java.io.*;

public class Files {
	public static void main(String[] args) throws Exception{
		try {
			File file = new File("input.txt");
			file.createNewFile();
			FileWriter writer = new FileWriter("input.txt");
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

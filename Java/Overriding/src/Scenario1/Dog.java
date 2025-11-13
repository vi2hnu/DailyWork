package Scenario1;
import java.util.*;
import java.io.*;

class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg);
    }
}

public class Dog extends Animal {
	public static void moving() {
		System.out.println("dog is moving");
	}
	
	public static void check(int x) throws CustomException{
		if (x < 0) {
            throw new CustomException("Number cannot be negative");
        }
		System.out.println("code is running");
	}
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		try {
			int res = 10/x;
			System.out.println(res);
		}
		catch(ArithmeticException e) {
			System.out.println("Error: Division by 0");
		}
		
		x = input.nextInt();
		int y = input.nextInt();
		int array[] = {10,2,10};
		try {
			array[x] /= y;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Out of bound");
		}
		catch(ArithmeticException e) {
			System.out.println("Error: Division by 0");
		}
		
		try {
            FileReader fr = new FileReader("data.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
		
		
		try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line = br.readLine();
        } catch (IOException e) {
            System.out.println("IO Error occurred: " + e.getMessage());
        }
		
		x = input.nextInt();
		check(x);
		
	}
}

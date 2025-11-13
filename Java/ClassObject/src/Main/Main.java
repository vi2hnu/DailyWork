package Main;
import car.Car;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Car details in this order:");
        System.out.println("Model Colour downPayment rateOfInterest LoanTenure");
        System.out.print("Input: ");

        String model = input.next();
        String colour = input.next();
        double downPayment = input.nextDouble();
        double roi = input.nextDouble();
        int loanTenure = input.nextInt();

        Car car = new Car(model, downPayment, roi, colour, loanTenure);

        System.out.println();
        System.out.println("Car details:");
        car.printDetails();
        System.out.println();
//        System.out.println("Simple interest:");
//        System.out.println(car.calculateSimpleInterest());
//        System.out.println();
//        System.out.println("Compound interest:");
//        System.out.println(car.calculateCompoundInterest());
//        System.out.println();
//        System.out.println("EMI:");
//        System.out.println(car.calculateEmi());
        System.out.println("Which calculator do you need:(1) Simple interest, 2) Compound Interest, 3) EMI, 4) exit");
        boolean exit = false;
        while(!exit) {
        	int x = input.nextInt();
	        switch(x) {
	        	
		        case 1:
		        	  System.out.println("Simple interest:");
			          System.out.println(car.calculateSimpleInterest());
			          System.out.println();
			          break;
		        case 2:
		      	      System.out.println("Compound interest:");
		      	  	  System.out.println(car.calculateCompoundInterest());
			          System.out.println();
			          break;
		        case 3:
		      	  	  System.out.println("EMI:");
			          System.out.println(car.calculateEmi());
			          System.out.println();
			          break;
		        case 4:
		        	exit = true;
		     }
        }
        input.close();
		
	}
}

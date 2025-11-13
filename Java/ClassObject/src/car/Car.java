package car;
import loan.Loan;
public class Car {
	String model;
	double cost;
	double downPayment;
	String colour;
	double rateOfInterest;
	double loanAmount;
	int loanTenure;
	
	private double getCostByModel(String model) {
        switch(model.toLowerCase()) {
            case "delta":
                return 800000;
            case "alpha":
                return 1200000;
            case "beta":
                return 1000000;
            default:
            	throw new IllegalArgumentException("Unknown car model: " + model);
        }
    }
	
    public Car(String model, double downPayment,double rateOfInterest,String colour, int loanTenure) {
		this.model = model;
		this.cost = getCostByModel(model);
		this.downPayment = downPayment;
		this.rateOfInterest = rateOfInterest;
		this.colour = colour;
		this.loanAmount = cost-downPayment;
		this.loanTenure = loanTenure;
    }
	
	public void printDetails() {
		System.out.println("Car Model: Baleno," + model);
		System.out.println("Car Colour: " + colour);
		System.out.println("Car Cost: " + cost);
		System.out.println("Down payment: " + downPayment);
		System.out.println("Rate of interest: " + rateOfInterest);
		System.out.println("Loan Amount: " + loanAmount);
		System.out.println("Loan Tenure (years): " + loanTenure);
	}

	public double calculateSimpleInterest(){
		return Loan.SimpleInterest(loanAmount, rateOfInterest, loanTenure);
	}

	public double calculateCompoundInterest(){
		return Loan.CompoundInterest(loanAmount,rateOfInterest,loanTenure);
	}
	
	public double calculateEmi() {
		return Loan.Emi(loanAmount, rateOfInterest,loanTenure);
	}
}

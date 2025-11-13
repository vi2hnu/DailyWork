package loan;

public class Loan {
    public static double SimpleInterest(double principal, double rateOfInterest, int time) {
        return (principal * rateOfInterest * time) / 100;
    }

    public static double CompoundInterest(double principal, double rateOfInterest, int time) {
    	double rate = rateOfInterest / 100;
        return principal * (Math.pow((1 +rate), time)) - principal;
    }
    
    public static double Emi(double principle,double rateOfInterest, int time) {
    	double rate = rateOfInterest / 100 / 12; 
        int months = time * 12;  
        double emi = (principle * rate * Math.pow(1 + rate, months)) /(Math.pow(1 + rate, months) - 1);
        return emi;
    }
}

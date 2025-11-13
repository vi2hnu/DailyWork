package account;

public class Account {
	public double balance = 500;
	
	public double increment(double amount) {
		balance+=amount;
		return balance;
	}
	public double decrement(double amount) {
		balance-=amount;
		return balance;
	}
}

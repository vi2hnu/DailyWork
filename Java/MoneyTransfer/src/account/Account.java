package account;

public class Account {
	String name;
	String country;
	String accountNumber;
	double balance;
	
	public Account(String name, String country, String accountNumber, double balance) {
		this.name = name;
		this.country = country;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}
	
	public void reduceAmount(double amount) {
		balance-=amount;
	}
	public void addAmount(double amount) {
		balance+=amount;
	}
	
}

package user;

import java.util.ArrayList;
import java.util.List;

public class User {
	String username;
	String password;
	long accountNumber;
	double balance;
	List<User> beneficiaries;
	
	public User(String username,long accountNumber,String password) {
		this.username = username;
		this.password = password;
		this.accountNumber = accountNumber;
		this.balance = 100; //should be 0 but demonstration wont be possible
		this.beneficiaries = new ArrayList<>(); 
	}
	
	public List<User> getBeneficiaries(){
		return beneficiaries;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void addAmount(double amount) {
		balance+=amount;
		return;
	}
	
	public void reduceAmount(double amount) {
		balance-=amount;
		return;
	}
	
	public void addBeneficiary(User beneficiary) {
		beneficiaries.add(beneficiary);
	}

	public long getAccountNumber() {
		return accountNumber;
	}
}

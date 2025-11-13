package test;


public class AccountService {
	String accountNumber;
	double balance;
	
    public AccountService(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public boolean exists(String accountNumber) {
    	if(accountNumber.length()!=10) {
    		return false;
    	}
    	return true;
    }
    public double getBalance(String accountNumber) {
    	return balance;
    }
    public boolean debit(String accountNumber, double amount) {
    	if(balance<amount) {
    		return false;
    	}
    	balance-=amount;
    	return true;
    }
    public boolean credit(String accountNumber, double amount) {
    	if(balance<amount) {
    		return false;
    	}
    	balance-=amount;
    	return true;
    }
}
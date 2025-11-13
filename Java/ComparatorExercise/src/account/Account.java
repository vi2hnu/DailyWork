package account;
//accountholdername,accountno,transcode,country,ifsccode,balance
public class Account {
	String accountHolderName;
	String accountNo;
	String transCode;
	String country;
	String ifsccode;
	double balance;
	
	public Account(String accountHolderName, String accountNo, String transCode, String country, String ifsccode,double balance) {
		this.accountHolderName = accountHolderName;
		this.accountNo = accountNo;
		this.transCode = transCode;
		this.country = country;
		this.ifsccode = ifsccode;
		this.balance = balance;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public double getBalance() {
		return balance;
	}
	
}

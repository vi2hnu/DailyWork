package transaction;
import exceptions.*;
import account.Account;
import record.TransactionRecord;
public class TransactionImplementation implements TransactionInterface{
	
	boolean checkTransactionPossible(Account fromUser,double amount) {
		return fromUser.getBalance()<amount;
	}
	
	boolean checkAmount(double amount) {
		return amount<=0;
	}	
	
	@Override
	public void transaction(TransactionRecord transaction)
	        throws InsufficientBalanceException, InvalidAmountException {
	
	    if (checkAmount(transaction.amount())) {
	        throw new InvalidAmountException("Amount must be greater than 0");
	    }
	
	    if (checkTransactionPossible(transaction.sender(),transaction.amount())) {
	        throw new InsufficientBalanceException("Insufficient balance for this transaction");
	    }
		
		transaction.sender().reduceAmount(transaction.amount());
		transaction.receiver().addAmount(transaction.amount());
		System.out.println("Payment Successfull");
	}
}

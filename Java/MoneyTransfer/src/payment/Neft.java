package payment;
import transaction.*;
import exceptions.*;
import record.TransactionRecord;
public class Neft implements PaymentProcess{
	private TransactionInterface handler;
	
	public Neft(TransactionInterface handler) {
		this.handler = handler;
	}
	
	@Override
	public void makePayment(TransactionRecord transaction) {
		System.out.println("Making transaction");
		try {
			handler.transaction(transaction);
		}
		catch (InsufficientBalanceException e) {
			System.out.println(e);
		}
		catch(InvalidAmountException e) {
			System.out.println(e);
		}
		
		
	}
}

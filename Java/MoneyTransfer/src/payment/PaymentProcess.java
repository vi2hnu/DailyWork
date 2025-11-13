package payment;
import record.TransactionRecord;

public interface PaymentProcess {
	public void makePayment(TransactionRecord transaction);
}

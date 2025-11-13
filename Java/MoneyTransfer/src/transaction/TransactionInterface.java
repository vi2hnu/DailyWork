package transaction;
import exceptions.*;
import record.TransactionRecord;
public interface TransactionInterface {
	public void transaction(TransactionRecord transaction) throws InsufficientBalanceException, InvalidAmountException;
}

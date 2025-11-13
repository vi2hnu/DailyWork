package transaction;
import exceptions.*;
import user.User;

public interface TransactionInterface{
	public void transaction(User fromUser,User toUser,double amount) throws InvalidAmountException, InsufficientBalanceException, PaymentGatewayTimeoutException ;
}

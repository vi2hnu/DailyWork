package payment;
import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;
import exceptions.PaymentGatewayTimeoutException;
import transaction.TransactionInterface;
import user.User;

public class Upi implements ProcessPayment{
	private TransactionInterface handler;
	
	public Upi(TransactionInterface handler) {
		this.handler = handler;
	}
	
	public void makePayment(User fromUser,User toUser,double amount) {
		System.out.println("Making payment using UPI");
		//transaction here
		try {
            handler.transaction(fromUser, toUser, amount);
            System.out.println("Credit card payment successful");
        } catch (InvalidAmountException e) {
            System.out.println("Payment failed: Invalid amount — " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Payment failed: Insufficient balance — " + e.getMessage());
        } catch (PaymentGatewayTimeoutException e) {
            System.out.println("Payment failed: Gateway timeout — " + e.getMessage());
        }
	}
}

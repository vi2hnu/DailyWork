package payment;
import user.User;

public interface ProcessPayment {
	public void makePayment(User fromUser,User toUser,double amount);
}

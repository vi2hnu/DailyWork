package transaction;
import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;
import exceptions.PaymentGatewayTimeoutException;
import user.User;

public class TransactionImplementation implements TransactionInterface {
	public boolean checkBeneficiary(User fromUser, User toUser) {
		if (fromUser == null || toUser == null) {
			return false;
		}

		for (User beneficiary : fromUser.getBeneficiaries()) {
			if (toUser.getAccountNumber() == beneficiary.getAccountNumber()) {
				return true;
			}
		}

		return false;
	}
	
	boolean checkTransactionPossible(User fromUser,double amount) {
		return fromUser.getBalance()<amount;
	}

	boolean checkAmount(double amount) {
		return amount<=0;
	}	
	
	@Override
	public void transaction(User fromUser, User toUser, double amount)
            throws InvalidAmountException, InsufficientBalanceException, PaymentGatewayTimeoutException {

        if (checkAmount(amount)) {
            throw new InvalidAmountException("Amount must be greater than 0");
        }

        if (!checkBeneficiary(fromUser, toUser)) {
            throw new PaymentGatewayTimeoutException("Beneficiary not found or network timeout during validation");
        }

        if (checkTransactionPossible(fromUser, amount)) {
            throw new InsufficientBalanceException("Insufficient balance for this transaction");
        }
		
		fromUser.reduceAmount(amount);
		toUser.addAmount(amount);
		System.out.println("Payment Successfull");
	}
}

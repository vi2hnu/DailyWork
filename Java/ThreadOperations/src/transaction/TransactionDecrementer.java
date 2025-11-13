package transaction;
import account.Account;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionDecrementer extends Thread{
	private final Account user;
	private ReentrantLock lock;
	private double amount;
	public TransactionDecrementer(Account user,ReentrantLock lock, double amount) {
		this.user = user;
		this.lock = lock;
		this.amount = amount;
	}
	
	public double decrement() {
		return user.decrement(amount);
	}
	
	public void run() {
//		lock.lock();
//		try {
			double balance = decrement();
			System.out.print("Account balance incremented, total balance = ");	
			System.out.println(balance);

//		}
//		catch(Exception e) {
//			System.out.print(e);
//		}
//		finally {
//			lock.unlock();
//		}
	}
}

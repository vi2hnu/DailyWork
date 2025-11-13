package comparator;

import java.util.Comparator;
import account.Account;

public class balanceComparator implements Comparator<Account> {
	@Override
	public int compare(Account a1,Account a2) {
		if(a1.getBalance() > a2.getBalance()) {
			return 1;
		}
		else if(a1.getBalance() < a2.getBalance()) {
			return -1;
		}
		return 0;
	}
}

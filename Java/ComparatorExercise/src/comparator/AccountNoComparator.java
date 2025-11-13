package comparator;

import java.util.Comparator;
import account.Account;

public class AccountNoComparator implements Comparator<Account> {
	@Override
	public int compare(Account a1,Account a2) {
		return a1.getAccountNo().compareTo(a2.getAccountNo());
	}
}

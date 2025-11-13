package Comparator;
import java.util.Comparator;

import record.AccountRecord;

public class AccountComparator implements Comparator<AccountRecord> {
	public int compare(AccountRecord a1,AccountRecord a2) {
		return a1.name().compareTo(a2.name());
	}
}

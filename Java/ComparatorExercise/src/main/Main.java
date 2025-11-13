package main;
import java.util.ArrayList;
import java.util.Collections;

import account.Account;
import comparator.AccountNoComparator;
import comparator.balanceComparator;
//accountholdername,accountno,transcode,country,ifsccode,balance
public class Main {
	public static void main(String[] args) {
		Account a1 = new Account("Ramesh","1234567890","sbi10","ind","SBI010",10000);
		Account a2 = new Account("Suresh","0987654321","sbi10","ind","SBI010",20000);
		Account a3 = new Account("Joseph","1234509876","sbi10","ind","SBI010",50000);
		Account a4 = new Account("Joestar","5432167890","sbi10","ind","SBI010",60000);
		Account a5 = new Account("Ralf","1627384950","sbi10","ind","SBI010",60600);
		
		ArrayList<Account> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		System.out.println("Sorting by acc no");
		Collections.sort(list,new AccountNoComparator());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getAccountNo());
		}
		System.out.println("Sorting by balance");
		Collections.sort(list,new balanceComparator());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getBalance());
		}
		
	}
}

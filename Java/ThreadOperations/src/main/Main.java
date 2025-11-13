package main;
import transaction.TransactionDecrementer;
import transaction.TransactionIncrementer;
import account.*;
import java.util.concurrent.locks.ReentrantLock;

interface FuncInterface{
    
    void abstractFun(int x);
    default void normalFun(){
        System.out.println("Hello");
        }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account c = new Account();
		ReentrantLock lock = new ReentrantLock();
		TransactionIncrementer i = new TransactionIncrementer(c,lock,1000);
		TransactionDecrementer d = new TransactionDecrementer(c,lock,500);
		
		i.start();
		d.start();
		
		FuncInterface fobj = (int x) -> System.out.println(2 * x);
        fobj.abstractFun(5);
		
	}

}

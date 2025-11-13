package Main;
import java.util.*;
public class Fabonanci {
	public static void fib(int x) {
		System.out.println(0);
		if(x==1) {
			return;
		}
		System.out.println(1);
		if(x==2) {
			return;
		}
		int f = 0,s = 1;
		for(int i=2;i<=x;i++) {
			int temp = f+s;
			System.out.println(temp);
			f = s;
			s = temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		fib(x);
		input.close();
	}

}

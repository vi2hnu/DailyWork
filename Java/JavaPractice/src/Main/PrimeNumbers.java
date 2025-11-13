package Main;
public class PrimeNumbers {
	public static int prime(int x) {
		for(int i=2;i<=Math.sqrt(x);i++) {
			if(x%i==0) {
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=500;i++) {
			if(prime(i)==1) {
				System.out.println(i);
			}
		}
	}

}

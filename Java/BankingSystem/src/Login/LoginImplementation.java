package Login;

import user.User;

public class LoginImplementation implements LoginInterface {
	public User login(String username,long accountNumber,String password) {
		System.out.println("Login Success");
		return new User(username,accountNumber,password);
	}
}

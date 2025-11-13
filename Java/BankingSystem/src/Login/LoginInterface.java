package Login;

import user.User;

public interface LoginInterface {
	public User login(String username,long accountNumber,String password);
}

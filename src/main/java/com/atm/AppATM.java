package main.java.com.atm;

import main.resources.user.User;
import main.resources.user.PrimaryAccount;
import main.resources.login.Login;

import java.util.ArrayList;
import java.util.List;

public class AppATM {

	private static List<User> users = new ArrayList<>();

	public static void main(String[] args) {
		PrimaryAccount account_01 = new PrimaryAccount("ASD0910", "Sebastian", "0603", 0.0);

		users.add(account_01);
		Login.authentication(users);
		account_01.displayUserMenu();

	}
}
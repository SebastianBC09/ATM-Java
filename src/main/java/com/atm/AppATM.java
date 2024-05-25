package main.java.com.atm;

import main.resources.user.PrimaryAccount;

public class AppATM {
	public static void main(String[] args) {
		PrimaryAccount account_01 = new PrimaryAccount("ASD0910", "Sebastian", "0603", 0.0);

		account_01.displayUserMenu();

	}
}
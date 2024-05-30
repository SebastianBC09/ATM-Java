package main.java.com.atm;

import main.resources.user.JointAccount;
import main.resources.user.User;
import main.resources.user.PrimaryAccount;
import main.resources.login.Login;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AppATM {

	private static List<User> users = new ArrayList<>();

	public static void main(String[] args) {
		JointAccount jaccount_01 = new JointAccount("HJK1011", "Jane", "0023", 0.0, true);
		PrimaryAccount account_01 = new PrimaryAccount("ASD0910", "Sebastian", "0603", 0.0, jaccount_01);

		users.add(account_01 );
		users.add(jaccount_01);

		while (true) {
			User authenticatedUser = Login.authentication(users);
			if (authenticatedUser != null) {
				authenticatedUser.displayUserMenu();
			} else {
				int response = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					System.exit(0); // Exit the program
				}
			}
		}

	}
}
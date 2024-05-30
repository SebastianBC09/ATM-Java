package main.resources.login;

import main.resources.user.JointAccount;
import main.resources.user.PrimaryAccount;
import main.resources.user.User;
import javax.swing.JOptionPane;
import java.util.List;

public class Login {
	//ATTRIBUTES
	private static int attemptCounter = 0;
	private static long blockStartTime = 0;

	//CONSTRUCTOR

	//METHODS

	public static User authentication(List<User> users) {
		while (true) {
			if (attemptCounter >= 3) {
				long currentTime = System.currentTimeMillis();
				long timePassed = currentTime - blockStartTime;

				if (timePassed < 60000) {
					JOptionPane.showMessageDialog(null, "Too many failed attempts. Please wait for 60 seconds before trying again.", "Access Blocked", JOptionPane.ERROR_MESSAGE);
					try {
						Thread.sleep(60000 - timePassed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				attemptCounter = 0; // Reset counter after block period
			}

			String[] options = {"Login", "Exit"};
			int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Authentication",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (choice == 1) { // User chose "Exit"
				return null;
			}

			String userId = JOptionPane.showInputDialog(null, "Enter User ID:", "Login", JOptionPane.PLAIN_MESSAGE);
			String userPin = JOptionPane.showInputDialog(null, "Enter Password:", "Login", JOptionPane.PLAIN_MESSAGE);

			for (User user : users) {
				if (user.getUserId().equals(userId) && user.getPin().equals(userPin)) {
					JOptionPane.showMessageDialog(null, "Login successful!");
					attemptCounter = 0; // Reset counter on successful login
					return user;
				}
			}

			attemptCounter++;
			if (attemptCounter >= 3) {
				blockStartTime = System.currentTimeMillis();
				JOptionPane.showMessageDialog(null, "Too many failed attempts. Please wait for 60 seconds before trying again.", "Access Blocked", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid User ID or Password. Try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void performPostLoginActions(User authenticatedUser) {
		JOptionPane.showMessageDialog(null, "Primary Account User Logged In.");
		if (authenticatedUser instanceof PrimaryAccount) {
			((PrimaryAccount) authenticatedUser).displayUserMenu();
		} else if (authenticatedUser instanceof JointAccount) {
			JOptionPane.showMessageDialog(null, "Joint Account User Logged In.");
			((JointAccount) authenticatedUser).displayUserMenu();
		}
	}


}
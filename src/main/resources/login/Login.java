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
		while (attemptCounter < 3) {
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
				attemptCounter = 0;
				try {
					Thread.sleep(60000); // Block for 60 seconds
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid User ID or Password. Try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
			}
		}
		return null;
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
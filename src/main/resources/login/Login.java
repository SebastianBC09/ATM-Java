package main.resources.login;

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
		if (attemptCounter >= 3) {
			long currentTime = System.currentTimeMillis();
			if (currentTime - blockStartTime < 60000) { // 60 seconds block
				JOptionPane.showMessageDialog(null, "Too many failed attempts. Please wait for 60 seconds before trying again.", "Access Blocked", JOptionPane.ERROR_MESSAGE);
				return null;
			} else {
				// Reset counter after block period
				attemptCounter = 0;
			}
		}

		String userId = JOptionPane.showInputDialog(null, "Enter User ID:", "Login", JOptionPane.PLAIN_MESSAGE);
		String userPin = JOptionPane.showInputDialog(null, "Enter Password: ", "Login", JOptionPane.PLAIN_MESSAGE);

		for (User user : users) {
			if (user.getUserId().equals(userId) && user.getPin().equals(userPin) ) {
				JOptionPane.showMessageDialog(null, "Login successful!");
				return user;
			}
		}

		JOptionPane.showMessageDialog(null, "Invalid User ID or Password. Try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
		return null;

	}
}
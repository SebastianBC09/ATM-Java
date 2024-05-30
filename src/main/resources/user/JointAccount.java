//PACKAGE DECLARATION
package main.resources.user;

//IMPORTS
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class JointAccount extends User{


	public JointAccount(String userId, String name, String pin, double balance) {
		super(userId, name, pin, balance);
	}

	//SETTERS

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	//GETTERS

	public String getUserId() {
		return this.userId;
	}

	public String getName() {
		return this.name;
	}

	public String getPin() {
		return this.pin;
	}

	public double getBalance() {
		return this.balance;
	}



	@Override
	public void displayUserMenu() {
	}

	@Override
	public void showAccountBalance() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);

		double balance = this.balance; // Access the balance attribute directly
		String message = "Account Balance: $" + balance + "\nEnquiry Date and Time: " + formattedDateTime;

		JOptionPane.showMessageDialog(null, message, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void makeAWithdrawal() {
		String[] options = {"20", "50", "100", "200"};
		String choice = (String) JOptionPane.showInputDialog(null, "Choose withdrawal amount:", "Withdrawal",
			JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (choice != null) {
			double withdrawalAmount = Double.parseDouble(choice);
			if (this.balance >= withdrawalAmount) {
				this.balance -= withdrawalAmount;
				JOptionPane.showMessageDialog(null, "Withdrawal successful! New balance: $" + this.balance);
			} else {
				JOptionPane.showMessageDialog(null, "Insufficient funds for this withdrawal.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		displayUserMenu();
	}

	@Override
	public void makeADeposit() {
	}

	@Override
	public void changePin() {
		String currentPinInput = JOptionPane.showInputDialog(null, "Enter your current PIN:", "Change PIN", JOptionPane.PLAIN_MESSAGE);

		if (currentPinInput != null && currentPinInput.equals(this.pin)) {
			String newPin = JOptionPane.showInputDialog(null, "Enter your new PIN:", "Change PIN", JOptionPane.PLAIN_MESSAGE);
			if (newPin != null && !newPin.isEmpty()) {
				String confirmNewPin = JOptionPane.showInputDialog(null, "Confirm your new PIN:", "Change PIN", JOptionPane.PLAIN_MESSAGE);
				if (newPin.equals(confirmNewPin)) {
					this.pin = newPin;
					JOptionPane.showMessageDialog(null, "Your PIN has been successfully changed.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "New PIN and confirmation do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "New PIN cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Incorrect current PIN. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		displayUserMenu();
	}
}

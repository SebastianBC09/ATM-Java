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

	}

	@Override
	public void makeADeposit() {
	}

	@Override
	public void changePin() {
	}
}

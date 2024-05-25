//PACKAGE DECLARATION
package main.resources.user;

//IMPORTS
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class PrimaryAccount extends User{
	//ATTRIBUTES

	//CONSTRUCTOR
	public PrimaryAccount(String userId, String name, String pin, double balance) {
		super(userId, name, pin, balance);
	}

	//METHODS
	@Override
	public void displayUserMenu() {
		String menuOptions = """
			Primary User Menu:
			1. Check Balance
			2. Withdraw
			3. Deposit
			4. Transfer to Joint Account
			5. Change account pin
			6. Exit""";

		String menuChoice = JOptionPane.showInputDialog(null, menuOptions, "ATM User Menu", JOptionPane.PLAIN_MESSAGE);

		if (menuChoice != null) {
			switch (menuChoice) {
				case "1":
					showAccountBalance();
					break;
				case "2":
					makeAWithdrawal();
					break;
				case "3":
					makeADeposit();
					break;
				case "4":
					transferToJoint();
					break;
				case "5":
					changePin();
				case "6":
					System.exit(0); // Exit the program
				default:
					JOptionPane.showMessageDialog(null, "Invalid menuChoice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
					displayUserMenu(); // Display the menu again
			}
		}
	}

	@Override
	public void showAccountBalance() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);

		double balance = this.balance; // Access the balance attribute directly
		String message = "Account Balance: $" + balance + "\nEnquiry Date and Time: " + formattedDateTime;

		JOptionPane.showMessageDialog(null, message, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
		displayUserMenu();
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

	public void transferToJoint() {
	}

}

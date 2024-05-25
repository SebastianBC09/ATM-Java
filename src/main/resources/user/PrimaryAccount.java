package main.resources.user;

import javax.swing.JOptionPane;



public class PrimaryAccount extends User{


	public PrimaryAccount(String userId, String name, String pin, double balance) {
		super(userId, name, pin, balance);
	}

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

		String menuChoice = JOptionPane.showInputDialog(null, menuOptions, "ATM Menu", JOptionPane.PLAIN_MESSAGE);

		if (menuChoice != null) {
			switch (menuChoice) {
				case "1":
					showAccountBalance();
					break;
				case "2":
					makeAWithdrawal(double amount)
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
	}

	@Override
	public boolean makeAWithdrawal(double amount) {

	}

	@Override
	public void makeADeposit(double amount) {
	}

	@Override
	public void changePin(String newPin) {
	}

	public void transferToJoint() {
	}

}

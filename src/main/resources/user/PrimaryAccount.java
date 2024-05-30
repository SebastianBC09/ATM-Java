//PACKAGE DECLARATION
package main.resources.user;

//IMPORTS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;


public class PrimaryAccount extends User{
	//ATTRIBUTES
	private JointAccount jointAccount;

	//CONSTRUCTOR
	public PrimaryAccount(String userId, String name, String pin, double balance, JointAccount jointAccount) {
		super(userId, name, pin, balance);
		this.setJointAccount(jointAccount);
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

	public void setJointAccount(JointAccount jointAccount) {
		this.jointAccount = jointAccount;
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

	public JointAccount getJointAccount() {
		return this.jointAccount;
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
					transferToJoint(jointAccount);
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
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);

		if(returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			readFileAndProcess(selectedFile);
		}
	}

	private void readFileAndProcess(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// Process each line from the file (e.g., assuming it contains deposit amounts)
				System.out.println("Processing: " + line);
				double depositAmount = Double.parseDouble(line);
				this.setBalance(depositAmount);
			}
			JOptionPane.showMessageDialog(null, "File processed successfully!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "An error occurred while reading the file.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		displayUserMenu();
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

	public void transferToJoint(JointAccount jointAccount) {
		String transferAmountInput = JOptionPane.showInputDialog(null, "Enter the amount to transfer:", "Transfer to Joint Account", JOptionPane.PLAIN_MESSAGE);

		if (transferAmountInput != null && !transferAmountInput.isEmpty()) {
			try {
				double transferAmount = Double.parseDouble(transferAmountInput);

				if (this.balance >= transferAmount) {
					this.balance -= transferAmount;
					jointAccount.setBalance(jointAccount.getBalance() + transferAmount);
					JOptionPane.showMessageDialog(null, "Transfer successful! New balance: $" + this.balance);
				} else {
					JOptionPane.showMessageDialog(null, "Insufficient funds for this transfer.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid amount entered. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		displayUserMenu();
	}

}

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

	//CONSTRUCTOR
	public PrimaryAccount(String userId, String name, String pin, double balance) {
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

		displayUserMenu();
	}

	public void transferToJoint() {

		displayUserMenu();
	}

}

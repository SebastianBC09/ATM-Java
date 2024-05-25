package main.resources.user;

public abstract class User {
		protected String userId;
		protected String name;
		protected String pin;
		protected double balance;

	public User(String userId, String name, String pin, double balance) {
		this.userId = userId;
		this.name = name;
		this.pin = pin;
		this.balance = balance;
	}

	public abstract void displayUserMenu();

	public abstract void showAccountBalance();

	public abstract boolean makeAWithdrawal(double amount);

	public abstract void makeADeposit(double amount);

	public abstract void changePin(String newPin);
}

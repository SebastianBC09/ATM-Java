package main.resources.user;

public abstract class User {
	//ATTRIBUTES
		protected String userId;
		protected String name;
		protected String pin;
		protected double balance;

	//CONSTRUCTOR
	public User(String userId, String name, String pin, double balance) {
		this.userId = userId;
		this.name = name;
		this.pin = pin;
		this.balance = balance;
	}

	//METHODS
	public abstract void displayUserMenu();

	public abstract void showAccountBalance();

	public abstract void makeAWithdrawal();

	public abstract void makeADeposit();

	public abstract void changePin();
}

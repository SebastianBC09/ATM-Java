package main.resources.user;

public class JointAccount extends User{


	public JointAccount(String userId, String name, String pin, double balance) {
		super(userId, name, pin, balance);
	}

	@Override
	public void displayUserMenu() {
	}

	@Override
	public void makeAWithdrawal(double amount) {

	}

	@Override
	public void makeADeposit(double amount) {

	}

	@Override
	public void changePin(String newPin) {

	}

}

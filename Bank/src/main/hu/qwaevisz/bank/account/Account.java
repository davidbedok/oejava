package hu.qwaevisz.bank.account;

public abstract class Account {

	private final String accountNumber;
	private final double value;

	public Account(final String accountNumber, final double value) {
		this.accountNumber = accountNumber;
		this.value = value;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public double getValue() {
		return this.value;
	}

}

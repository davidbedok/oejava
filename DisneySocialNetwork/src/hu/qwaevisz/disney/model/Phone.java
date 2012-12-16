package hu.qwaevisz.disney.model;

public class Phone {

	private final String number;
	private final PhoneType type;

	public Phone(String number, PhoneType type) {
		this.number = number;
		this.type = type;
	}

	public String getNumber() {
		return this.number;
	}

	public PhoneType getType() {
		return this.type;
	}

}

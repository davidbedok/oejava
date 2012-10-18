package hu.qwaevisz.oointro;

import java.util.Calendar;

public class Person {

	private static final double CM2INCH = 0.393700787;

	private static int peopleCounter = 0;

	private final String birthName;
	private final int birthYear;

	private String nickName;
	private int height;
	private int weight;
	private double heightInInches;

	private Hair hair;

	public Person(String birthName, int birthYear, HairType typeOfHair) {
		this.birthName = birthName;
		this.birthYear = birthYear;
		Person.peopleCounter++;
		hair = new Hair(typeOfHair);
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height > 0) {
			this.height = height;
			this.heightInInches = height * Person.CM2INCH;
		}
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0) {
			this.weight = weight;
		}
	}

	public double getHeightInInches() {
		return this.heightInInches;
	}

	public String getBirthName() {
		return birthName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public static int getPeopleCounter() {
		return Person.peopleCounter;
	}

	public int lengthOfNick() {
		int length = 0;
		if (this.nickName != null) {
			length = this.nickName.length();
		}
		return length;
	}

	public int age() {
		Calendar sysdate = Calendar.getInstance();
		int currentYear = sysdate.get(Calendar.YEAR);
		return currentYear - this.getBirthYear();
	}

	public Hair getHair() {
		return hair;
	}

}

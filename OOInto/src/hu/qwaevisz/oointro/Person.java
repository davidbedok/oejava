package hu.qwaevisz.oointro;

public class Person {

	private static final double CM2INCH = 0.393700787;

	private final String birthName;
	private final int birthYear;

	private String nickName;
	private int height;
	private int weight;
	private double heightInInches;

	public Person(String birthName, int birthYear) {
		this.birthName = birthName;
		this.birthYear = birthYear;
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

}

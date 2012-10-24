package hu.qwaevisz.theorem;

public class ParitySeparation {

	private final int[]	evenNumbers;
	private final int[]	oddNumbers;
	private int			evenIndex;
	private int			oddIndex;

	public ParitySeparation(int numberOfEvenNumbers, int numberOfAllNumbers) {
		this.evenNumbers = new int[numberOfEvenNumbers];
		this.oddNumbers = new int[numberOfAllNumbers - numberOfEvenNumbers];
		this.evenIndex = 0;
		this.oddIndex = 0;
	}

	private void addEvenNumber(int evenNumber) {
		this.evenNumbers[this.evenIndex++] = evenNumber;
	}

	private void addOddNumber(int oddNumber) {
		this.oddNumbers[this.oddIndex++] = oddNumber;
	}

	public void addNumber(int number) {
		if (number % 2 == 0) {
			this.addEvenNumber(number);
		} else {
			this.addOddNumber(number);
		}
	}

	public int[] getEvenNumbers() {
		return this.evenNumbers;
	}

	public int[] getOddNumbers() {
		return this.oddNumbers;
	}

}

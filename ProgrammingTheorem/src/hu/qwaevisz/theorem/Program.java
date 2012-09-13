package hu.qwaevisz.theorem;

import java.util.Arrays;

public class Program {

	private static void testSummation() {
		System.out.println("# summation");
		int[] data = { 30, 20, 40, 10 };
		System.out.println("input: " + Arrays.toString(data));
		System.out.println("output: " + Theorems.summation(data));
	}

	private static void testDecisionDivisible() {
		System.out.println("# decisionDivisible");
		int[] data = { 6, 4, 2, 8 };
		System.out.println("input: " + Arrays.toString(data));
		System.out.println("output: " + Theorems.decisionDivisible(data, 3));
	}

	private static void testSelectionDivisible() {
		System.out.println("# selectionDivisible");
		int[] data = { 2, 6, 4, 8 };
		System.out.println("input: " + Arrays.toString(data));
		System.out.println("output: " + Theorems.selectionDivisible(data, 3));
	}

	private static void testCountingDivisible() {
		System.out.println("# countingDivisible");
		int[] data = { 4, 1, 6, 12, 7, 5 };
		System.out.println("input: " + Arrays.toString(data));
		System.out.println("output: " + Theorems.countingDivisible(data, 3));
	}

	private static void testMaximumSelection() {
		System.out.println("# maximumSelection");
		int[] data = { 3, 7, 1, 13, 4, 8 };
		System.out.println("input: " + Arrays.toString(data));
		System.out.println("output: " + Theorems.maximumSelection(data));
	}

	private static void testAssortmentDivisible() {
		System.out.println("# assortmentDivisible");
		int[] data = { 2, 15, 7, 6, 9, 12, 11 };
		System.out.println("input: " + Arrays.toString(data));
		int[] divisibleData = Theorems.assortmentDivisible(data, 3);
		System.out.println("output: " + Arrays.toString(divisibleData));
	}

	public static void main(String[] args) {
		Program.testSummation();
		Program.testDecisionDivisible();
		Program.testSelectionDivisible();
		Program.testCountingDivisible();
		Program.testMaximumSelection();
		Program.testAssortmentDivisible();

		int[] testData = { 3, 2, 5, 7, 9, 2, 10 };
		System.out.println(Program.printArray(testData));
		int min = Theorems.minimumSelection(testData);
		System.out.println("minimumSelection: " + min);
		int[] mins = Theorems.minimumSelectionArray(testData);
		System.out.println("minimumSelectionArray: " + Program.printArray(mins));
		Theorems.minimumSelectionSort(testData);
		// System.out.println("Sorted: " + Test.printArray(testData));
		System.out.println("Sorted: " + Arrays.toString(testData));
	}

	public static String printArray(int[] data) {
		String ret = "";
		for (int i = 0; i < data.length; i++) {
			ret += data[i] + " ";
		}
		return ret;
	}

}

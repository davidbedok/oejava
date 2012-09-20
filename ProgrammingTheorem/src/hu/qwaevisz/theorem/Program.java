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

	private static void testSeparateParity() {
		System.out.println("# separateParity");
		int[] data = { 6, 1, 5, 2, 4, 9, 7, 3, 8 };
		System.out.println("input: " + Arrays.toString(data));
		int[][] separateNumbers = Theorems.separateParity(data);
		System.out.println("even numbers: " + Arrays.toString(separateNumbers[0]));
		System.out.println("odd numbers: " + Arrays.toString(separateNumbers[1]));
	}

	private static void testUnion() {
		System.out.println("# union");
		int[] dataA = { 2, 5, 3, 12 };
		int[] dataB = { 8, 1, 2, 9, 3 };
		System.out.println("dataA: " + Arrays.toString(dataA));
		System.out.println("dataB: " + Arrays.toString(dataB));
		int[] union = Theorems.union(dataA, dataB);
		System.out.println("union: " + Arrays.toString(union));
	}

	private static void testIntersect() {
		System.out.println("# intersect");
		int[] dataA = { 2, 5, 3, 12 };
		int[] dataB = { 8, 1, 2, 9, 3 };
		System.out.println("dataA: " + Arrays.toString(dataA));
		System.out.println("dataB: " + Arrays.toString(dataB));
		int[] union = Theorems.intersect(dataA, dataB);
		System.out.println("intersect: " + Arrays.toString(union));
	}

	private static void testRunUpSortedSet() {
		System.out.println("# runUpSortedSet");
		int[] dataA = { 2, 3, 5, 12 };
		int[] dataB = { 1, 2, 3, 8, 9 };
		System.out.println("dataA: " + Arrays.toString(dataA));
		System.out.println("dataB: " + Arrays.toString(dataB));
		int[] union = Theorems.runUpSortedSet(dataA, dataB);
		System.out.println("runUpSortedSet: " + Arrays.toString(union));
	}

	private static void testSimpleSwapSort() {
		System.out.println("# simpleSwapSort");
		int[] data = { 10, 3, 8, 4, 5, 2 };
		System.out.println("data: " + Arrays.toString(data));
		Theorems.simpleSwapSort(data);
		System.out.println("simpleSwapSort: " + Arrays.toString(data));
	}

	private static void testMinimumSelectionSort() {
		System.out.println("# minimumSelectionSort");
		int[] data = { 10, 3, 8, 4, 5, 2 };
		System.out.println("data: " + Arrays.toString(data));
		Theorems.minimumSelectionSort(data);
		System.out.println("minimumSelectionSort: " + Arrays.toString(data));
	}

	private static void testLinearSearch() {
		System.out.println("# linearSearch");
		int[] data = { 10, 3, 8, 4, 5, 2 };
		System.out.println("data: " + Arrays.toString(data));
		int index = Theorems.linearSearch(data, 8);
		System.out.println("index: " + index);
	}

	private static void testLinearSearchInSortedArray() {
		System.out.println("# linearSearchInSortedArray");
		int[] data = { 2, 3, 4, 5, 8, 10 };
		System.out.println("data: " + Arrays.toString(data));
		int index = Theorems.linearSearchInSortedArray(data, 8);
		System.out.println("index: " + index);
	}

	private static void testBinarySearch() {
		System.out.println("# binarySearch");
		int[] data = { 2, 3, 4, 5, 8, 10 };
		System.out.println("data: " + Arrays.toString(data));
		int index = Theorems.binarySearch(data, 8);
		System.out.println("index: " + index);
	}

	public static void main(String[] args) {
		Program.testSummation();
		Program.testDecisionDivisible();
		Program.testSelectionDivisible();
		Program.testCountingDivisible();
		Program.testMaximumSelection();
		Program.testAssortmentDivisible();
		Program.testSeparateParity();
		Program.testUnion();
		Program.testIntersect();
		Program.testRunUpSortedSet();
		Program.testSimpleSwapSort();
		Program.testMinimumSelectionSort();
		Program.testLinearSearch();
		Program.testLinearSearchInSortedArray();
		Program.testBinarySearch();

		// Program.testPassingParameters();
	}

	public static String printArray(int[] data) {
		String ret = "";
		for (int i = 0; i < data.length; i++) {
			ret += data[i] + " ";
		}
		return ret;
	}

	private static void testPassingParameters() {
		int a = PassingParameters.passingPrimitiveByValue(10);
		System.out.println(a); // 11

		int param = 25;
		int b = PassingParameters.passingPrimitiveByValue(param);
		System.out.println(param); // 25
		System.out.println(b); // 26

		int c = 7;
		c = PassingParameters.passingPrimitiveByValue(c);
		System.out.println(c); // 8

		//

		int[] input = { 10, 20, 30 };
		int[] output = PassingParameters.passingPrimitiveArrayByValue(input);
		System.out.println("input: " + Arrays.toString(input)); // [11, 21, 31] (!!)
		System.out.println("output: " + Arrays.toString(output)); // [11, 21, 31]

		Dummy outputDummy = PassingParameters.passingObjectByValue(new Dummy(10));
		System.out.println(outputDummy); // 11

		Dummy inputDummy2 = new Dummy(42);
		Dummy outputDummy2 = PassingParameters.passingObjectByValue(inputDummy2);
		System.out.println(inputDummy2); // 43 (!!)
		System.out.println(outputDummy2); // 43

		//

		int[] input3 = { 10, 20, 30 };
		int[] output3 = PassingParameters.passingPrimitiveArrayAndRenew(input3);
		System.out.println("input: " + Arrays.toString(input3)); // [10, 20, 30] (!!)
		System.out.println("output: " + Arrays.toString(output3)); // [1, 2, 3, 4]
	}

}

package hu.qwaevisz.theorem;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] testData = { 3, 2, 5, 7, 9, 2, 10 };
		System.out.println(Test.printArray(testData));
		int min = Theorems.minimumSelection(testData);
		System.out.println("minimumSelection: " + min);
		int[] mins = Theorems.minimumSelectionArray(testData);
		System.out.println("minimumSelectionArray: " + Test.printArray(mins));
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

package hu.qwaevisz.hps;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		int[] hill = Hill.getHill();
		System.out.println(Hill.printHill(hill));
		int[] indicesOfPeaks = Hill.getPeaks(hill);
		System.out.println("Indices of peaks: " + Arrays.toString(indicesOfPeaks));
		System.out.println("Values of the highest peaks: " + Arrays.toString(Hill.getTheHighestPeaks(hill, indicesOfPeaks)));

		int[] indicesOfTheSteepestSlope = Hill.getTheSteepestSlope(hill);
		System.out.println("The steepestSlope: " + Arrays.toString(indicesOfTheSteepestSlope));
	}

}

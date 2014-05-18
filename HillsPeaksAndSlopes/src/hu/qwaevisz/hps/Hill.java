package hu.qwaevisz.hps;

public class Hill {

	public static int[] getHill() {
		return new int[] { 0, 16, 20, 28, 25, 18, 20, 27, 43, 52, 50, 48, 58, 51, 34, 45, 49, 44, 34, 30, 36, 38, 33, 27, 14, 0 };
	}

	public static String printHill(int[] hill) {
		StringBuilder out = new StringBuilder(50);
		for (int i = 0; i < hill.length; i++) {
			out.append("[").append(StringUtils.padLeft(i, 2)).append("] ");
			out.append(StringUtils.repeat("#", hill[i])).append("\n");
		}
		return out.toString();
	}

	public static int[] getPeaks(int[] hill) {
		int[] indexOfPeaks = new int[hill.length];
		int index = 0;
		for (int i = 1; i < hill.length - 1; i++) {
			if (hill[i] > hill[i - 1] && hill[i] > hill[i + 1]) {
				indexOfPeaks[index++] = i;
			}
		}
		return ArrayUtils.cropping(indexOfPeaks, index);
	}

	public static int[] getTheHighestPeaks(int[] hill, int[] indexOfPeaks) {
		int[] highestPeaks = { -1, -1 };
		if (indexOfPeaks.length > 0) {
			int max1 = hill[indexOfPeaks[0]];
			int max2 = -1;
			if (indexOfPeaks.length > 1) {
				int second = hill[indexOfPeaks[1]];
				if (second > max1) {
					max2 = max1;
					max1 = second;
				} else {
					max2 = second;
				}
				for (int i = 2; i < indexOfPeaks.length; i++) {
					int current = hill[indexOfPeaks[i]];
					if (current > max1) {
						max2 = max1;
						max1 = current;
					} else if (current > max2) {
						max2 = current;
					}
				}
			}
			highestPeaks = new int[] { max1, max2 };
		}
		return highestPeaks;
	}

	public static int[] getTheSteepestSlope(int[] hill) {
		int[] result = { 0, -1 };
		int startIndex = 0;
		int currentHeight = hill[0];
		int endIndex = 0;
		double steepestSlope = 0;
		boolean directionUp = true;
		for (int i = 1; i < hill.length; i++) {
			if (directionUp && hill[i] > currentHeight) {
				endIndex = i;
				currentHeight = hill[i];
			} else if (!directionUp && hill[i] < currentHeight) {
				endIndex = i;
				currentHeight = hill[i];
			} else {
				double currentSlopeSteep = Hill.calculateSlopeSteep(hill, startIndex, endIndex, directionUp);
				if (currentSlopeSteep > steepestSlope) {
					steepestSlope = currentSlopeSteep;
					result = new int[] { startIndex, endIndex };
				}
				startIndex = i - 1;
				currentHeight = hill[i - 1];
				endIndex = i;
				directionUp = !directionUp;
			}
		}
		double currentSlopeSteep = Hill.calculateSlopeSteep(hill, startIndex, endIndex, directionUp);
		if (currentSlopeSteep > steepestSlope) {
			steepestSlope = currentSlopeSteep;
			result = new int[] { startIndex, endIndex };
		}
		return result;
	}

	private static double calculateSlopeSteep(int[] hill, int startIndex, int endIndex, boolean directionUp) {
		int height = Math.abs(hill[endIndex] - hill[startIndex]);
		int distance = Math.abs(endIndex - startIndex);
		double value = 0;
		if (distance > 0) {
			value = (double) height / distance;
			System.out.println("[calculate] " + startIndex + " - " + endIndex + " Height: " + height + " Distance: " + distance + " Value: " + value + " UP? "
					+ directionUp);
		}
		return value;
	}

}

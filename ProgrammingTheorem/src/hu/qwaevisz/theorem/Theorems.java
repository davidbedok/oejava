package hu.qwaevisz.theorem;

public class Theorems {

	public static int summation(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			result += data[i];
		}
		return result;
	}

	public static boolean decisionDivisible(int[] data, int divider) {
		int i = 0;
		while ((i < data.length) && (data[i] % divider != 0)) {
			i++;
		}
		return (i < data.length);
	}

	public static int selectionDivisible(int[] data, int divider) {
		int i = 0;
		while (data[i] % divider != 0) {
			i++;
		}
		return i;
	}

	public static int countingDivisible(int[] data, int divider) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] % divider == 0) {
				count++;
			}
		}
		return count;
	}

	public static int countingItem(int[] data, int item) {
		int count = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] == item) {
				++count;
			}
		}
		return count;
	}

	public static int maximumSelection(int[] data) {
		int maximum = -1;
		if (data.length > 0) {
			maximum = data[0];
			for (int i = 1; i < data.length; i++) {
				if (maximum < data[i]) {
					maximum = data[i];
				}
			}
		}
		return maximum;
	}

	public static int minimumSelection(int[] data) {
		int min = -1;
		if (data.length > 0) {
			min = data[0];
			for (int i = 1; i < data.length; i++) {
				if (min > data[i]) {
					min = data[i];
				}
			}
		}
		return min;
	}

	public static int[] assortmentDivisible(int[] data, int divider) {
		int numberOfDivisibleItem = Theorems.countingDivisible(data, divider);
		int[] divisibleData = new int[numberOfDivisibleItem];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] % divider == 0) {
				divisibleData[index++] = data[i];
			}
		}
		return divisibleData;
	}

	public static int[] assortmentMinimums(int[] data) {
		int[] mins = null;
		int min = Theorems.minimumSelection(data);
		if (min != -1) {
			int count = Theorems.countingItem(data, min);
			mins = new int[count];
			int index = 0;
			for (int i = 0; i < data.length; i++) {
				if (min == data[i]) {
					mins[index++] = i;
				}
			}
		}
		return mins;
	}

	public static int[][] separateParity(int[] data) {
		int[][] separateNumbers = new int[2][];
		int numberOfEvenNumbers = Theorems.countingDivisible(data, 2);
		separateNumbers[0] = new int[numberOfEvenNumbers];
		separateNumbers[1] = new int[data.length - numberOfEvenNumbers];
		int enIndex = 0;
		int onIndex = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] % 2 == 0) {
				separateNumbers[0][enIndex++] = data[i];
			} else {
				separateNumbers[1][onIndex++] = data[i];
			}
		}
		return separateNumbers;
	}

	public static int[] union(int[] dataA, int[] dataB) {
		int[] union = new int[dataA.length + dataB.length];
		int index = 0;
		for (int i = 0; i < dataA.length; i++) {
			union[index++] = dataA[i];
		}
		for (int i = 0; i < dataB.length; i++) {
			int j = 0;
			while ((j < dataA.length) && (dataB[i] != dataA[j])) {
				j++;
			}
			if (j == dataA.length) {
				union[index++] = dataB[i];
			}
		}
		return Theorems.cropping(union, index);
	}

	private static int[] cropping(int[] source, int length) {
		int[] data = new int[length];
		if (length <= source.length) {
			for (int i = 0; i < length; i++) {
				data[i] = source[i];
			}
		}
		return data;
	}

	public static int[] intersect(int[] dataA, int[] dataB) {
		int[] intersect = new int[Math.min(dataA.length, dataB.length)];
		int index = 0;
		for (int j = 0; j < dataA.length; j++) {
			int i = 0;
			while ((i < dataB.length) && (dataB[i] != dataA[j])) {
				i++;
			}
			if (i < dataB.length) {
				intersect[index++] = dataA[j];
			}
		}
		return Theorems.cropping(intersect, index);
	}

	public static int[] runUpSortedSet(int[] dataA, int[] dataB) {
		int[] merge = new int[dataA.length + dataB.length];
		int index = 0;
		int i = 0;
		int j = 0;
		while ((i < dataB.length) && (j < dataA.length)) {
			if (dataA[j] < dataB[i]) {
				merge[index++] = dataA[j];
				j++;
			} else if (dataA[j] > dataB[i]) {
				merge[index++] = dataB[i];
				i++;
			} else {
				merge[index++] = dataA[j];
				j++;
				i++;
			}
		}
		while (i < dataB.length) {
			merge[index++] = dataB[i];
			i++;
		}
		while (j < dataA.length) {
			merge[index++] = dataA[j];
			j++;
		}
		return Theorems.cropping(merge, index);
	}

	public static void simpleSwapSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					Theorems.swap(data, i, j);
				}
			}
		}
	}

	private static void swap(int[] data, int indexA, int indexB) {
		int tmp = data[indexA];
		data[indexA] = data[indexB];
		data[indexB] = tmp;
	}

	public static void minimumSelectionSort(int[] data) {
		if (data.length > 0) {
			int minPos;
			for (int i = 0; i < data.length - 1; i++) {
				minPos = i;
				for (int j = i; j < data.length; j++) {
					if (data[minPos] > data[j]) {
						minPos = j;
					}
				}
				Theorems.swap(data, i, minPos);
			}
		}
	}

	public static int linearSearch(int[] data, int element) {
		int index = -1;
		int i = 0;
		while ((i < data.length) && (data[i] != element)) {
			i++;
		}
		if (i < data.length) {
			index = i;
		}
		return index;
	}

	public static int linearSearchInSortedArray(int[] data, int element) {
		int index = -1;
		int i = 0;
		while ((i < data.length) && (data[i] < element)) {
			i++;
		}
		if ((i < data.length) && (data[i] == element)) {
			index = i;
		}
		return index;
	}

	public static int binarySearch(int[] data, int element) {
		int lower = 0;
		int upper = data.length - 1;
		int index = -1;
		while ((index == -1) && (lower <= upper)) {
			int i = (lower + upper) / 2;
			if (data[i] == element) {
				index = i;
			} else if (data[i] < element) {
				lower = i + 1;
			} else {
				upper = i - 1;
			}
		}
		return index;
	}

}

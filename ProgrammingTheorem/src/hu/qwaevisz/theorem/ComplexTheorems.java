package hu.qwaevisz.theorem;

public class ComplexTheorems {

	public static int[] assortmentMinimums(int[] data) {
		int[] mins = null;
		int min = Theorems.minimumSelection(data);
		if (min != -1) {
			mins = Theorems.assortmentNumber(data, min);
		}
		return mins;
	}

	public static int[] assortmentMinimumsAlter(int[] data) {
		int[] mins = null;
		int[] minAndCount = ComplexTheorems.minimumSelectionAndCounting(data);
		if (minAndCount[0] != -1) {
			mins = new int[minAndCount[1]];
			int index = 0;
			int i = 0;
			while (index < mins.length) {
				if (minAndCount[0] == data[i]) {
					mins[index++] = i;
				}
				i++;
			}
		}
		return mins;
	}

	private static int[] minimumSelectionAndCounting(int[] data) {
		int[] result = new int[2];
		int min = -1;
		int count = 0;
		if (data.length > 0) {
			min = data[0];
			count = 1;
			for (int i = 1; i < data.length; i++) {
				if (min > data[i]) {
					min = data[i];
					count = 1;
				} else if (min == data[i]) {
					count++;
				}
			}
		}
		result[0] = min;
		result[1] = count;
		return result;
	}

	public static int[] assortmentMinimumsAlterOO(int[] data) {
		int[] mins = null;
		MinimumData minData = ComplexTheorems.minimumSelectionAndCountingOO(data);
		if (minData.getMinimum() != -1) {
			mins = new int[minData.getCount()];
			int index = 0;
			int i = 0;
			while (index < mins.length) {
				if (minData.getMinimum() == data[i]) {
					mins[index++] = i;
				}
				i++;
			}
		}
		return mins;
	}

	private static MinimumData minimumSelectionAndCountingOO(int[] data) {
		int min = -1;
		int count = 0;
		if (data.length > 0) {
			min = data[0];
			count = 1;
			for (int i = 1; i < data.length; i++) {
				if (min > data[i]) {
					min = data[i];
					count = 1;
				} else if (min == data[i]) {
					count++;
				}
			}
		}
		return new MinimumData(min, count);
	}

}

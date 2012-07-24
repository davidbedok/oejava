package hu.qwaevisz.theorem;

public class Theorems {

	public static int countItem(int[] data, int item) {
		int count = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] == item) {
				++count;
			}
		}
		return count;
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

	public static int[] minimumSelectionArray(int[] data) {
		int[] mins = null;
		int min = Theorems.minimumSelection(data);
		if (min != -1) {
			int count = Theorems.countItem(data, min);
			mins = new int[count];
			int k = 0;
			for (int i = 0; i < data.length; i++) {
				if (min == data[i]) {
					mins[k++] = i;
				}
			}
		}
		return mins;
	}

	public static void minimumSelectionSort(int[] data) {
		if (data.length > 0) {
			int min;
			int minPos;
			for (int i = 0; i < data.length - 1; i++) {
				min = data[i];
				minPos = i;
				for (int j = i; j < data.length; j++) {
					if (min > data[j]) {
						min = data[j];
						minPos = j;
					}
				}
				Theorems.switchItems(data, i, minPos);
			}
		}
	}

	private static void switchItems(int[] data, int aPos, int bPos) {
		int tmp = data[aPos];
		data[aPos] = data[bPos];
		data[bPos] = tmp;
	}

}

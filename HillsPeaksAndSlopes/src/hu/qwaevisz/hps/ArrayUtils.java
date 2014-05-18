package hu.qwaevisz.hps;

public class ArrayUtils {

	public static int[] cropping(int[] source, int length) {
		int[] data = new int[length];
		if (length <= source.length) {
			for (int i = 0; i < length; i++) {
				data[i] = source[i];
			}
		}
		return data;
	}

}

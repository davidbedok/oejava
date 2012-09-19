package hu.qwaevisz.theorem;

public class PassingParameters {

	public static int passingPrimitiveByValue(int param) {
		param++;
		return param;
	}

	public static int[] passingPrimitiveArrayByValue(int[] data) {
		for (int i = 0; i < data.length; i++) {
			data[i]++;
		}
		return data;
	}

	public static int[] passingPrimitiveArrayAndRenew(int[] data) {
		data = new int[] { 1, 2, 3, 4 };
		return data;
	}

	public static Dummy passingObjectByValue(Dummy param) {
		param.setField(param.getField() + 1);
		return param;
	}

}

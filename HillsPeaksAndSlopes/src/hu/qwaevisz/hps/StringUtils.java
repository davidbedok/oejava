package hu.qwaevisz.hps;

public class StringUtils {

	public static String padLeft(int number, int n) {
		return String.format("%" + n + "d", number);
	}

	public static String repeat(String value, int number) {
		return new String(new char[number]).replace("\0", value);
	}

}

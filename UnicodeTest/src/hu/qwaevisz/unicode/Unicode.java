package hu.qwaevisz.unicode;

public class Unicode {

	private final String value;

	public Unicode() {
		value = "Hello World\u0022;
		String tmp = "Hello World\u0022\u003B
		int i = 42\u003B
		System.out.println(i);
	}

	public static void main(String... args) {
		System.out.println(new Unicode());
	}

	@Override
	public String toString() {
		return value;
	}

}

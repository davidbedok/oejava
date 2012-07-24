package hu.qwaevisz.param;

public class MultiParam {

	private String multiParamArray(Object[] args) {
		String ret = "";
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				ret += args[i].toString() + " ";
			}
		}
		return ret;
	}

	private String multiParam(Object... args) {
		return multiParamArray(args);
	}

	public static void main(String[] args) {
		MultiParam mp = new MultiParam();

		String ret = mp.multiParamArray(new Object[] { 42, "alma", 3.1415, 'k' });
		System.out.println(ret);

		ret = mp.multiParam(42, "alma", 3.1415, 'k');
		System.out.println(ret);

	}

}

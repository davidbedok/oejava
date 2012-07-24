package hu.qwaevisz.init;

public class Program {

	/* PELDANY elemek */

	public Program() {
		System.out.println("Program constructor.");
	}

	private int testField;

	public int getTestField() {
		return testField;
	}

	public void setTestField(int testField) {
		this.testField = testField;
	}

	// init blokk (peldany valtozok es metodusok hivasa kozvetlenul konstruktor elott)
	{
		System.out.println("Instance init block start..1");
		this.testField = 100;
	}

	{
		System.out.println("Instance init block start..2");
		this.setTestField(42);
	}

	// init blokk alternativaja egy final init method. A final azert fontos, mert non-final hivasok problemat okozhatnak init soran.
	// constructor elott futnak le --> egy eszkoz arra, hogy tobb konstruktornak kozos kodja legyen
	private int testField2 = initializeTestField2();

	protected final int initializeTestField2() {
		System.out.println("Final init method start..");
		return 420;
	}

	/* STATIKUS elemek */

	private static int staticTestField;

	// statikus init blokk
	// az init blokkok a forrasban levo sorrendjuk szerint futnak egymas utan! (tobb is lehet)
	static {
		System.out.println("Static init block start..1");
		Program.staticTestField = 4200;
	}

	static {
		System.out.println("Static init block start..2");
	}

	// statikus init blokk helyett egy alternativa
	private static int staticTestField2 = initializeStaticTestField2();

	private static int initializeStaticTestField2() {
		return 42000;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(200);
		sb.append("this.testField = " + this.testField + "\n");
		sb.append("this.testField2 = " + this.testField2 + "\n");
		sb.append("Program.staticTestField = " + Program.staticTestField + "\n");
		sb.append("Program.staticTestField2 = " + Program.staticTestField2 + "\n");
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("main() start");
		Program p = new Program();
		System.out.println(p);
	}
}

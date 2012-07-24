package hu.qwaevisz.innerclass.anonymous;

public class DemoClass {

	protected int opA;
	protected int opB;

	public DemoInterface demoInterface;

	public DemoClass(int opA, int opB) {
		System.out.println("DemoClass constructor (opA:" + opA + ",opB:" + opB + ").");
		this.opA = opA;
		this.opB = opB;
	}

	public int sum() {
		return this.opA + this.opB;
	}

	@Override
	public String toString() {
		return this.opA + " + " + this.opB;
	}

}

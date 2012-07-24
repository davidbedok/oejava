package hu.qwaevisz.init.vscsharp;

public class Child extends Parent {

	protected String dummy;
	protected boolean flag;

	public Child(int foo, char bar) {
		super(foo, bar);
		this.init();
	}

	protected void init() {
		// nothing to do
	}

	public Child(int foo, char bar, String dummy, boolean flag) {
		this(foo, bar);
		this.dummy = dummy;
		this.flag = flag;
	}

	public String getDummy() {
		return this.dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

	public boolean isFlag() {
		return this.flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return this.dummy + " " + this.flag + " " + super.toString();
	}

}

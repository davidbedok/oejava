package hu.qwaevisz.singleton;

public class SingletonClass {

	private static SingletonClass instance = null;

	private int fieldA;

	// protected or private!
	protected SingletonClass() {
		System.out.println("SingletonClass constructor invoked.");
	}

	public int getFieldA() {
		return fieldA;
	}

	public void setFieldA(int fieldA) {
		this.fieldA = fieldA;
	}

	public static SingletonClass getInstance() {
		if (SingletonClass.instance == null) {
			SingletonClass.instance = new SingletonClass();
		}
		return SingletonClass.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}

package hu.qwaevisz.singleton;

public class SingletonThreadSafeClass {

	private SingletonThreadSafeClass() {
		System.out.println("SingletonThreadSafeClass constructor invoked.");
	}

	private int fieldA;

	public int getFieldA() {
		return fieldA;
	}

	public void setFieldA(int fieldA) {
		this.fieldA = fieldA;
	}

	/**
	 * Bill Pugh (University of Maryland Computer Science researcher) megoldasa Kihasznalja, hogy az Inner Static Class inicializalasa csak a getInstance() hivasakor tortenik meg.
	 */
	private static class SingletonHolder {
		private static final SingletonThreadSafeClass instance = new SingletonThreadSafeClass();
	}

	public static SingletonThreadSafeClass getInstance() {
		return SingletonHolder.instance;
	}

}

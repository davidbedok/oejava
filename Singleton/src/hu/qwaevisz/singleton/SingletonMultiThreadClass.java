package hu.qwaevisz.singleton;

public class SingletonMultiThreadClass {

	private static SingletonMultiThreadClass instance = null;

	private int fieldA;

	// protected or private!
	protected SingletonMultiThreadClass() {
		System.out.println("SingletonClass constructor invoked.");
	}

	public int getFieldA() {
		return fieldA;
	}

	public void setFieldA(int fieldA) {
		this.fieldA = fieldA;
	}

	// not good design pattern
	// egyszerre hivja meg a getInstance()-t 100 szal
	public static SingletonMultiThreadClass getInstance() {
		if (SingletonMultiThreadClass.instance == null) {
			// mindegyik eseten az instance null lesz, igy mindegyik letrehoz
			// 1-1 fuggetlen peldanyt
			SingletonMultiThreadClass.instance = new SingletonMultiThreadClass();
		}
		return SingletonMultiThreadClass.instance;
	}

	// good design pattern
	// egyszerre hivja meg a getInstance()-t 100 szal
	public static SingletonMultiThreadClass getInstancegetInstanceInMultiThread() {
		if (SingletonMultiThreadClass.instance == null) {
			// mindegyik eseten az instance null lesz, igy mindegyik futasa az
			// if-en belul folytatodik
			// mivel a synchronized blokk csak egyetlen szalban futhat
			// egyidoben, ezert az elso szal belefut, a tobbi varakozik
			synchronized (SingletonMultiThreadClass.class) {
				if (SingletonMultiThreadClass.instance == null) {
					// az elso szal eseten meg mindig null az instance, igy
					// lefut a peldanyositas
					SingletonMultiThreadClass.instance = new SingletonMultiThreadClass();
				}
				// vegeter az elso szal synchronized blokkja, elindulhat a tobbi
				// 99 szal
			}
			// mivel a a peldany mar letrjott, a 2. szal eseten az ujabb null
			// vizsgalat mar hamis lesz, ezert nem fut le a peldanyositas
			// megegyszer
		}
		return SingletonMultiThreadClass.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}

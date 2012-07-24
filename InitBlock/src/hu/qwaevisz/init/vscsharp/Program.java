package hu.qwaevisz.init.vscsharp;

public class Program {

	private static void testInitAfterCtor() {
		Child childItem = new Child(42, 'A');
		childItem.setDummy("hello world");
		childItem.setFlag(true);
		System.out.println(childItem);

		// itt egy anonymous leszarmazott osztaly jon letre
		// vagyis a Child lesz az ososztaly, es ezert mukodik ez
		// nem osszekeverendo a C# kicsit hasonlo ctor utani inicializalos
		// szintaktikai cukorkajaval
		Parent parentItem = new Child(42, 'A') {

			@Override
			public void init() {
				this.dummy = "hello world";
				this.flag = true;
			}

		};
		// ((Child) parentItem).setDummy("hello world"); // not recommended
		System.out.println(parentItem);
	}

	private static void recommendedWay() {
		Child childItem = new Child(42, 'A', "hello world", true);
		System.out.println(childItem);

		Parent parentItem = new Child(42, 'A', "hello world", true);
		System.out.println(parentItem);
	}

	public static void main(String[] args) {
		Program.testInitAfterCtor();
		Program.recommendedWay();
	}

}

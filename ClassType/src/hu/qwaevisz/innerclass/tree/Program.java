package hu.qwaevisz.innerclass.tree;

public class Program {

	/*
	 * A valosagban Fagyongy peldany nem letezhet Fa nelkul, leven egy feleleskodo ketlaki gomb alaku cserje. Amikor viszont letezik mar egy fa peldany, akkor letrehozhatunk egy rajta eloskodo fagyongy peldanyt, mely tudni fog arrol, hogy milyen fan eloskodik.
	 */

	public static void main(String[] args) {
		System.out.println("MemberInnerClass Demo Application");

		// aspen = nyarfa
		// mistletoe = fagyongy
		Tree iTree = new Tree("aspen");
		iTree.addYear();
		iTree.addYear();
		System.out.println(iTree);

		Tree.Mistletoe iMistletoe = iTree.new Mistletoe("white");
		System.out.println(iMistletoe);
	}

}

package hu.qwaevisz.innerclass.tree;

// Top Level Outer class
public class Tree {

	private String treeTypeName;
	private int age;

	public Tree(String treeTypeName) {
		this.treeTypeName = treeTypeName;
		this.age = 0;
	}

	public void addYear() {
		this.age++;
	}

	@Override
	public String toString() {
		return "This is a " + this.age + " year(s) old " + this.treeTypeName + " tree.";
	}

	// Member Inner Class
	public class Mistletoe {

		private String color;

		public Mistletoe(String color) {
			this.color = color;
		}

		@Override
		public String toString() {
			// eleri az Outer class private mezoit is
			return "This is a " + this.color + " color mistletoe in a " + age + " year(s) old " + treeTypeName + " tree.";
		}

	}

}

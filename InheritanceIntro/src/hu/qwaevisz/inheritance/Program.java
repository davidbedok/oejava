package hu.qwaevisz.inheritance;

public class Program {

	private static void testPoint() {
		System.out.println("---[ Point ]---");
		Point p = new Point(3, 2);
		System.out.println(p);
		System.out.println("X: " + p.getX());
		System.out.println("Y: " + p.getY());
	}

	private static void testLine() {
		System.out.println("---[ Line ]---");
		Line l = new Line(0, 3, 4, 0);
		System.out.println(l);
		System.out.println("Distance: " + l.distance());
		System.out.println("X1: " + l.getX());
		System.out.println("Y1: " + l.getY());
		System.out.println("X2: " + l.getX2());
		System.out.println("Y2: " + l.getY2());
	}

	private static void testTriangle() {
		System.out.println("---[ Triangle ]---");
		Triangle t = new Triangle(0, 3, 4, 0, 0, 0);
		System.out.println(t);
		System.out.println("Valid: " + t.valid());
		System.out.println("District: " + t.district());
		System.out.println("X1: " + t.getX());
		System.out.println("Y1: " + t.getY());
		System.out.println("X2: " + t.getX2());
		System.out.println("Y2: " + t.getY2());
		System.out.println("X3: " + t.getX3());
		System.out.println("Y3: " + t.getY3());
	}

	private static void testLineAlter() {
		System.out.println("---[ LineAlter ]---");
		LineAlter l = new LineAlter(0, 3, 4, 0);
		System.out.println(l);
		System.out.println("Distance: " + l.distance());
	}

	public static void main(String[] args) {
		Program.testPoint();
		Program.testLine();
		Program.testTriangle();
		Program.testLineAlter();
	}

}

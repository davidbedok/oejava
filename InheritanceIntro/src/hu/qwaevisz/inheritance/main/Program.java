package hu.qwaevisz.inheritance.main;

import hu.qwaevisz.inheritance.basic.Line;
import hu.qwaevisz.inheritance.basic.Point;
import hu.qwaevisz.inheritance.basic.Triangle;
import hu.qwaevisz.inheritance.basic.alter.LineAlter;
import hu.qwaevisz.inheritance.shape.Circle;
import hu.qwaevisz.inheritance.shape.Rectangle;
import hu.qwaevisz.inheritance.shape.Shape;

public class Program {

	private static void testPoint() {
		System.out.println("---[ Point ]---");
		Point p = new Point(3, 2);
		System.out.println("Point: " + p);
		System.out.println("X: " + p.getX());
		System.out.println("Y: " + p.getY());
	}

	private static void testLine() {
		System.out.println("---[ Line ]---");
		Line line = new Line(3, 2, -1, 5);
		System.out.println("Line: " + line);
		System.out.println("Distance: " + line.distance());
		System.out.println("X1: " + line.getX());
		System.out.println("Y1: " + line.getY());
		System.out.println("X2: " + line.getX2());
		System.out.println("Y2: " + line.getY2());
	}

	private static void testTriangle() {
		System.out.println("---[ Triangle ]---");
		Triangle t = new Triangle(3, 2, -1, 5, -1, 2);
		System.out.println("Triangle: " + t);
		System.out.println("Sides: " + t.sideA() + ", " + t.sideB() + ", "
				+ t.sideC());
		System.out.println("Valid: " + t.valid());
		System.out.println("Circumference: " + t.circumference());
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

	private static void testCircle() {
		System.out.println("---[ Circle ]---");
		Circle circle = new Circle(5, 2, 2);
		System.out.println(circle);
		System.out.println("Diameter: " + circle.diameter());
		System.out.println("Circumference: " + circle.circumference());
		System.out.println("Area: " + circle.area());
	}

	private static void testRectangle() {
		System.out.println("---[ Rectangle ]---");
		Rectangle rectangle = new Rectangle(1, 4, 7, 2);
		System.out.println(rectangle);
		System.out.println("Side(s): " + rectangle.sideA() + ", "
				+ rectangle.sideB());
		System.out.println("Circumference: " + rectangle.circumference());
		System.out.println("Area: " + rectangle.area());
	}

	private static void testCircleAsShape() {
		System.out.println("---[ Circle as Shape ]---");
		Shape circle = new Circle(5, 2, 2);
		System.out.println(circle);
		// System.out.println("Diameter: " + shape.diameter());
		System.out.println("Circumference: " + circle.circumference());
		System.out.println("Area: " + circle.area());
	}

	private static void testRectangleAsShape() {
		System.out.println("---[ Rectangle as Shape ]---");
		Shape rectangle = new Rectangle(1, 4, 7, 2);
		System.out.println(rectangle);
		// System.out.println("Side(s): " + rectangle.sideA() + ", "
		// + rectangle.sideB());
		System.out.println("Circumference: " + rectangle.circumference());
		System.out.println("Area: " + rectangle.area());
	}

	public static void main(String[] args) {
		Program.testPoint();
		Program.testLine();
		Program.testTriangle();
		Program.testLineAlter();
		Program.testCircle();
		Program.testRectangle();
		Program.testCircleAsShape();
		Program.testRectangleAsShape();
	}

}

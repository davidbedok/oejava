package hu.qwaevisz.innerclass;

import hu.qwaevisz.innerclass.anonymous.DemoClass;
import hu.qwaevisz.innerclass.anonymous.DemoInterface;

import java.util.Vector;

public class Program {

	public static void testClassWithLocalInnerClass() {
		System.out.println("\n# testClassWithLocalInnerClass");
		OuterClass cwlic = new OuterClass(5);
		cwlic.testMethod();
	}

	public static void testClassWithMemberInnerClass() {
		System.out.println("\n# testClassWithMemberInnerClass");
		ClassWithMemberInnerClass cwmic = new ClassWithMemberInnerClass(5);
		cwmic.testMethod();

		System.out.println("\n Example 1: MemberInnerClass peldanyositasa Outer class peldany nelkul");
		System.out.println("ClassWithMemberInnerClass.MemberInnerClass mic = new ClassWithMemberInnerClass.MemberInnerClass(560);");
		System.out.println("NEM LEHETSEGES");

		System.out.println("\n Example 2: MemberInnerClass peldanyositasa Outer class peldannyal");
		System.out.println("ClassWithMemberInnerClass.MemberInnerClass mic = cwmic.MemberInnerClass(560);");
		ClassWithMemberInnerClass.MemberInnerClass mic0 = cwmic.new MemberInnerClass(560);
		mic0.setInnerField(570);
		System.out.println(mic0);
		System.out.println("FA - FAGYONGY pelda");

		System.out.println("\n Example 3: MemberInnerClass peldanyositasa Outer class peldannyal egy lepesben");
		// egy lepesben: bar igy nincs referenciank az outer peldanyra, de mivel a member class eleri az outer field-jeit, ezert egyertelmu, hogy leteznie kell..
		System.out.println("ClassWithMemberInnerClass.MemberInnerClass mic = new ClassWithMemberInnerClass(500).new MemberInnerClass(560);");
		ClassWithMemberInnerClass.MemberInnerClass mic = new ClassWithMemberInnerClass(500).new MemberInnerClass(560);
		mic.setInnerField(570);
		System.out.println(mic);

		System.out.println("\n Example 4: StaticMemberInnerClass peldanyositasa");
		System.out.println("ClassWithMemberInnerClass.StaticMemberInnerClass smic = new ClassWithMemberInnerClass.StaticMemberInnerClass(2000);");
		ClassWithMemberInnerClass.StaticMemberInnerClass smic = new ClassWithMemberInnerClass.StaticMemberInnerClass(2000);
		// itt mar szamit a lathatosag
		smic.setInnerField(2000);
		System.out.println(smic);
		System.out.println("LEHETSEGES outer peldany nelkuli letezes");
	}

	public static void testVectorAnonymousSubClass() {
		System.out.println("\n# testVectorAnonymousSubClass");
		Vector v = new Vector();
		v.add("alma");
		v.add("korte");
		System.out.println(v);

		// leszarmazott anonymous osztalyt keszitunk!
		Vector v2 = new Vector(2) {
			{ // init blokk..
				add("alma");
				add("korte");
				elementCount = 1; // protected field-ekhez hozzaferunk! (lehetseges security hole..)
			}
		};

		System.out.println(v2);
	}

	public static void testAnonymousChildClass() {
		System.out.println("\n# testAnonymousClass");

		System.out.println("\n Example 1: create an instance..");
		DemoClass dc = new DemoClass(10, 20);
		System.out.println(dc + " = " + dc.sum());

		System.out.println("\n Example 2: create an anonymous subclass, than create an instance..");
		final int i = 40;
		// a DemoClass 'statikus' tipusa ertekul kaphat barmely leszarmazott osztalyt mint dinamikus tipus (Generalization)
		DemoClass dc2 = new DemoClass(10, 20) {

			public int sub() {
				return this.opA - this.opB;
			}

			public int field = 20;

			// public static int staticField = 10; // no static fields..

			@Override
			public int sum() {
				return this.sub();
			}

			@Override
			public String toString() {
				System.out.println("Reach subclass field (field:" + field + ")");
				System.out.println("Reach local final variables (i:" + i + ")");
				return this.opA + " - " + this.opB;
			}
		};

		System.out.println(dc2 + " = " + dc2.sum());

		System.out.println("\n Example 3: create an anonymous class as demoInterface value..");
		DemoClass dc3 = new DemoClass(10, 20);
		dc3.demoInterface = new DemoInterface() {

			@Override
			public int method2() {
				return i;
			}

			@Override
			public void method1() {
				System.out.println("method1() --> method2() --> " + this.method2());
			}

		};
		System.out.println(dc3 + " = " + dc3.sum());
		dc3.demoInterface.method1();
	}

	public static void main(String[] args) {
		Program.testClassWithLocalInnerClass();
		Program.testClassWithMemberInnerClass();
		Program.testVectorAnonymousSubClass();
		Program.testAnonymousChildClass();
	}
}

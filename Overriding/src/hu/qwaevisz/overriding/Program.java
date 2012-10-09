package hu.qwaevisz.overriding;

public class Program {

	public static void main(String[] args) {
		ChildEntity child = new ChildEntity();
		System.out.println("PublicFieldInBaseEntity: " + child.getPublicFieldInBaseEntity());
		System.out.println("PublicFieldInChildEntity: " + child.getPublicFieldInChildEntity());

		System.out.println("ProtectedFieldInBaseEntity: " + child.getProtectedFieldInBaseEntity());
		System.out.println("ProtectedFieldInChildEntity: " + child.getProtectedFieldInChildEntity());

		System.out.println("PrivateFieldInBaseEntity: " + child.getPrivateFieldInBaseEntity());
		System.out.println("PrivateFieldInChildEntity: " + child.getPrivateFieldInChildEntity());

		child.publicMethodInBaseEntity();
		child.protectedMethodInBaseEntity(); // protected can be visible in the same package !
		System.out.println("publicOverloadTest(42): " + child.publicOverrideTest(42));
		System.out.println("protectedOverrideTest(42): " + child.protectedOverrideTest(42));

		// child.overrideDummy(new DummyMiddle()); // ClassCaseException
		// child.overrideDummy(new DummyBase());
		child.overrideDummy(new DummyChild());
	}

}

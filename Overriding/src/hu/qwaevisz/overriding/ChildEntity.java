package hu.qwaevisz.overriding;

public class ChildEntity extends BaseEntity {

	public String publicFieldInBaseEntity; // hiding (can be different type and visibility [access modifiers])
	protected int protectedFieldInBaseEntity; // intended hiding
	private int privateFieldInBaseEntity;

	public String getPublicFieldInChildEntity() {
		return this.publicFieldInBaseEntity;
	}

	public void setPublicFieldInChildEntity(String publicFieldInBaseEntity) {
		this.publicFieldInBaseEntity = publicFieldInBaseEntity;
	}

	public int getProtectedFieldInChildEntity() {
		return this.protectedFieldInBaseEntity;
	}

	public void setProtectedFieldInChildEntity(int protectedFieldInBaseEntity) {
		this.protectedFieldInBaseEntity = protectedFieldInBaseEntity;
	}

	public int getPrivateFieldInChildEntity() {
		return this.privateFieldInBaseEntity;
	}

	@Override
	public void setPrivateFieldInBaseEntity(int privateFieldInBaseEntity) {
		this.privateFieldInBaseEntity = privateFieldInBaseEntity;
	}

	public ChildEntity() {
		this.publicFieldInBaseEntity = "20";
		this.protectedFieldInBaseEntity = 20;
		this.privateFieldInBaseEntity = 20;
		// super.publicFieldInBaseEntity = 15;
		// super.protectedFieldInBaseEntity = 15;
		// super.setPrivateFieldInBaseEntity(15);
	}

	@Override
	public void publicMethodInBaseEntity() // hiding
	{
		System.out.println("Inside child: publicMethodInBaseEntity");
		// super.publicMethodInBaseEntity();
	}

	@Override
	protected void protectedMethodInBaseEntity() // intended hiding
	{
		System.out.println("Inside child: protectedMethodInBaseEntity");
	}

	private void privateMethodInBaseEntity() {
		System.out.println("Inside child: privateMethodInBaseEntity");
	}

	@Override
	public int publicOverrideTest(int param) // Cannot reduce the visibility of the inherited method
	{
		return param * 2;
	}

	@Override
	public int protectedOverrideTest(int param) { // allow to increase the visibility ! (protected --> public)
		return param * 2;
	}

	private int privateOverrideTest(int param) {
		return param * 2;
	}

	@Override
	public DummyChild overrideDummy(DummyMiddle param) { // return type can be more special !!
		return (DummyChild) param;
	}

	// public DummyMiddle overrideDummy(DummyBase param) { // overloading!
	// return (DummyMiddle) param;
	// }
	//
	// public DummyMiddle overrideDummy(DummyChild param) { // overloading!
	// return param;
	// }

}

package hu.qwaevisz.overriding;

public class BaseEntity {

	public int publicFieldInBaseEntity;
	protected int protectedFieldInBaseEntity;
	private int privateFieldInBaseEntity;

	public int getPublicFieldInBaseEntity() {
		return this.publicFieldInBaseEntity;
	}

	public void setPublicFieldInBaseEntity(int publicFieldInBaseEntity) {
		this.publicFieldInBaseEntity = publicFieldInBaseEntity;
	}

	public int getProtectedFieldInBaseEntity() {
		return this.protectedFieldInBaseEntity;
	}

	public void setProtectedFieldInBaseEntity(int protectedFieldInBaseEntity) {
		this.protectedFieldInBaseEntity = protectedFieldInBaseEntity;
	}

	public int getPrivateFieldInBaseEntity() {
		return this.privateFieldInBaseEntity;
	}

	public void setPrivateFieldInBaseEntity(int privateFieldInBaseEntity) {
		this.privateFieldInBaseEntity = privateFieldInBaseEntity;
	}

	public BaseEntity() {
		this.publicFieldInBaseEntity = 10;
		this.protectedFieldInBaseEntity = 10;
		this.privateFieldInBaseEntity = 10;
	}

	public void publicMethodInBaseEntity() {
		System.out.println("publicMethodInBaseEntity");
	}

	protected void protectedMethodInBaseEntity() {
		System.out.println("protectedMethodInBaseEntity");
	}

	private void privateMethodInBaseEntity() {
		System.out.println("privateMethodInBaseEntity");
	}

	public int publicOverrideTest(int param) {
		return param * 2;
	}

	protected int protectedOverrideTest(int param) {
		return param * 2;
	}

	// private method cannot be override
	private int privateOverrideTest(int param) {
		return param * 2;
	}

	public DummyMiddle overrideDummy(DummyMiddle param) {
		return param;
	}

}

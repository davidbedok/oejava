package hu.qwaevisz.reflection;

public class Demo {

	private int privateField;
	protected String protectedField;
	public double publicField;
	
	public Demo(){
		System.out.println("Demo() instance created.");
	}
	
	public Demo( int privateField ){
		this.privateField = privateField;
		this.publicField = 3.1415;
	}
	
	public Demo( int privateField, String protectedField ){
		this.privateField = privateField;
		this.protectedField = protectedField;
		this.publicField = 3.1415;
	}
	
	public String toPrint(){
		return "toPrint() --> "+privateField + " " + protectedField+ " "+publicField;
	}

	public int getPrivateField() {
		return privateField;
	}

	public void setPrivateField(int privateField) {
		this.privateField = privateField;
	}

	public String getProtectedField() {
		return protectedField;
	}

	public void setProtectedField(String protectedField) {
		this.protectedField = protectedField;
	}
	
	private void privateMethod( String tmp ){
		System.out.println("This is a private method... Parameter: "+tmp);
	}
	
	public void publicMethod( String tmp ){
		System.out.println("This is a public method... Parameter: "+tmp);
	}	
	
	@Override
	public String toString() {		
		return "toString() --> "+this.toPrint();
	}
		
}

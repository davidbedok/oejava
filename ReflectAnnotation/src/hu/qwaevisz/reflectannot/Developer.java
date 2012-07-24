package hu.qwaevisz.reflectannot;

public enum Developer {

	SYSTEM,
	BEDOKD("bedokd","Bedok","David"),
	KOVACSJ("kovacsj","Kovacs","Janos");
	
	private String userName;
	private String familyName;
	private String firstName;	

	private Developer ( String userName, String familyName, String firstName ){
		this.userName = userName;
		this.familyName = familyName;
		this.firstName = firstName;
	}
	
	private Developer ( ){
		this.userName = "system";
		this.familyName = "system";
		this.firstName = "admin";
	}
	
	public String getUserName() {
		return userName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {		
		return this.familyName + " " + this.firstName + " ("+this.userName+")";
	}
		
}
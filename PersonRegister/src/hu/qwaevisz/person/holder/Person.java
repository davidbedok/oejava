package hu.qwaevisz.person.holder;

public class Person {

	private final String name;
	private final String password;
	private final String email;

	public Person(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

}

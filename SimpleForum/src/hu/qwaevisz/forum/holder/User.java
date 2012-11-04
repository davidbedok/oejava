package hu.qwaevisz.forum.holder;

public class User {

	private final String userName;
	private final String password;
	private final String nick;

	public User(String userName, String password, String nick) {
		this.userName = userName;
		this.password = password;
		this.nick = nick;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public String getNick() {
		return this.nick;
	}

}

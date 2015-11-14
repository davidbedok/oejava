package hu.qwaevisz.forum.holder;

import java.util.ArrayList;
import java.util.List;

public class UserData {

	private final List<User> users;

	protected UserData() {
		this.users = new ArrayList<User>();
		this.users.add(new User("test1", "123", "test1nick"));
		this.users.add(new User("test2", "321", "test2nick"));
		this.users.add(new User("test3", "111", "test3nick"));
		this.users.add(new User("test4", "222", "test4nick"));
	}

	public User login(final String userName, final String password) {
		User result = null;
		boolean find = false;
		int i = 0;
		while (i < this.users.size() && !find) {
			final User user = this.users.get(i);
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				find = true;
				result = user;
			}
			i++;
		}
		return result;
	}

	public User findUser(final String userName) {
		User result = null;
		int i = 0;
		while (i < this.users.size() && result == null) {
			final User user = this.users.get(i);
			if (user.getUserName().equals(userName)) {
				result = user;
			}
			i++;
		}
		return result;
	}

	private static UserData instance = null;

	public static UserData getInstance() {
		if (UserData.instance == null) {
			synchronized (UserData.class) {
				if (UserData.instance == null) {
					UserData.instance = new UserData();
				}
			}
		}
		return UserData.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}

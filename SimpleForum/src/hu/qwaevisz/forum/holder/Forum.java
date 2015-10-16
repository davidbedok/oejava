package hu.qwaevisz.forum.holder;

import java.util.ArrayList;
import java.util.List;

public class Forum {

	private static final String ENTRY_SEPARATOR = "\\|";

	private final List<ForumEntry> posts;

	public void addEntry(String nick, String message) {
		this.posts.add(new ForumEntry(nick, message));
	}

	// danger..
	public List<ForumEntry> getPosts() {
		return this.posts;
	}

	public static List<ForumEntry> parseEntries(String content) {
		List<ForumEntry> entries = new ArrayList<ForumEntry>();
		if (content != null) {
			String[] entriesLine = content.split(Forum.ENTRY_SEPARATOR);
			for (String line : entriesLine) {
				entries.add(ForumEntry.parseEntry(line));
			}
		}
		return entries;
	}

	protected Forum() {
		this.posts = new ArrayList<ForumEntry>();
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		for (ForumEntry entry : this.posts) {
			info.append(entry.getNick()).append(": ").append(entry.getMessage()).append("\n");
		}
		return info.toString();
	}

	private static Forum instance = null;

	public static Forum getInstance() {
		if (Forum.instance == null) {
			synchronized (Forum.class) {
				if (Forum.instance == null) {
					Forum.instance = new Forum();
				}
			}
		}
		return Forum.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}

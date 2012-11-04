package hu.qwaevisz.forum.holder;


public class ForumEntry {

	private static final String FIELD_SEPARATOR = "\\;";

	private final String nick;
	private final String message;

	public ForumEntry(String nick, String message) {
		this.nick = nick;
		this.message = message;
	}

	public String getNick() {
		return this.nick;
	}

	public String getMessage() {
		return this.message;
	}

	public static ForumEntry parseEntry(String line) {
		ForumEntry entry = null;
		if (line != null) {
			String[] fields = line.split(ForumEntry.FIELD_SEPARATOR);
			if ((fields != null) && (fields.length == 2)) {
				entry = new ForumEntry(fields[0], fields[1]);
			}
		}
		return entry;
	}

	@Override
	public String toString() {
		return this.nick + ": " + this.message;
	}

}

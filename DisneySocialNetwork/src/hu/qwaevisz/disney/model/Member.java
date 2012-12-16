package hu.qwaevisz.disney.model;

import hu.qwaevisz.disney.exception.InvalidDisneyFileException;

import java.util.HashSet;
import java.util.Set;

public class Member {

	private final Integer unid;
	private final String name;
	private final String movie;
	private final String image;
	private final Set<Member> friends;
	private final Set<Phone> phones;

	public Member(Integer unid, String name, String movie, String image) {
		this.unid = unid;
		this.name = name;
		this.movie = movie;
		this.image = image;
		this.friends = new HashSet<Member>();
		this.phones = new HashSet<Phone>();
	}

	public void addFriend(Member member) {
		if (!this.friends.contains(member)) {
			this.friends.add(member);
		}
	}

	private void addPhone(Phone phone) {
		if (!this.phones.contains(phone)) {
			this.phones.add(phone);
		}
	}

	public void addPhone(String number, PhoneType type) {
		this.addPhone(new Phone(number, type));
	}

	public String getImage() {
		return this.image;
	}

	public String getMovie() {
		return this.movie;
	}

	public String getName() {
		return this.name;
	}

	public Integer getUnid() {
		return this.unid;
	}

	public Set<Member> getFriends() {
		return this.friends;
	}

	public Set<Phone> getPhones() {
		return this.phones;
	}

	public static Member createMember(String line) throws InvalidDisneyFileException {
		Member member = null;
		if (line != null) {
			try {
				String[] resultOfSplit = line.split("\\;");
				Integer unid = Integer.valueOf(resultOfSplit[0]);
				String name = resultOfSplit[1];
				String movie = resultOfSplit[2];
				String image = resultOfSplit[3];
				member = new Member(unid, name, movie, image);
			} catch (IndexOutOfBoundsException e) {
				throw new InvalidDisneyFileException(line, "corrupt input");
			} catch (Exception e) {
				throw new InvalidDisneyFileException(line, "unknown error");
			}
		}
		return member;
	}

}

package hu.qwaevisz.disney.service;

import hu.qwaevisz.disney.exception.InvalidDisneyFileException;
import hu.qwaevisz.disney.model.Member;
import hu.qwaevisz.disney.model.PhoneType;
import hu.qwaevisz.disney.util.NameGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SocialNetwork {

	private static final String MEMBERS_FILE_NAME = "members.dat";
	private static final String NETWORK_FILE_NAME = "network.dat";
	private static final String PHONES_FILE_NAME = "phones.dat";

	private final Set<Member> members;

	private SocialNetwork() {
		this.members = new HashSet<Member>();

		// Comment if random network
		this.loadMembers();
		this.loadNetwork();
		this.loadPhones();
	}

	private void addMember(Member member) {
		if (!this.members.contains(member)) {
			this.members.add(member);
		}
	}

	public void addMember(Integer unid, String name, String movie, String image) {
		this.addMember(new Member(unid, name, movie, image));
	}

	public Member find(Integer unid) {
		Member member = null;
		if (unid != null) {
			for (Member current : this.members) {
				if (current.getUnid().equals(unid)) {
					member = current;
					break;
				}
			}
		}
		return member;
	}

	private void loadMembers() {
		BufferedReader buffReader = null;
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(SocialNetwork.MEMBERS_FILE_NAME);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			buffReader = new BufferedReader(inputStreamReader);
			String line = null;
			do {
				line = buffReader.readLine();
				if (line != null) {
					Member member = Member.createMember(line);
					this.addMember(member);
				}
			} while (line != null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidDisneyFileException e) {
			e.printStackTrace();
		} finally {
			try {
				buffReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadNetwork() {
		BufferedReader buffReader = null;
		String line = null;
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(SocialNetwork.NETWORK_FILE_NAME);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			buffReader = new BufferedReader(inputStreamReader);
			do {
				line = buffReader.readLine();
				if (line != null) {
					String[] resultOfSplit = line.split("\\;");
					Integer memberUnid = Integer.valueOf(resultOfSplit[0]);
					Integer friendUnid = Integer.valueOf(resultOfSplit[1]);
					Member member = this.find(memberUnid);
					Member friend = this.find(friendUnid);
					if ((member != null) && (friend != null)) {
						member.addFriend(friend);
					}
				}
			} while (line != null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buffReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadPhones() {
		BufferedReader buffReader = null;
		String line = null;
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(SocialNetwork.PHONES_FILE_NAME);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			buffReader = new BufferedReader(inputStreamReader);
			do {
				line = buffReader.readLine();
				if (line != null) {
					String[] resultOfSplit = line.split("\\;");
					Integer memberUnid = Integer.valueOf(resultOfSplit[0]);
					Integer phoneTypeGrid = Integer.valueOf(resultOfSplit[1]);
					String number = resultOfSplit[2];
					Member member = this.find(memberUnid);
					if (member != null) {
						member.addPhone(number, PhoneType.fromGrid(phoneTypeGrid));
					}
				}
			} while (line != null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buffReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Only demo method.
	 * 
	 * @return
	 */
	public static SocialNetwork createRandomNetwork() {
		SocialNetwork network = new SocialNetwork();
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			String name = NameGenerator.randomName(rand);
			String movie = NameGenerator.randomName(rand);
			Member member = new Member(i, name, movie, "");
			network.addMember(member);
			int numberOfPhones = rand.nextInt(3) + 1;
			for (int j = 0; j < numberOfPhones; j++) {
				String number = NameGenerator.randomNumber(rand);
				member.addPhone(number, PhoneType.randomType(rand));
			}
		}
		for (int i = 0; i < 20; i++) {
			Member member = network.find(i);
			int numberOfFriend = rand.nextInt(10) + 1;
			for (int j = 0; j < numberOfFriend; j++) {
				member.addFriend(network.randomMember(rand));
			}
		}
		return network;
	}

	private Member randomMember(Random rand) {
		Member[] array = this.members.toArray(new Member[] {});
		return array[rand.nextInt(array.length)];
	}

	public Set<Member> getMembers() {
		return this.members;
	}

	private static SocialNetwork instance = null;

	public static SocialNetwork getInstance() {
		if (SocialNetwork.instance == null) {
			synchronized (SocialNetwork.class) {
				if (SocialNetwork.instance == null) {
					SocialNetwork.instance = new SocialNetwork();
					// RANDOM network:
					// SocialNetwork.instance = SocialNetwork.createRandomNetwork();
				}
			}
		}
		return SocialNetwork.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}

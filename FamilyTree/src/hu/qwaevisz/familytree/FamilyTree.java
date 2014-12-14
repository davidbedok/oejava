package hu.qwaevisz.familytree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

	private final List<Person> familyMembers;

	public Person find(final int unid) {
		Person result = null;
		for (final Person member : this.familyMembers) {
			if (member.getUnid() == unid) {
				result = member;
				break;
			}
		}
		return result;
	}

	// --------------------

	private FamilyTree() {
		this.familyMembers = new ArrayList<Person>();

		final Person kovacsGeza = new Person(10, "Kovacs Geza", Gender.MAN, 1923, 1991);
		final Person szaboMagdolna = new Person(20, "Sazbo Magdolna", Gender.WOMAN, 1923, 2002);
		final Person kovacsBela = new Person(30, "Kovacs Bela", Gender.MAN, 1951, 2005);
		final Person szucsAnnamaria = new Person(40, "Szucs Annamaria", Gender.WOMAN, 1955);
		final Person kovacsZoltan = new Person(50, "Kovacs Zoltan", Gender.MAN, 1981);
		final Person luczGizella = new Person(60, "Lucz Gizella", Gender.WOMAN, 1982);
		final Person kovacsMaria = new Person(70, "Kovacs Maria", Gender.WOMAN, 1984);
		final Person nagyPeter = new Person(80, "Nagy Peter", Gender.MAN, 1979);
		final Person kovacsGergely = new Person(90, "Kovacs Gerhely", Gender.MAN, 2005);
		final Person kovacsLiza = new Person(100, "Kovacs Liza", Gender.WOMAN, 2013);
		final Person nagyMihaly = new Person(110, "Nagy Mihaly", Gender.MAN, 2009);
		final Person nagyPiroska = new Person(120, "Nagy Piroska", Gender.WOMAN, 2014);

		kovacsBela.setParents(szaboMagdolna, kovacsGeza);
		kovacsZoltan.setParents(szucsAnnamaria, kovacsBela);
		kovacsGergely.setParents(luczGizella, kovacsZoltan);
		kovacsLiza.setParents(luczGizella, kovacsZoltan);
		kovacsMaria.setParents(szucsAnnamaria, kovacsBela);
		nagyMihaly.setParents(kovacsMaria, nagyPeter);
		nagyPiroska.setParents(kovacsMaria, nagyPeter);

		this.add(kovacsGeza);
		this.add(szaboMagdolna);
		this.add(kovacsBela);
		this.add(szucsAnnamaria);
		this.add(kovacsZoltan);
		this.add(luczGizella);
		this.add(kovacsMaria);
		this.add(nagyPeter);
		this.add(kovacsGergely);
		this.add(kovacsLiza);
		this.add(nagyMihaly);
		this.add(nagyPiroska);
	}

	private void add(final Person member) {
		this.familyMembers.add(member);
	}

	private static FamilyTree INSTANCE;

	public static FamilyTree getInstance() {
		if (INSTANCE == null) {
			synchronized (FamilyTree.class) {
				if (INSTANCE == null) {
					INSTANCE = new FamilyTree();
				}
			}
		}
		return INSTANCE;
	}
}

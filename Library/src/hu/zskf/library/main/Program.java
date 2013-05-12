package hu.zskf.library.main;

import hu.zskf.library.base.Language;
import hu.zskf.library.base.Publisher;
import hu.zskf.library.book.Encyclopedia;
import hu.zskf.library.book.LiteratureBook;
import hu.zskf.library.book.Period;
import hu.zskf.library.book.SciFiBook;
import hu.zskf.library.book.TechnicalLiterature;

public class Program {

	public static void main(String[] args) {
		Library lib = new Library("Szabo Ervin");
		lib.add(new SciFiBook("Dune", 5432, Language.English,
				Publisher.KISKAPU, 1982, "space"));
		lib.add(new LiteratureBook("Anyam tyukja", 34, Language.Hungarian,
				Publisher.BABITS, 1456, Period.Renaissance));
		lib.add(new TechnicalLiterature("Java 1.4", 5432, Language.English,
				Publisher.KISKAPU, 1982, "programming"));
		lib.add(new Encyclopedia("Tudas faja", 432, Language.Hungarian,
				Publisher.BABITS, 1456, 'A', 'K'));

		System.out.println(lib);

		System.out.println(lib.borrow("Nemecsek", "Anyam tyukja"));
		System.out.println(lib.borrow("Tutajos", "Dune"));
		System.out.println(lib.borrow("Nemecsek", "Tudas faja"));
	}

}

package hu.qwaevisz.turazas;

public class Program {

	public static void main(String[] args) {
		Program.tesztTermeszetjaro();
		Program.tesztTura();
		Program.tesztCsapat();
		Program.tesztTuraKatalogus();
	}

	private static void tesztTermeszetjaro() {
		System.out.println("---[ Teszt Termeszetjaro ]---");
		Termeszetjaro termeszetjaro = new Termeszetjaro("Nemecsek Erno", 1907);
		System.out.println(termeszetjaro);
	}

	private static void tesztTura() {
		System.out.println("---[ Teszt Tura ]---");
		Tura tura = new Tura("BHTCS", 2009, Nehezseg.EXTREM);
		System.out.println(tura);
	}

	private static void tesztCsapat() {
		System.out.println("---[ Teszt Csapat ]---");
		Tura tura = new Tura("BHTCS", 2009, Nehezseg.EXTREM);

		Termeszetjaro termeszetjaro1 = new Termeszetjaro("Nemecsek Erno", 1907);
		Termeszetjaro termeszetjaro2 = new Termeszetjaro("Anakin Skywalker", 1981);
		Termeszetjaro termeszetjaro3 = new Termeszetjaro("MuadDib", 2005);

		Csapat csapat = new Csapat("IronMans", tura, true);
		csapat.hozzaad(termeszetjaro1);
		csapat.hozzaad(termeszetjaro2);
		csapat.hozzaad(termeszetjaro3);

		System.out.println(csapat);
	}

	private static void tesztTuraKatalogus() {
		System.out.println("---[ Teszt TuraKatalogus ]---");
		TuraKatalogus katalogus = new TuraKatalogus();
		katalogus.turaRegisztralasa("BHTCS", 2010, Nehezseg.NEHEZ);
		katalogus.turaRegisztralasa("Kisvasut", 2011, Nehezseg.EGYSZERU);
		katalogus.turaRegisztralasa("Mecsek", 2009, Nehezseg.KOZEPES);

		katalogus.termeszetjaroHozzaadasa("Hunor", 1993);
		katalogus.termeszetjaroHozzaadasa("Csongor", 1996);
		katalogus.termeszetjaroHozzaadasa("Zeteny", 1996);

		katalogus.csapatHozzaadasa("Alpha", "BHTCS", true);
		katalogus.termeszetjaroCsapathozRendelese("Alpha", "BHTCS", "Hunor");
		katalogus.termeszetjaroCsapathozRendelese("Alpha", "BHTCS", "Csongor");

		katalogus.csapatHozzaadasa("Beta", "BHTCS", false);
		katalogus.termeszetjaroCsapathozRendelese("Beta", "BHTCS", "Zeteny");

		katalogus.csapatHozzaadasa("Alpha", "Mecsek", false);
		katalogus.termeszetjaroCsapathozRendelese("Alpha", "Mecsek", "Zeteny");
		katalogus.termeszetjaroCsapathozRendelese("Alpha", "Mecsek", "Hunor");

		katalogus.csapatHozzaadasa("Beta", "Kisvasut", true);
		katalogus.termeszetjaroCsapathozRendelese("Beta", "Kisvasut", "Csongor");
		katalogus.termeszetjaroCsapathozRendelese("Beta", "Kisvasut", "Zeteny");

		System.out.println(katalogus);
		System.out.println("Hunor pontjai: " + katalogus.pontSzamitas("Hunor"));
		System.out.println("Csongor pontjai: " + katalogus.pontSzamitas("Csongor"));
		System.out.println("Zeteny pontjai: " + katalogus.pontSzamitas("Zeteny"));

		System.out.println("A legeredmenyesebb termeszetjaro: " + katalogus.aLegeredmenyesebbTermeszetjaro());
	}

}

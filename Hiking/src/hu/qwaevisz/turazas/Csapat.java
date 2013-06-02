package hu.qwaevisz.turazas;

public class Csapat {

	private static final int		MAX_TERMESZETJAROK	= 5;

	private final String			nev;
	private final Tura				tura;
	private final boolean			sikeres;
	private final Termeszetjaro[]	termeszetjarok;
	private int						index;

	public Csapat(String nev, Tura tura, boolean sikeres) {
		this.nev = nev;
		this.tura = tura;
		this.sikeres = sikeres;
		this.termeszetjarok = new Termeszetjaro[Csapat.MAX_TERMESZETJAROK];
		this.index = 0;
	}

	public void hozzaad(Termeszetjaro termeszetjaro) {
		if (this.index < Csapat.MAX_TERMESZETJAROK) {
			this.termeszetjarok[this.index++] = termeszetjaro;
		}
	}

	public String getNev() {
		return this.nev;
	}

	public boolean isSikeres() {
		return this.sikeres;
	}

	public String turaEsemeny() {
		return this.tura.getEsemeny();
	}

	public boolean vanTermeszetjaro(String nev) {
		int i = 0;
		while (i < this.index && !this.termeszetjarok[i].getNev().equals(nev)) {
			i++;
		}
		return i < this.index;
	}

	public int pont(String nev) {
		int i = 0;
		while (i < this.index && !this.termeszetjarok[i].getNev().equals(nev)) {
			i++;
		}
		return this.tura.nehezsegPont() * this.eletkor(this.termeszetjarok[i]);
	}

	private int eletkor(Termeszetjaro termeszetjaro) {
		return this.tura.getEv() - termeszetjaro.getSzuletesiEv();
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(50);
		info.append(this.nev).append(" - ").append(this.tura);
		info.append(this.sikeres ? " SIKERES " : " SIKERTELEN").append("\n");
		for (int i = 0; i < this.index; i++) {
			info.append("   > ").append(this.termeszetjarok[i]).append("\n");
		}
		return info.toString();
	}

}

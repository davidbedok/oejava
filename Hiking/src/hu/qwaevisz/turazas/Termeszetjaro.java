package hu.qwaevisz.turazas;

public class Termeszetjaro {

	private final String	nev;
	private final int		szuletesiEv;

	public Termeszetjaro(String nev, int szuletesiEv) {
		this.nev = nev;
		this.szuletesiEv = szuletesiEv;
	}

	public String getNev() {
		return this.nev;
	}

	public int getSzuletesiEv() {
		return this.szuletesiEv;
	}

	@Override
	public String toString() {
		return this.nev + " (szuletesi ev: " + this.szuletesiEv + ")";
	}

}

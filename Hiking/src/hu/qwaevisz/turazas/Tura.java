package hu.qwaevisz.turazas;

public class Tura {

	private final String	esemeny;
	private final int		ev;
	private final Nehezseg	nehezseg;

	public Tura(String esemeny, int ev, Nehezseg nehezseg) {
		this.esemeny = esemeny;
		this.ev = ev;
		this.nehezseg = nehezseg;
	}

	public String getEsemeny() {
		return this.esemeny;
	}

	public int getEv() {
		return this.ev;
	}

	public int nehezsegPont() {
		return this.nehezseg.getPont();
	}

	@Override
	public String toString() {
		return this.esemeny + " " + this.ev + "-ben (" + this.nehezseg + ")";
	}

}

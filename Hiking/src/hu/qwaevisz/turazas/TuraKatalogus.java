package hu.qwaevisz.turazas;

public class TuraKatalogus {

	private static final int		MAX_TERMESZETJAROK	= 20;
	private static final int		MAX_TURAK			= 5;
	private static final int		MAX_CSAPATOK		= 10;

	private final Tura[]			turak;
	private int						idxTurak;
	private final Termeszetjaro[]	termeszetjarok;
	private int						idxTermeszetjarok;
	private final Csapat[]			csapatok;
	private int						idxCsapatok;

	public TuraKatalogus() {
		this.turak = new Tura[MAX_TURAK];
		this.idxTurak = 0;
		this.termeszetjarok = new Termeszetjaro[MAX_TERMESZETJAROK];
		this.idxTermeszetjarok = 0;
		this.csapatok = new Csapat[MAX_CSAPATOK];
		this.idxCsapatok = 0;
	}

	public void turaRegisztralasa(String nev, int ev, Nehezseg nehezseg) {
		this.turaRegisztralasa(new Tura(nev, ev, nehezseg));
	}

	private void turaRegisztralasa(Tura tura) {
		if (this.idxTurak < MAX_TURAK) {
			this.turak[this.idxTurak++] = tura;
		}
	}

	public void csapatHozzaadasa(String csapatNeve, String turaNeve, boolean sikeres) {
		Tura tura = this.turaKereses(turaNeve);
		if (tura != null) {
			this.csapatHozzaadasa(new Csapat(csapatNeve, tura, sikeres));
		}
	}

	private Tura turaKereses(String esemeny) {
		Tura tura = null;
		int i = 0;
		while (i < this.idxTurak && !this.turak[i].getEsemeny().equals(esemeny)) {
			i++;
		}
		if (i < this.idxTurak) {
			tura = this.turak[i];
		}
		return tura;
	}

	private void csapatHozzaadasa(Csapat csapat) {
		if (this.idxCsapatok < MAX_CSAPATOK) {
			this.csapatok[this.idxCsapatok++] = csapat;
		}
	}

	public void termeszetjaroHozzaadasa(String nev, int szuletesiEv) {
		this.termeszetjaroHozzaadasa(new Termeszetjaro(nev, szuletesiEv));
	}

	private void termeszetjaroHozzaadasa(Termeszetjaro termeszetjaro) {
		if (this.idxTermeszetjarok < MAX_TERMESZETJAROK) {
			this.termeszetjarok[this.idxTermeszetjarok++] = termeszetjaro;
		}
	}

	public void termeszetjaroCsapathozRendelese(String csapatNeve, String turaNeve, String termeszetjaroNeve) {
		Csapat csapat = this.csapatKereses(csapatNeve, turaNeve);
		if (csapat != null) {
			Termeszetjaro termeszetjaro = this.termeszetjaroKereses(termeszetjaroNeve);
			if (termeszetjaro != null) {
				csapat.hozzaad(termeszetjaro);
			}
		}
	}

	private Csapat csapatKereses(String nev, String turaEsemeny) {
		Csapat csapat = null;
		int i = 0;
		while (i < this.idxCsapatok) {
			if (this.csapatok[i].getNev().equals(nev) && this.csapatok[i].turaEsemeny().equals(turaEsemeny)) {
				csapat = this.csapatok[i];
				break;
			}
			i++;
		}
		return csapat;
	}

	private Termeszetjaro termeszetjaroKereses(String nev) {
		Termeszetjaro termeszetjaro = null;
		int i = 0;
		while (i < this.idxTermeszetjarok && !this.termeszetjarok[i].getNev().equals(nev)) {
			i++;
		}
		if (i < this.idxTermeszetjarok) {
			termeszetjaro = this.termeszetjarok[i];
		}
		return termeszetjaro;
	}

	public int pontSzamitas(String termeszetjaroNeve) {
		int pont = 0;
		for (int i = 0; i < this.idxCsapatok; i++) {
			if (this.csapatok[i].vanTermeszetjaro(termeszetjaroNeve) && this.csapatok[i].isSikeres()) {
				pont += this.csapatok[i].pont(termeszetjaroNeve);
			}
		}
		return pont;
	}

	public Termeszetjaro aLegeredmenyesebbTermeszetjaro() {
		Termeszetjaro legeredmenyesebbTermeszetjaro = null;
		if (this.idxTermeszetjarok > 0) {
			legeredmenyesebbTermeszetjaro = this.termeszetjarok[0];
			int maxPont = this.pontSzamitas(legeredmenyesebbTermeszetjaro.getNev());
			for (int i = 1; i < this.idxTermeszetjarok; i++) {
				int aktualisPont = this.pontSzamitas(this.termeszetjarok[i].getNev());
				if (aktualisPont > maxPont) {
					legeredmenyesebbTermeszetjaro = this.termeszetjarok[i];
					maxPont = aktualisPont;
				}
			}
		}
		return legeredmenyesebbTermeszetjaro;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append("# Termeszetjarok").append("\n");
		for (int i = 0; i < this.idxTermeszetjarok; i++) {
			info.append(" - ").append(this.termeszetjarok[i]).append("\n");
		}
		info.append("# Turak").append("\n");
		for (int i = 0; i < this.idxTurak; i++) {
			info.append(" - ").append(this.turak[i]).append("\n");
		}
		info.append("# Csapatok").append("\n");
		for (int i = 0; i < this.idxCsapatok; i++) {
			info.append(" - ").append(this.csapatok[i]);
		}
		return info.toString();
	}

}

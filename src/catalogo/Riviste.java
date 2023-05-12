package catalogo;

import catalogo.Periodicita;
import catalogo.Prodotto;

public class Riviste extends Prodotto {
	private Periodicita periodicita;

	public Riviste(long codiceISBN, String titolo, String annoPubblicazione, int numeroPagine,
			Periodicita periodicita) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "[codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + ", periodicita=" + periodicita + "]";
	}

	public String getTitolo() {
		return titolo;
	}

	public long getCodiceISBN() {
		return codiceISBN;
	}

	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}

}

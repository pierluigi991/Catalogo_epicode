package catalogo;

public abstract class Prodotto {
	protected long codiceISBN;
	protected String titolo;
	protected String annoPubblicazione;
	protected int numeroPagine;

	public Prodotto(long codiceISBN, String titolo, String annoPubblicazione, int numeroPagine) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public long getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(long codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(String annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public String getAutore() {
		return "";
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

}

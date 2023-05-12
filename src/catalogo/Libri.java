package catalogo;



public class Libri extends Prodotto {
	private String autore;
	private String genere;

	public Libri(long codiceISBN, String titolo, String annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "[codiceISBN=" + this.codiceISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + ", autore=" + autore + ", genere=" + genere + "]";
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

	public String getAutore() {
		return autore;
	}

}

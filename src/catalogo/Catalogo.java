package catalogo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

//import catalogo.Libri;
//import catalogo.Periodicita;
//import catalogo.Prodotto;
//import catalogo.Riviste;

public class Catalogo {
	static File file = new File("fileEsercizio.txt");

	public static void main(String[] args) {


		List<Prodotto> listaProdotti = new ArrayList<Prodotto>();

		//******************LISTA DI TUTTI GLI ARTICOLI DELLA BIBLIOTECA*************

		Libri libro1 = new Libri(1234567L, "Harry Potter", "2009", 502, "j.k.Rowling", "fantasy");
		Libri libro2 = new Libri(29303132L, "Un omicidio reale", "2017", 136, "S.J.Bennet","giallo");
		Libri libro3 = new Libri(89101112L, "Tutti i nomi della morte", "2017", 96,"Dario Correnti", "giallo");
		Libri libro4 = new Libri(880435943540L, "epicode", "2012", 46, "pierluigi marzo", "programmazione");


		Riviste rivista1 = new Riviste(13141516L, "Panorama - n.1137", "2022", 73,Periodicita.MENSILE);
		Riviste rivista2 = new Riviste(18192021L, "Focus - n.120", "2002", 87, Periodicita.MENSILE);
		Riviste rivista3 = new Riviste(22232425L, "La settimana enigmistica - n.4742", "2023", 44,Periodicita.SETTIMANALE);
		Riviste rivista4 = new Riviste(26272829L, "sudoku", "1999", 49, Periodicita.SEMESTRALE);

		listaProdotti.add(libro1);
		listaProdotti.add(libro2);
		listaProdotti.add(libro3);

		listaProdotti.add(rivista1);
		listaProdotti.add(rivista2);
		listaProdotti.add(rivista3);


		//metodi//
		stampaProdotti(listaProdotti); 					
		addRivista(listaProdotti, rivista4); 			
		addLibro(listaProdotti, libro4); 				
		stampaProdotti(listaProdotti); 					
		eliminaTramiteCodice(listaProdotti, 18192021L); 	
		cercaTramiteCodice(listaProdotti, 29303132L); 		
		cercaTramitePubblicazione(listaProdotti, "2022"); 		
		cercaProdottoTramiteAutore(listaProdotti, "j.k.Rowling"); 	

		cercaProdottoTramiteAutore(listaProdotti, "Goku");



		scriviFile(listaProdotti);
		leggiFile();


	}

	//METODO DI STAMPA DEI PRODOTTI
	public static void stampaProdotti(List<Prodotto> listaProdotti) {
		listaProdotti.forEach(ele -> {
			String x = ele.getClass().toString();
			if (x.contains("Libri")) {
				System.out.println("Libro: " + ele.getTitolo());
			} else {
				System.out.println("Rivista: " + ele.getTitolo());
			}
		});
		System.out.println("------------------------------------------------------------------------");
	}


	//METODO PER AGGIUNGERE UN LIBRO
	public static void addLibro(List<Prodotto> listaProdotti, Libri libro) {
		listaProdotti.add(libro);
		System.out.println("Il libro " + libro.getTitolo() + " è stato aggiunto!");
		System.out.println("------------------------------------------------------------------------");
	}


	// METODO PER AGGIUNGERE UNA RIVISTA
	public static void addRivista(List<Prodotto> listaProdotti, Riviste rivista) {
		listaProdotti.add(rivista);
		System.out.println("La rivista " + rivista.getTitolo() + " è stata aggiunta!");
		System.out.println("------------------------------------------------------------------------");
	}


	// METODO PER ELIMINARE UN PRODOTTO TRAMITE IL SUO COD
	public static void eliminaTramiteCodice(List<Prodotto> listaProdotti, long isbn) {
		List<Prodotto> listaSenzaElemento = listaProdotti.stream().filter(ele -> ele.getCodiceISBN() != isbn).toList();
		listaProdotti.clear();
		listaProdotti.addAll(listaSenzaElemento);
		System.out.println("elemento rimosso dal catalogo!" );
		if (listaProdotti.size() >= 1) {
			System.out.println();
			System.out.println("Lista aggiornata:");
			stampaProdotti(listaProdotti);
		} else {
			System.out.println("il tuo catalogo non contiene alcun elemento!");

		}
	}

	// METODO PER CERCARE IL PRODOTTO TRAMITE IL SUO CODICE
	public static void cercaTramiteCodice(List<Prodotto> listaProdotti, long isbn) {
		List<Prodotto> prodottiTrovati = listaProdotti.stream().filter(ele -> ele.getCodiceISBN() == isbn).toList();
		if (prodottiTrovati.size() >= 1) {
			prodottiTrovati.forEach(ele -> {
				String x = ele.getClass().toString();
				if (x.contains("Libri")) {
					System.out.println("Libro trovato tramite isbn (" + isbn + "): " + ele.getTitolo());
				} else {
					System.out.println("Rivista trovata tramite isbn (" + isbn + "): " + ele.getTitolo());
				}
			});
		} else {
			System.out.println("La tua ricerca tramite isbn (" + isbn + ") non ha prodotto nessun risultato!");
		}
		System.out.println("------------------------------------------------------------------------");
	}


	//METODO PER CERCARE IL PRODOTTO TRAMITE IL SUO ANNO DI PUBBLICAZIONE
	public static void cercaTramitePubblicazione(List<Prodotto> listaProdotti, String annoPub) {
		List<Prodotto> prodottiTrovati = listaProdotti.stream()
				.filter(ele -> ele.getAnnoPubblicazione().equalsIgnoreCase(annoPub)).toList();
		if (prodottiTrovati.size() >= 1) {
			prodottiTrovati.forEach(ele -> {
				String x = ele.getClass().toString();
				if (x.contains("Libri")) {
					System.out.println(
							"Libro trovato tramite data di pubblicazione (" + annoPub + "): " + ele.getTitolo());
				} else {
					System.out.println(
							"Rivista trovata tramite data di pubblicazione (" + annoPub + "): " + ele.getTitolo());
				}
			});
		} else {
			System.out.println(
					"La tua ricerca tramite data di pubblicazione (" + annoPub + ") non ha prodotto nessun risultato!");
		}

		System.out.println("------------------------------------------------------------------------");
	}

	// METODO PER LA RICERCA DEL PRODOTTO TRAMITE L'AUTORE
	public static void cercaProdottoTramiteAutore(List<Prodotto> listaProdotti, String autore) {
		List<Prodotto> prodottiTrovati = listaProdotti.stream().filter(ele -> ele.getAutore().equals(autore))
				.toList();
		if (prodottiTrovati.size() >= 1) {
			prodottiTrovati.forEach(ele -> {

				System.out.println("Libro trovato tramite autore (" + autore + "): " + ele.getTitolo());
			});
		} else {
			System.out.println("La tua ricerca tramite l'autore (" + autore + ") non ha prodotto nessun risultato!");
		}
		System.out.println("------------------------------------------------------------------------");

	}

	//METODO PER SOVRASCRIVERE IL FILE
	public static void scriviFile(List<Prodotto> listaProdotti) {
		try {
			FileUtils.writeLines(file, "UTF-8", listaProdotti);
			System.out.println("Scrittura su file !");
			System.out.println("------------------------------------------------------------------------");
		} catch (IOException e) {
			System.out.println("ERRORE DURANTE LA SCRITTURA");
			System.out.println("------------------------------------------------------------------------");
		}
	}

	//METODO DI LETTURA DEL FILE
	public static void leggiFile() {
		try (InputStream input = new FileInputStream("fileEsercizio.txt")) {
			System.out.println("Lettura del file di testo: ");
			System.out.println(IOUtils.toString(input, "UTF-8"));
			System.out.println("------------------------------------------------------------------------");
		} catch (IOException e) {
			System.out.println("ERRORE DURANTE LA LETTURA");
			System.out.println("------------------------------------------------------------------------");
		}
	}
}

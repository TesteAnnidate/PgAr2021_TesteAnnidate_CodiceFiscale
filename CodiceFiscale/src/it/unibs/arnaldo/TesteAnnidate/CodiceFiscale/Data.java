package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

import java.text.SimpleDateFormat;

public class Data {

	private int giorno;
	private Mesi mese;
	private String anno;

	// Metodo che ritorna il carattere associato al mese
	public char ritornaCarattereMese() {
		char carattereMese = 0;
		switch (mese) {
		case GENNAIO:
			carattereMese = 'A';
			break;
		case FEBBRAIO:
			carattereMese = 'B';
			break;
		case MARZO:
			carattereMese = 'C';
			break;
		case APRILE:
			carattereMese = 'D';
			break;
		case MAGGIO:
			carattereMese = 'E';
			break;
		case GIUGNO:
			carattereMese = 'H';
			break;
		case LUGLIO:
			carattereMese = 'L';
			break;
		case AGOSTO:
			carattereMese = 'M';
			break;
		case SETTEMBRE:
			carattereMese = 'P';
			break;
		case OTTOBRE:
			carattereMese = 'R';
			break;
		case NOVEMBRE:
			carattereMese = 'S';
			break;
		case DICEMBRE:
			carattereMese = 'T';
			break;
		}
		return carattereMese;
	}

	// Metodo che dato il numero del mese torna il nome del mese
	public static Mesi ritornaMese(int numeroMese) {
		Mesi m = Mesi.AGOSTO;
		switch (numeroMese) {
		case 1:
			m = Mesi.GENNAIO;
			break;
		case 2:
			m = Mesi.FEBBRAIO;
			break;
		case 3:
			m = Mesi.MARZO;
			break;
		case 4:
			m = Mesi.APRILE;
			break;
		case 5:
			m = Mesi.MAGGIO;
			break;
		case 6:
			m = Mesi.GIUGNO;
			break;
		case 7:
			m = Mesi.LUGLIO;
			break;
		case 8:
			m = Mesi.AGOSTO;
			break;
		case 9:
			m = Mesi.SETTEMBRE;
			break;
		case 10:
			m = Mesi.OTTOBRE;
			break;
		case 11:
			m = Mesi.NOVEMBRE;
			break;
		case 12:
			m = Mesi.DICEMBRE;
			break;
		default:
			System.out.println("Numero mese non disponibile");
		}
		return m;
	}

	// Enum per i mesi
	public enum Mesi {
		GENNAIO, FEBBRAIO, MARZO, APRILE, MAGGIO, GIUGNO, LUGLIO, AGOSTO, SETTEMBRE, OTTOBRE, NOVEMBRE, DICEMBRE;
	}
	// Getters e setters

	public Mesi getMese() {
		return mese;
	}

	public void setMese(Mesi mese) {
		this.mese = mese;
	}

	public int getGiorno() {
		return giorno;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}



	// COSTRUTTORE CHE RICEVE UNA STRINGA AAAA-MM-GG
	public Data(String text) {
		this.anno = text.substring(0, 4);     //ho messo il 4 perchè l'endIndex è escluso
		if(text.charAt(5) == '0')
			this.mese = Data.ritornaMese(Integer.parseInt(text.substring(6, 7)));
		else
			this.mese = Data.ritornaMese(Integer.parseInt(text.substring(5, 7)));
		if(text.charAt(8) == '0')
			this.giorno = Integer.parseInt(text.substring(8, 9));
		else
			this.giorno = Integer.parseInt(text.substring(8, 10));
	}
}

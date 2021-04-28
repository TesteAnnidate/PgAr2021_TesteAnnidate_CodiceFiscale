package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

public class Data {

	private int giorno;
	private Mesi mese;
	private String anno;
	
	
	// Metodo che ritorna il carattere associato al mese
	public char ritornaCarattereMese() {
		char carattereMese = 0;
		switch(mese) {
		case GENNAIO:
			carattereMese = 'A';			
		case FEBBRAIO:
			carattereMese = 'B';
		case MARZO:
			carattereMese = 'C';
		case APRILE:
			carattereMese = 'D';
		case MAGGIO:
			carattereMese = 'E';
		case GIUGNO:
			carattereMese = 'H';
		case LUGLIO:
			carattereMese = 'L';
		case AGOSTO:
			carattereMese = 'M';
		case SETTEMBRE:
			carattereMese = 'P';
		case OTTOBRE:
			carattereMese = 'R';
		case NOVEMBRE:
			carattereMese = 'S';
		case DICEMBRE:
			carattereMese = 'T';
		}
		return carattereMese;
	}
	
	// Enum per i mesi
	public enum Mesi {
		GENNAIO,
		FEBBRAIO,
		MARZO,
		APRILE,
		MAGGIO,
		GIUGNO,
		LUGLIO,
		AGOSTO,
		SETTEMBRE,
		OTTOBRE,
		NOVEMBRE,
		DICEMBRE;		
	}
	// Getters e setters
	
	public int getGiorno() {
		return giorno;
	}
	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}
	
	public Mesi getMese() {
		return mese;
	}
	public void setMese(Mesi mese) {
		this.mese = mese;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}

	//COSTRUTTORE CHE RICEVE UNA STRINGA AAAA-MM-GG
	public Data(String text) {
		//DA IMPLEMENTARE
	}
}

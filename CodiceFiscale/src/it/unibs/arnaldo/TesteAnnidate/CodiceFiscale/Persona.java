package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

public class Persona {
	
	private String nome;
	private String cognome;
	private Data dataDiNascita;
	private char sesso;
	private Comune luogoDiNascita; // oppure una classe Comuni
	private CodiceFiscale cf;
	
	public CodiceFiscale generaCodice() {
		CodiceFiscale c = new CodiceFiscale();
		StringBuffer cf = new StringBuffer();
		// vari append
		c.setCodice(cf);
		return c;
	}
}

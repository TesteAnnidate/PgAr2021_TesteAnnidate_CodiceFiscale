package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

public class Persona {

	private String nome;
	private String cognome;
	private Data dataDiNascita;
	private char sesso;
	private String luogoDiNascita; // oppure una classe Comuni
	private CodiceFiscale cf;

	
	
<<<<<<< HEAD

	// Getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

=======
	public CodiceFiscale generaCodice() {
		CodiceFiscale c = new CodiceFiscale();
		StringBuffer cf = new StringBuffer();
		// vari append
		//c.setCodice(cf);
		return c;
	}

	//MATILDE
	//metodi getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

>>>>>>> 6792e8ef56875070b5559ae5593b2b22d90bc132
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Data getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Data dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

<<<<<<< HEAD
	public Comune getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(Comune luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public CodiceFiscale getCf() {
		return cf;
	}

	public void setCf(CodiceFiscale cf) {
		this.cf = cf;
	}

=======
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
>>>>>>> 6792e8ef56875070b5559ae5593b2b22d90bc132
}

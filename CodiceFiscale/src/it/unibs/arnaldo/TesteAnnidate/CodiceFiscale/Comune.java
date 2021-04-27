package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

public class Comune {
    private String nome_comune;
    private String codice_comune;


    //metodi getter e setters
    public String getNome_comune() {
        return nome_comune;
    }

    public String getCodice_comune() {
        return codice_comune;
    }

    public void setNome_comune(String nome_comune) {
        this.nome_comune = nome_comune;
    }

    public void setCodice_comune(String codice_comune){
        this.codice_comune = codice_comune;
    }
}

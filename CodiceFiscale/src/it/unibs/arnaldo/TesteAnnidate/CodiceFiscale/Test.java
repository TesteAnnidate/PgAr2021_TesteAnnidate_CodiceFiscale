package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

import it.unibs.arnaldo.TesteAnnidate.CodiceFiscale.Data.Mesi;

public class Test {

	public static void main(String[] args) {
		
		/*
		Comune l = new Comune("ABBAMO");
		l.setCodice("A123");
		Data d = new Data("1999-02-12");
		Persona p = new Persona();
		p.setNome("COAOAI");
		p.setCognome("CU");
		p.setDataDiNascita(d);
		p.setLuogoDiNascita(l);
		
		CodiceFiscale c = new CodiceFiscale(p);
		System.out.println(c.codiceFiscaleIntero());
		System.out.println(c.getCodiceNome());
		
		Comune _l = new Comune("AISI");
		l.setCodice("B222");
		Data _d = new Data("1998-01-12");
		Persona _p = new Persona();
		_p.setNome("ALO");
		_p.setCognome("ULO");
		_p.setDataDiNascita(_d);
		_p.setLuogoDiNascita(_l);
		
		CodiceFiscale _c = new CodiceFiscale(_p);
		System.out.println(_c.codiceFiscaleIntero());
		System.out.println(_c.getCodiceNome());
		*/
		// Test data
		Data d = new Data();
		d.setAnno("1999");
		d.setGiorno(13);
		d.setMese(Mesi.AGOSTO);
		System.out.println(d.ritornaStringaData());

	}

}

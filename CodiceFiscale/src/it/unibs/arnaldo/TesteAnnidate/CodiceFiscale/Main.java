package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws XMLStreamException {

		ArrayList<Persona> listaPersone = new ArrayList<Persona>();
		ArrayList<CodiceFiscale> listaCodici = new ArrayList<CodiceFiscale>();
		ArrayList<Comune> listaComuni = new ArrayList<Comune>();

		/*listaComuni = Input.leggiComuni();

		for(Comune elemento: listaComuni) {
			System.out.println(elemento.getNome_comune());
			System.out.println(elemento.getCodice());
		}*/

		listaPersone = Input.leggiPersone();

		for(Persona elemento: listaPersone){
			System.out.println(elemento.getNome());
			System.out.println(elemento.getCognome());
			System.out.println(elemento.getSesso());
			System.out.println(elemento.getDataDiNascita().getAnno() + "-" + elemento.getDataDiNascita().getMese() + "-" + elemento.getDataDiNascita().getGiorno());
			System.out.println(elemento.getLuogoDiNascita().getNome_comune());
		}

	}

}

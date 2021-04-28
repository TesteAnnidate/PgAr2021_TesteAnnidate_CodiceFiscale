package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.*;
import java.util.ArrayList;


public class Input {
    //metodo statico che legge e ritorna un array di persone
    //MATILDE

    public static ArrayList<Persona> leggiPersone() throws XMLStreamException {

        String file_name = "inputPersone.xml";
        ArrayList<Persona> lista_persone = new ArrayList<Persona>();
        Persona persona = null;

        //inizializzazione variabili per la lettura

        XMLInputFactory xmlif = null;
        XMLStreamReader reader = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            reader = xmlif.createXMLStreamReader(file_name, new FileInputStream(file_name));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        String start_element_name = null;

        while (reader.hasNext()) { // continua a leggere finché ha eventi a disposizione

            switch (reader.getEventType()) {

                case XMLStreamConstants.START_ELEMENT:  //salva il nome del tag di apertura in start_element_name per usarlo sotto

                    if (reader.getLocalName().equals("persona"))
                        persona = new Persona();

                    start_element_name = reader.getLocalName();

                    break;

                case XMLStreamConstants.CHARACTERS:     //seta i vari attributi di persona
                    if(start_element_name.equals("nome")) {   //se il tag di apertura (evento prima) è = a nome
                        persona.setNome(reader.getText());    //allora setto l'attributo nome della persona
                    }
                    else if(start_element_name.equals("cognome")){ //setto il cognome
                        persona.setCognome(reader.getText());
                    }
                    else if(start_element_name.equals("sesso")){
                        persona.setSesso(reader.getText().trim().charAt(0));      //imposta il sesso come un char
                    }
                    else if(start_element_name.equals("comune_nascita")){
                       // persona.setLuogoDiNascita(reader.getText());
                    }
                    else if(start_element_name.equals("data_nascita")){
                        persona.setDataDiNascita(new Data(reader.getText()));   //COSRTRUTTORE DA IMPLEMENTARE
                    }

                    break;

                case XMLStreamConstants.END_ELEMENT:
                    lista_persone.add(persona);
            }

            reader.next();   //passa all'evento successivo

        }
        return lista_persone;   //ritorna la lista completa di persone ottenute dall'XML
    }



    //metodo statico che legge e restituisce un array di comuni
    public static ArrayList<Comune> leggiComuni() throws XMLStreamException {

        String filename = "comuni.xml";
        Comune comune = null;
        ArrayList<Comune> lista_comuni = new ArrayList<Comune>();

        XMLInputFactory xmlif = null;
        XMLStreamReader reader = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            reader = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        String start_element_name = null;

        while (reader.hasNext()) { // continua a leggere finché ha eventi a disposizione

            switch (reader.getEventType()) {

                case XMLStreamConstants.START_ELEMENT:  //salva il nome del tag di apertura in start_element_name per usarlo sotto

                    if (reader.getLocalName().equals("persona"))
                        comune = new Comune();

                    start_element_name = reader.getLocalName();

                    break;

                case XMLStreamConstants.CHARACTERS:     //seta i vari attributi di persona
                    if (start_element_name.equals("nome")) {   //se il tag di apertura (evento prima) è = a nome
                        comune.setNome_comune(reader.getText());    //allora setto l'attributo nome della persona
                    } else if (start_element_name.equals("codice")) { //setto il cognome
                       // comune.setCodice_comune(reader.getText());
                    }

                    break;

                case XMLStreamConstants.END_ELEMENT:
                    lista_comuni.add(comune);
            }

            reader.next();   //passa all'evento successivo

        }
            return lista_comuni;
    }



    //metodo che ritorna un array di codici fiscali (quelli del file -xml)

    public static ArrayList<CodiceFiscale> leggiCodiciFiscali() throws XMLStreamException {
        String filename = "CodiciFiscali.xml";
        CodiceFiscale codice_fiscale = null;
        ArrayList<CodiceFiscale> lista_codici_fiscali = new ArrayList<CodiceFiscale>();

        XMLInputFactory xmlif = null;
        XMLStreamReader reader = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            reader = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        while (reader.hasNext()) { // continua a leggere finché ha eventi a disposizione

            switch (reader.getEventType()) {

                case XMLStreamConstants.CHARACTERS:
                    codice_fiscale = new CodiceFiscale(reader.getText());     //COSTRUTTORE DA IMPLEMENTARE

                case XMLStreamConstants.END_ELEMENT:
                    lista_codici_fiscali.add(codice_fiscale);
                    break;
                default: break;
            }
        reader.next();
        }
        return lista_codici_fiscali;

    }
}
package it.unibs.arnaldo.TesteAnnidate.CodiceFiscale;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class OutPut {
    //metodo statico che crea l'xml finale

    public static void creaXml(ArrayList<Persona> lista_persone, ArrayList<CodiceFiscale>lista_codici) throws XMLStreamException {
        String file_name = "src/XMLFiles/codicePersone.xml";
        ArrayList<CodiceFiscale> codici_assenti = new ArrayList<>();


        //inizializzazione variabili per la scrittura
        XMLOutputFactory xmlof = null;
        XMLStreamWriter writer = null;

        try {
            xmlof = XMLOutputFactory.newInstance();
            writer = xmlof.createXMLStreamWriter(new FileOutputStream(file_name), "utf-8");

            writer.writeStartDocument("utf-8", "1.0");
            writer.writeStartElement("output"); // scrittura tag radice
            writer.writeComment("Inizio lista"); //commento
            writer.writeStartElement("persone"); //scrittura tag Persone
            writer.writeAttribute("numero",Integer.toString(lista_persone.size())); //attributo numero

            for(Persona persona: lista_persone){

                writer.writeStartElement("persona");
                writer.writeAttribute("id", Integer.toString(lista_persone.indexOf(persona)));
                writer.writeStartElement("nome");
                writer.writeCharacters(persona.getNome());
                writer.writeEndElement();                       //chiude nome
                writer.writeStartElement("cognome");
                writer.writeCharacters(persona.getCognome());
                writer.writeEndElement();                       //chiude cognome
                writer.writeStartElement("sesso");
                writer.writeCharacters(String.valueOf(persona.getSesso()));
                writer.writeEndElement();                                       //chiude sesso
                writer.writeStartElement("comune_nascita");
                writer.writeCharacters(persona.getLuogoDiNascita().getNome_comune());
                writer.writeEndElement();                                               //chiude comune
                writer.writeStartElement("data_nascita");
                writer.writeCharacters(persona.getDataDiNascita().ritornaStringaData());
                writer.writeEndElement();                                                   //chiude data

                writer.writeStartElement("codice_fiscale");
                if(lista_codici.contains(persona.getCf())) {
                    writer.writeCharacters(persona.getCf().codiceFiscaleIntero());
                }else {
                    writer.writeCharacters("ASSENTE");
                }
                writer.writeEndElement();// chiusura tag codice_fiscale
                writer.writeEndElement();// chiusura tag persona
             }
            writer.writeEndElement(); //chiusura tag persone

            ArrayList<CodiceFiscale> codici_persone = new ArrayList<>();
            for(Persona persona: lista_persone) {
                codici_persone.add(persona.getCf());
            }

            ArrayList<CodiceFiscale> codici_invalidi = new ArrayList<>();
            ArrayList<CodiceFiscale> codici_spaiati = new ArrayList<>();

            for(CodiceFiscale codiceF: lista_codici) {     //se il codice (fra quelli letti) è sbagliato lo si aggiunge
                if (!(CodiceFiscale.isCorret(codiceF)))      //al nuovo array
                    codici_invalidi.add(codiceF);
            }

            for(CodiceFiscale codice_dato: lista_codici) {     //se il codice fra quelli dati non corrisponde a nessuna
                if(!(codici_persone.contains(codice_dato)))      //allora lo mette nell'array degli spaiati
                    codici_spaiati.add(codice_dato);
            }

            writer.writeStartElement("codici");
            writer.writeStartElement("invalidi");
            writer.writeAttribute("numero", Integer.toString(codici_invalidi.size()));
            for(CodiceFiscale codiceF: codici_invalidi){
                writer.writeStartElement("codice");
                writer.writeCharacters(codiceF.codiceFiscaleIntero());
                writer.writeEndElement();                                   //chiude codice
            }
            writer.writeEndElement(); //chiusura tag invalidi

            writer.writeStartElement("spaiati");
            writer.writeAttribute("numero", Integer.toString(codici_spaiati.size()));
            for(CodiceFiscale codiceF: codici_spaiati){
                writer.writeStartElement("codice");
                writer.writeCharacters(codiceF.codiceFiscaleIntero());
                writer.writeEndElement();                               //chiude codice
            }
            writer.writeEndElement(); //chiusura tag spaiati

            writer.writeEndElement(); //chiude codici


            writer.writeEndElement(); // chiusura di output
            writer.writeEndDocument(); // scrittura fine documento
            writer.flush(); // svuota il buffer e procede alla scrittura
            writer.close(); // chiusura del documento e delle risorse impiegate


        } catch (Exception e) { // se c’è un errore viene eseguita questa parte
            System.out.println("Errore nella scrittura");

        }
    }
}

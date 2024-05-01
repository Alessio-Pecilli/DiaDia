package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
private String direzione;

public ComandoVai(String direzione) {
this.direzione = direzione;
}

/**
* esecuzione del comando
*/
@Override
public void esegui(Partita partita) {
	if(direzione==null)
		System.out.println("Dove vuoi andare ?");
	Stanza prossimaStanza = null;
	prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
	if (prossimaStanza == null)
		System.out.println("Direzione inesistente");
	else {
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		int cfu = partita.getCfu();
		partita.setCfu(cfu--);
	}
	System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
}


@Override
public void setParametro(String parametro) {
	this.direzione = parametro;
	
}

@Override
public String getNome() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String setNome(String nome) {
	// TODO Auto-generated method stub
	return null;
}
}
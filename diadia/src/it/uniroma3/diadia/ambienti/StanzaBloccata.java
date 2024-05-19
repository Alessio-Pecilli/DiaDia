package it.uniroma3.diadia.ambienti;

import java.util.HashSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{

	private String sblocca;
	private String dirBloc;
	public StanzaBloccata(String nome, String sblocca, String direzione) {
		super(nome);
		this.sblocca = sblocca;
		this.dirBloc = direzione;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		// TODO Auto-generated method stub
		boolean founded = false;
		HashSet<Attrezzo> attrezzi = super.getAttrezzi();
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(sblocca)){
				founded = true;
			}
		}
		if(founded) {
			return super.getStanzaAdiacente(direzione);
		}else {
			return this;
		}
	}
	
	@Override
	public String getDescrizione() {
		boolean founded = false;
		HashSet<Attrezzo> attrezzi = super.getAttrezzi();
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(sblocca)){
				founded = true;
			}
		}
		if(founded) {
			super.getDescrizione();
		}else {
			return new String("stanza bloccata");
		}
		return new String("stanza bloccata");
		
	}

}

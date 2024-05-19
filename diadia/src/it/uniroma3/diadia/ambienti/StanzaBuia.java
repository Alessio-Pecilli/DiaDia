package it.uniroma3.diadia.ambienti;

import java.util.HashSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	
	private String illuminante;

	public StanzaBuia(String nome,String illuminante) {
		super(nome);
		this.illuminante = illuminante;
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String getDescrizione() {
		boolean founded = false;
		HashSet<Attrezzo> attrezzi = super.getAttrezzi();
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(illuminante)){
				founded = true;
			}
		}
		if(founded) {
			super.getDescrizione();
		}else {
			return new String("qui c'è buio pesto");
		}
		return new String("qui c'è buio pesto");
		
	}

}

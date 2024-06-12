package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando implements Comando{

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio a = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(a == null) {
			System.out.println("Non e' presente nessun personaggio nella stanza corrente");
		}else {
			System.out.println("Detto ciao a " + a.getNome());
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}

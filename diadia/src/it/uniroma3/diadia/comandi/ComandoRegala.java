package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando implements Comando{
	
	Attrezzo attrezzo;
	String parametro;
	AbstractPersonaggio a;
	
	public ComandoRegala(String parametro) {
		this.parametro = parametro;
		}

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(parametro);
		a = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(a == null || attrezzo == null) {
			System.out.println("Nessun personaggio è presente nella stanza o non possiedi quell'attrezzo");
		}else {
		a.riceviRegalo(attrezzo, partita);}
		
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

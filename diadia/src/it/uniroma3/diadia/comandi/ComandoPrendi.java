package it.uniroma3.diadia.comandi;

import java.util.HashSet;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando implements Comando {
	
	String parametro;
	
	public ComandoPrendi(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public void esegui(Partita partita) {
		System.out.println(parametro);
		if(this.parametro == null) {
			System.out.println("Oggetto non specificato!");  
		}
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.parametro);
	
		if(a!= null && partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a)) {
			System.out.println(a.getNome() + " " + a.getPeso() + partita.getLabirinto().getStanzaCorrente().getDescrizione() + "------------");
			if(partita.getGiocatore().getBorsa().addAttrezzo(a)) {
				
				System.out.println("Oggetto aggiunto nella borsa e rimosso dalla stanza!");  
				
			}else 
			{
				System.out.println("Oggetto non aggiunto nella borsa, resta nella stanza!"); 
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			}
		}else {
			
			System.out.println(a + "Oggetto non rimosso dalla stanza!");  
		}

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Prendi";
	}



}

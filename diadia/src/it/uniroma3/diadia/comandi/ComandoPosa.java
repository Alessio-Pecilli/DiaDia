package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando implements Comando {
	String attrezzo;

	public ComandoPosa(String parametro) {
		// TODO Auto-generated constructor stub
		this.attrezzo = parametro;
	}

	@Override
	public void esegui(Partita partita) {

			if(attrezzo != null) {
				Attrezzo x = partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
				if(x == null) {
					System.out.println("Attrezzo non presente, impossibile rimuoverlo"); 
				}else {
					if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(x)) {
						System.out.println("Oggetto posato!"); 
					}
				}		
				
			}else {
				System.out.println("Attrezzo non presente, impossibile rimuoverlo"); 
			}

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Posa";
	}

}

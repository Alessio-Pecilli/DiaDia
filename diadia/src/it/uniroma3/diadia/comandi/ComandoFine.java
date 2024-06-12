package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando implements Comando {

	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato");
		System.exit(0);

	}

	

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Fine";
	}




	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

}

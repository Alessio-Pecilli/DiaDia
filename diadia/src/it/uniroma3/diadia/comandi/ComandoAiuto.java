package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando implements Comando{

	
	
	@Override
	public void esegui(Partita partita) {
			Comandi.mostraTuttiIValori();

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Aiuto";
	}

	

}

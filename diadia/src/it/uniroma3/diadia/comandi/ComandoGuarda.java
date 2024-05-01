package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		System.out.println(partita.getLabirinto().getStanzaCorrente().getNome() + " " + partita.getLabirinto().getStanzaCorrente().getDescrizione());
		System.out.println("CFU CORRENTI: " + partita.getGiocatore().getCFU());

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

	@Override
	public String setNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}

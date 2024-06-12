package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {

	
	public abstract void esegui(Partita partita);

	/**
	* set parametro del comando
	*/
	public abstract void setParametro(String parametro);

	public abstract String getNome();

}

package personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	
	private String nome;

	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	public String getNome() {
		return nome;
	}
}

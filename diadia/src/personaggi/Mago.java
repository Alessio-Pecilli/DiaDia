package personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		attrezzo.getPeso();
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo(attrezzo.getNome(),attrezzo.getPeso()/2));
		return "un mago riceve un regalo, gli dimezza il peso e lo lascia"
				+ "cadere nella stanza";
	}

}

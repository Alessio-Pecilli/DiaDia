package personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		int a = partita.getCfu();
		partita.setCfu(a-1);
		return "un cane riceve un regalo: accetta il suo cibo preferito, e butta"
				+ "a terra un attrezzo; ma morde e toglie un CFU per tutto il"
				+ "resto";
	}

}
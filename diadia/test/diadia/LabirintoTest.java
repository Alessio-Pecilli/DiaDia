package diadia;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

private Labirinto labirinto;
	
	@Before
	public void SetUp() {
		this.labirinto = new Labirinto();
		
		 Stanza atrio = new Stanza("Atrio");
	     Stanza biblioteca = new Stanza("Biblioteca");
	     this.labirinto.setStanzaCorrente(atrio);
	     this.labirinto.setUscita(biblioteca);
	}
	
	@Test
	public void testGetStanzaCorrenteIniziale() {
		Stanza atrio = new Stanza("Atrio");
		assertEquals(atrio.getNome(),this.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void tesGetStanzaVincente() {
		Stanza biblioteca = new Stanza("Biblioteca");
		assertEquals(biblioteca.getNome(),this.labirinto.getUscita().getNome());
	}
	
	
	
	

}

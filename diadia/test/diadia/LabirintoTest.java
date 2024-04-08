package diadia;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

public Labirinto labirinto;
	
	@Before
	public void SetUp() {
		this.labirinto = new Labirinto();
	}
	
	@Test
	public void testGetStanzaCorrenteIniziale() {
		Stanza atrio = new Stanza("Atrio");
		assertEquals(atrio,this.labirinto.getStanzaCorrente());
	}
	
	@Test
	public void tesGetStanzaVincente() {
		Stanza biblioteca = new Stanza("Biblioteca");
		assertEquals(biblioteca,this.labirinto.getUscita());
	}
	
	
	
	

}

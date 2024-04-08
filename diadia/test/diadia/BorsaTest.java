package diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	public Borsa borsa;
	@Before
	public void SetUp() {
		this.borsa = new Borsa();
	}
	
	@Test
	public void testBorsaEmpty() {
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	public void testVerificaPeso() {
		assertFalse(borsa.addAttrezzo(new Attrezzo("Prova",(borsa.getPesoMax() + 1))));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		assertEquals(null,borsa.removeAttrezzo("prova_non_presente"));
	}
	

}

package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	public Partita partita;
	
	@Before
	public void SetUp() {
		this.partita = new Partita();
	}
	
	
	
	@Test
	public void testFinita() {
		partita.setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testVittoria() {
		partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getUscita());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testSconfitta() {
		partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getEntrata());
		assertFalse(partita.vinta());
	}
	
		

}

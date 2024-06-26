package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza;
	
	@Before
	public void SetUp() {
		this.stanza = new Stanza("STANZA");
	}
	
	@Test
	public void testHasAttrezzoPresente() {
		this.stanza.addAttrezzo(new Attrezzo("computer",  50));
		assertTrue(this.stanza.hasAttrezzo("computer"));
	}
	
	@Test
	public void testHasAttrezzoNonPresente() {
		this.stanza.addAttrezzo(new Attrezzo("computer",  50));
		assertFalse(this.stanza.hasAttrezzo("padella"));
	}
	
	@Test
	public void testHasAttrezzoStanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("cellulare"));
	}
	
	@Test
	public void testGetStanzaAdiacenteEsistente() {
		Stanza adiacente = new Stanza("adiacente");
		stanza.impostaStanzaAdiacente("EST", adiacente);
		assertEquals(this.stanza.getStanzaAdiacente("EST"),adiacente);
	}
	
	@Test
	public void testGetStanzaAdiacenteNonEsistente() {
		assertNull(this.stanza.getStanzaAdiacente("SUD"));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		stanza.addAttrezzo(new Attrezzo("computer",50));
		assertFalse(this.stanza.removeAttrezzo(new Attrezzo("padella",70)));
	}
	
	@Test
	public void testRemoveAttrezzoPresente() {
		stanza.addAttrezzo(new Attrezzo("computer",50));
		assertTrue(this.stanza.removeAttrezzo(new Attrezzo("computer",50)));
	}


	@Test
	public void testRemoveAttrezzoStanzaVuota() {
		assertFalse(this.stanza.removeAttrezzo(new Attrezzo("computer",50)));
	}

	
	
	
	
	

}

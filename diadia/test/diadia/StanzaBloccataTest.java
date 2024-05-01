package diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaAdiacente;
    private Attrezzo attrezzoSblocco;

    @Before
    public void setUp() {
        stanzaAdiacente = new Stanza("Stanza Adiacente");
        stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "chiave", "nord");
        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
        
        attrezzoSblocco = new Attrezzo("chiave", 1); // attrezzo che sblocca la stanza
        stanzaBloccata.addAttrezzo(attrezzoSblocco);
    }

    @Test
    public void testGetStanzaAdiacenteSbloccata() {
        Stanza result = stanzaBloccata.getStanzaAdiacente("nord");
        assertEquals(stanzaAdiacente, result);
    }

    @Test
    public void testGetStanzaAdiacenteBloccata() {
        Stanza result = stanzaBloccata.getStanzaAdiacente("sud");
        assertEquals(stanzaBloccata, result);
    }

    @Test
    public void testGetDescrizioneSbloccata() {
        String result = stanzaBloccata.getDescrizione();
        assertEquals("Stanza Bloccata", result);
    }

    @Test
    public void testGetDescrizioneBloccata() {
        stanzaBloccata.removeAttrezzo(attrezzoSblocco);
        String result = stanzaBloccata.getDescrizione();
        assertEquals("stanza bloccata", result);
    }
}

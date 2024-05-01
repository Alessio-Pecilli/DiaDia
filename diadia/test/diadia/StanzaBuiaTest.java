package diadia;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;
    private Attrezzo illuminante;

    @Before
    public void setUp() {
        stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
        
        illuminante = new Attrezzo("lanterna", 1); // attrezzo che illumina la stanza
        stanzaBuia.addAttrezzo(illuminante);
    }

    @Test
    public void testGetDescrizioneIlluminata() {
        String result = stanzaBuia.getDescrizione();
        assertEquals("Stanza Buia", result);
    }

    @Test
    public void testGetDescrizioneBuia() {
        stanzaBuia.removeAttrezzo(illuminante);
        String result = stanzaBuia.getDescrizione();
        assertEquals("qui c'è buio pesto", result);
    }

    @Test
    public void testGetDescrizioneNessunAttrezzo() {
        stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
        String result = stanzaBuia.getDescrizione();
        assertEquals("qui c'è buio pesto", result);
    }
}

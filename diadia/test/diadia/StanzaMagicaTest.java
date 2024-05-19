package diadia;


import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

    private StanzaMagica stanzaMagica;

    @Before
    public void setUp() {
        stanzaMagica = new StanzaMagica("Magica", 3);
    }

    @Test
    public void testAddAttrezzoNormale() {
        Attrezzo attrezzo = new Attrezzo("chiave", 2);
        assertTrue(stanzaMagica.addAttrezzo(attrezzo));
        assertEquals(attrezzo, stanzaMagica.getAttrezzo("chiave"));
    }

    @Test
    public void testComportamentoMagico() {
        Attrezzo attrezzo1 = new Attrezzo("chiave", 2);
        Attrezzo attrezzo2 = new Attrezzo("libro", 3);
        Attrezzo attrezzo3 = new Attrezzo("penna", 1);

        assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
        assertEquals(new Attrezzo("evaihc", 4), stanzaMagica.getAttrezzo("evaihc"));

        assertTrue(stanzaMagica.addAttrezzo(attrezzo2));
        assertEquals(new Attrezzo("orbil", 6), stanzaMagica.getAttrezzo("orbil"));

        assertTrue(stanzaMagica.addAttrezzo(attrezzo3));
        assertEquals(new Attrezzo("annep", 2), stanzaMagica.getAttrezzo("annep"));
    }

    @Test
    public void testSogliaMagica() {
        Attrezzo attrezzo1 = new Attrezzo("chiave", 2);
        Attrezzo attrezzo2 = new Attrezzo("libro", 3);
        Attrezzo attrezzo3 = new Attrezzo("penna", 1);

        assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo2));

        assertFalse(stanzaMagica.addAttrezzo(attrezzo3));
        assertNull(stanzaMagica.getAttrezzo("penna"));
    }
}

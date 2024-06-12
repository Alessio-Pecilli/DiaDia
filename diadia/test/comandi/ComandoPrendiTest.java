package comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {
    private Partita partita;

    @Before
    public void setUp() {
        // Initialize Partita object for testing
        partita = new Partita(null);
        // Initialize any other objects needed for testing
    }

    @Test
    public void testEsegui_AttrezzoPresent() {
        // Add an Attezzo to the current stanza
        Attrezzo attrezzo = new Attrezzo("Martello", 5);
        partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);

        // Create ComandoPrendi object
        ComandoPrendi comando = new ComandoPrendi("Martello");

        // Execute the method under test
        comando.esegui(partita);

        // Assert that the Attezzo has been removed from the current stanza
        assertNull(partita.getLabirinto().getStanzaCorrente().getAttrezzo("Martello"));
        // Assert that the Attezzo has been added to the player's borsa
        assertNotNull(partita.getGiocatore().getBorsa().getAttrezzo("Martello"));
        // Add more assertions if needed
    }

    @Test
    public void testEsegui_AttrezzoNotPresent() {
        // Create ComandoPrendi object for an Atrezzo that is not present in the stanza
        ComandoPrendi comando = new ComandoPrendi("Pala");

        // Execute the method under test
        comando.esegui(partita);

        // Assert that the message "Oggetto non rimosso dalla stanza!" is printed
        // You need to capture the printed message to assert it, you can use ByteArrayOutputStream for this purpose.
        // Add more assertions if needed
    }

    // Add more test methods for different scenarios
}

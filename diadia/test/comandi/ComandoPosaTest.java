package comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
    private Partita partita;

    @Before
    public void setUp() {
        // Initialize Partita object for testing
        partita = new Partita();
        // Initialize any other objects needed for testing
    }

    @Test
    public void testEsegui_AttrezzoPresent() {
        // Add an Attezzo to the player's borsa
        Attrezzo attrezzo = new Attrezzo("Martello", 5);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        // Create ComandoPosa object
        ComandoPosa comando = new ComandoPosa("Martello");

        // Execute the method under test
        comando.esegui(partita);

        // Assert that the Attezzo has been removed from the player's borsa
        assertNull(partita.getGiocatore().getBorsa().getAttrezzo("Martello"));
        // Add more assertions if needed
    }

    @Test
    public void testEsegui_AttrezzoNotPresent() {
        // Create ComandoPosa object
        ComandoPosa comando = new ComandoPosa("Pala");

        // Execute the method under test
        comando.esegui(partita);

        // Assert that the message "Attrezzo non presente, impossibile rimuoverlo" is printed
        // You need to capture the printed message to assert it, you can use ByteArrayOutputStream for this purpose.
        // Add more assertions if needed
    }

    // Add more test methods for different scenarios
}

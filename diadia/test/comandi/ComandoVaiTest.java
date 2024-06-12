package comandi;

import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

    @Test
    public void testEseguiSenzaDirezione() {
        Partita partita = new Partita(null);
        partita.getLabirinto().setStanzaCorrente(new Stanza("Stanza A"));
        ComandoVai comandoVai = new ComandoVai(null);
        comandoVai.esegui(partita);
        assertEquals("La stanza corrente non dovrebbe cambiare", "Stanza A", partita.getLabirinto().getStanzaCorrente().getNome());
    }

}

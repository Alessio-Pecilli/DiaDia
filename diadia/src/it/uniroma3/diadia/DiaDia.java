package it.uniroma3.diadia;



import java.io.Console;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {
	private IO IOconsole;
	private Labirinto labirinto;

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	

	private Partita partita;

	
	public DiaDia(Labirinto l, IO ioConsole) {
		this.partita = new Partita(l);
		this.labirinto = l;
		this.IOconsole = ioConsole;
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		this.IOconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
			
		do		
			istruzione = IOconsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   
	
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())
			System.out.println("Hai vinto!");
		if (this.partita.getGiocatore().getCFU() == 0)
			System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
		}


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	/*private boolean processaIstruzioneOLD(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("lista"))
			this.IOconsole.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString()); 
		else if(comandoDaEseguire.getNome().equals("prendi")) {
			
			Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(comandoDaEseguire.getParametro());
			
			this.prendi(a, partita);
			
		}
		else if(comandoDaEseguire.getNome().equals("posa")) {
			Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(comandoDaEseguire.getParametro());
			
			this.posa(a, partita);
		}
		else
			this.IOconsole.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.IOconsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   */

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/*private void vai(String direzione) {
		if(direzione==null)
			this.IOconsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.IOconsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu--);
		}
		this.IOconsole.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	private void posa(Attrezzo attrezzo, Partita partita) {
		if(attrezzo != null) {
			Attrezzo x = partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			if(x == null) {
				this.IOconsole.mostraMessaggio("Attrezzo non presente, impossibile rimuoverlo"); 
			}else {
				this.IOconsole.mostraMessaggio("Attrezzo rimosso"); 
			}
			if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(x)) {
				
			}
			this.IOconsole.mostraMessaggio("Oggetto posato!"); 
		}else {
			this.IOconsole.mostraMessaggio("Attrezzo non presente, impossibile rimuoverlo"); 
		}
	}*/

	public static void main(String[] argc) {
	    IO io = new IOConsole();

	    Labirinto labirinto = Labirinto.newBuilder()
	            .addStanzaIniziale("Atrio")
	            .addAttrezzo("martello", 3)
	            .addStanzaVincente("Biblioteca")
	            .addAdiacenza("Atrio", "Biblioteca", "nord")
	            .getLabirinto();
	    
	    DiaDia gioco = new DiaDia(labirinto, io);
	    
	    gioco.gioca();
	}
}
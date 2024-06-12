package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Labirinto {
    private Stanza entrata;
    private Stanza uscita;

    private Stanza stanzaCorrente;
    private Giocatore giocatore;
    private Stanza stanzaVincente;

    // Rendi il costruttore privato
    private Labirinto() {
        creaStanze();
    }

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaStanze() {

        /* crea gli attrezzi */
        Attrezzo lanterna = new Attrezzo("lanterna", 3);
        Attrezzo osso = new Attrezzo("osso", 1);

        /* crea stanze del labirinto */
        Stanza atrio = new Stanza("Atrio");
        Stanza aulaN11 = new Stanza("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new Stanza("Laboratorio Campus");
        Stanza biblioteca = new Stanza("Biblioteca");

        /* collega le stanze */
        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        atrio.impostaStanzaAdiacente("ovest", laboratorio);
        aulaN11.impostaStanzaAdiacente("est", laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);
        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est", aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
        laboratorio.impostaStanzaAdiacente("est", atrio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
        biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);

        // il gioco comincia nell'atrio
        this.entrata = atrio;
        this.stanzaCorrente = atrio;
        this.uscita = biblioteca;
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }

    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    public Stanza getUscita() {
        return uscita;
    }

    public Stanza getEntrata() {
        return entrata;
    }

    public void setUscita(Stanza uscita) {
        this.uscita = uscita;
    }

    public Stanza getStanzaVincente() {
        return stanzaVincente;
    }

    public void setStanzaVincente(Stanza stanzaVincente) {
        this.stanzaVincente = stanzaVincente;
    }

    // Factory method statico e pubblico
    public static LabirintoBuilder newBuilder() {
        return new LabirintoBuilder();
    }

    // Classe statica nidificata
    public static class LabirintoBuilder {

        private Labirinto labirinto;
        private Stanza ultimaStanzaAggiunta;
        private Map<String, Stanza> nome2stanza;

        private LabirintoBuilder() {
            this.labirinto = new Labirinto();
            this.nome2stanza = new HashMap<String, Stanza>();
        }

        public Map<String, Stanza> getNome2stanza() {
            return nome2stanza;
        }

        public LabirintoBuilder setNome2stanza(Map<String, Stanza> a) {
            this.nome2stanza = a;
            return this;
        }

        public Labirinto getLabirinto() {
            return this.labirinto;
        }

        public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
            Stanza i = new Stanza(stanzaIniziale);
            this.labirinto.setStanzaCorrente(i);
            this.UltimaStanzaAggiuntaEAggiorna(i);
            return this;
        }

        public LabirintoBuilder addStanzaIniziale(Stanza stanzaIniziale) {
            this.labirinto.setStanzaCorrente(stanzaIniziale);
            return this;
        }

        public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
            Stanza s = new Stanza(stanzaVincente);
            this.labirinto.setStanzaVincente(s);
            this.UltimaStanzaAggiuntaEAggiorna(s);
            return this;
        }

        public LabirintoBuilder addStanzaVincente(Stanza stanzaVincente) {
            this.labirinto.setStanzaVincente(stanzaVincente);
            return this;
        }

        public LabirintoBuilder addStanza(String stanza) {
            Stanza s = new Stanza(stanza);
            this.UltimaStanzaAggiuntaEAggiorna(s);
            return this;
        }

        public LabirintoBuilder addStanza(Stanza stanza) {
            this.UltimaStanzaAggiuntaEAggiorna(stanza);
            return this;
        }

        public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
            Attrezzo a = new Attrezzo(attrezzo, peso);
            if (this.ultimaStanzaAggiunta == null)
                return this;
            this.ultimaStanzaAggiunta.addAttrezzo(a);
            return this;
        }

        public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, String direzione) {
            Stanza c = this.nome2stanza.get(stanzaCorrente);
            Stanza a = this.nome2stanza.get(stanzaAdiecente);
            c.impostaStanzaAdiacente(direzione, a);
            return this;
        }

        public LabirintoBuilder addAdiacenza(Stanza stanzaCorrente, Stanza stanzaAdiecente, String direzione) {
            stanzaCorrente.impostaStanzaAdiacente(direzione, stanzaAdiecente);
            return this;
        }

        public LabirintoBuilder addStanzaMagica(String nome) {
            Stanza stanza = new StanzaMagica(nome);
            this.UltimaStanzaAggiuntaEAggiorna(stanza);
            return this;
        }

        public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
            Stanza stanza = new StanzaBuia(nome, attrezzoPerVedere);
            this.UltimaStanzaAggiuntaEAggiorna(stanza);
            return this;
        }

        public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
            Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
            this.UltimaStanzaAggiuntaEAggiorna(stanza);
            return this;
        }

        private void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
            this.ultimaStanzaAggiunta = stanza;
            this.nome2stanza.put(stanza.getNome(), stanza);
        }
    }
}

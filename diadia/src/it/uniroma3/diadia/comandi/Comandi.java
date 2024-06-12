package it.uniroma3.diadia.comandi;

public enum Comandi {
	VAI, PRENDI, POSA, AIUTO, FINE, GUARDA, SALUTA, INTERAGISCI ,NON_VALIDO, REGALA ;

	public static Comandi fromString(String nomeComando) {
        try {
            return Comandi.valueOf(nomeComando.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NON_VALIDO;
        }
    }
	
	public static void mostraTuttiIValori() {
        for (Comandi comando : Comandi.values()) {
            System.out.println(comando);
        }
    }
}

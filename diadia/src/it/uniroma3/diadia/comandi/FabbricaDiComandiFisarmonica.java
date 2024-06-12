package it.uniroma3.diadia.comandi;

import java.util.Scanner;

 public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
 @Override
 public Comando costruisciComando(String istruzione) {
 Scanner scannerDiParole = new Scanner(istruzione);
 String nomeComando = null;
 String parametro = null;
 Comando comando = null;
 
 if (scannerDiParole.hasNext())
	 nomeComando = scannerDiParole.next();// prima parola: nome del comando
 if (scannerDiParole.hasNext())
 parametro = scannerDiParole.next(); // seconda parola: eventuale param.

 Comandi comandoEnum = Comandi.fromString(nomeComando);
 
 switch (comandoEnum) {
 case VAI:
     comando = new ComandoVai(parametro);
     break;
 case PRENDI:
     comando = new ComandoPrendi(parametro);
     break;
 case POSA:
     comando = new ComandoPosa(parametro);
     break;
 case AIUTO:
     comando = new ComandoAiuto();
     break;
 case FINE:
     comando = new ComandoFine();
     break;
 case GUARDA:
     comando = new ComandoGuarda();
     break;
 case REGALA:
	 comando = new ComandoRegala(parametro);
	 break;
 case INTERAGISCI:
	 comando = new ComandoInteragisci(parametro);
	 break;
 case SALUTA:
	 comando = new ComandoSaluta();
	 break;
 case NON_VALIDO:
 default:
     comando = new ComandoNonValido();
     break;
}

comando.setParametro(parametro);
return comando;
}

 

	
 	}
 


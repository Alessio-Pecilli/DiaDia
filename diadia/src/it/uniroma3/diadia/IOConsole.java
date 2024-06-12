package it.uniroma3.diadia;
import java.util.Scanner;
public class IOConsole implements IO{
	
	public void mostraMessaggio(String msg) {
			System.out.println(msg);
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = new String("");
		try {	
		riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close(); 
		}catch (Exception e) {
			scannerDiLinee.close();
		}
			return riga;
		
		
		}
	}
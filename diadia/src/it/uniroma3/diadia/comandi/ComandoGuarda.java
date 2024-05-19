package it.uniroma3.diadia.comandi;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		System.out.println(partita.getLabirinto().getStanzaCorrente().getNome() + " " + partita.getLabirinto().getStanzaCorrente().getDescrizione());
		System.out.println("CFU CORRENTI: " + partita.getGiocatore().getCFU());
		StringBuilder s = new StringBuilder();
		s.append("[");//List []
		for(Attrezzo x : partita.getGiocatore().getBorsa().getContenutoOrdinatoPerPeso()) {
			if(x != null && !(s.equals("["))){
				s.append(", ");
			}
			s.append(x.getNome());
		}
		s.append(" ]");
		
		System.out.print(s);
		
		s = new StringBuilder();
		s.append("{");//Set {}
		for(Attrezzo x : partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome()) {
			if(x != null && !(s.equals("{"))){
				s.append(", ");
			}
			s.append(x.getNome());
		}s.append(" }");
		
		System.out.print(s);
		
		Set<Attrezzo> a = new HashSet<Attrezzo>();
 		s = new StringBuilder();
		Map<Integer, Set<Attrezzo>> map = partita.getGiocatore().getBorsa().getContenutoRaggruppatoPerPeso();
		for(Integer x : map.keySet()) {
			s.append("(" + x + ", { ");
			a = map.get(x);
			for(Attrezzo b : a) {
				s.append(b.getNome() + " ");
			}
			s.append(" } )");
			//s.append(x.getNome());
		}
		
		System.out.print(s);

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}

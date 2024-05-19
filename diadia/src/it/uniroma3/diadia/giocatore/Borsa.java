package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
    public final static int DEFAULT_PESO_MAX_BORSA = 10;
    private ArrayList<Attrezzo> attrezzi;
    private int pesoMax;
    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }
    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new ArrayList<Attrezzo>(); // speriamo bastino...
    }
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
            return false;
        if (this.attrezzi.size() == 10)
            return false;
        attrezzi.add(attrezzo);
        return true;
    }
    public int getPesoMax() {
        return pesoMax;
    }
    
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        Attrezzo a = null;
        for (Attrezzo x : attrezzi)
            if (x != null && x.getNome().equals(nomeAttrezzo))
                a = x;

        return a;
    }
    public int getPeso() {
        int peso = 0;
        for (Attrezzo y : attrezzi)
        	if(y != null)
        		peso += y.getPeso();

        return peso;
    }
    
    public boolean isEmpty() {
        return this.attrezzi.isEmpty();
    }
    
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }
    
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        Attrezzo a = null;
        int b = attrezzi.indexOf(new Attrezzo(nomeAttrezzo,0));
        if(b != -1) {
        	a = attrezzi.get(b);
        	attrezzi.remove(new Attrezzo(nomeAttrezzo,0));
        }
        return a;
    }
    
    public List<Attrezzo> getContenutoOrdinatoPerPeso() {
    	List<Attrezzo> copia = attrezzi;
    	Collections.sort(copia, new Comparator<Attrezzo>() {

			@Override
			public int compare(Attrezzo o1, Attrezzo o2) {
				int c = Integer.compare(o1.getPeso(),o2.getPeso());
				if(c == 0) {
					c = o1.compareTo(o2);
				}
				return c;
			}
		});
		return copia;
	}
    
    public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
    	SortedSet<Attrezzo> a = new TreeSet<Attrezzo>(attrezzi);
    	return a;
    }
    
    public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
    	Map<Integer,Set<Attrezzo>> map = new HashMap<Integer,Set<Attrezzo>>();
    	ArrayList<Attrezzo> copia = attrezzi;
    	HashSet<Attrezzo> mSet = new HashSet<Attrezzo>();
    	int peso;
    	copia.sort(new Comparator<Attrezzo>() {

    		@Override
			public int compare(Attrezzo o1, Attrezzo o2) {
				int c = Integer.compare(o1.getPeso(),o2.getPeso());
				return c;
			}
		});
    	
    	for(int i = 0;i < copia.size()-1;i++) {
    		mSet = new HashSet<Attrezzo>();
    		peso = copia.get(i).getPeso();
    		do {
    			mSet.add(copia.get(i));
    			i++;
    		}while(copia.get(i+1) != null && copia.get(i+1).getPeso() == peso && i< copia.size()-1);
    		map.put(peso, mSet);
    		
    	}
    	return map;
    }
    
    public String tosdaString() {
        StringBuilder s = new StringBuilder();

        if (!this.isEmpty()) {
            s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
            for (int i = 0; i < this.attrezzi.size(); i++)
                s.append(attrezzi.get(i).toString() + " ");
        } else
            s.append("Borsa vuota");
        return s.toString();
    }
}
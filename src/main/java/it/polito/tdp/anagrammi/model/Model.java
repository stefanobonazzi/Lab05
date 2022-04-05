package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class Model {

	private AnagrammiDAO anagrammiDAO = new AnagrammiDAO();
	private Set<String> corretti = new HashSet<String>();
	private Set<String> errati = new HashSet<String>();

	public void anagramma(String s) {
		corretti.clear();
		errati.clear();
		anagramma_ricorsiva("", 0, s);
	}
	
	public void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if(rimanenti.length() == 0) {
			if(anagrammiDAO.isCorrect(parziale))
				corretti.add(parziale);
			else
				errati.add(parziale);
		} else {
			for(int pos=0; pos<rimanenti.length(); pos++) {
				String new_parziale = parziale+rimanenti.charAt(pos);
				String new_rimanenti = rimanenti.substring(0,pos)+rimanenti.substring(pos+1);
				anagramma_ricorsiva(new_parziale, livello+1, new_rimanenti);
			}
		}
	}

	public Set<String> getCorretti() {
		return corretti;
	}

	public Set<String> getErrati() {
		return errati;
	}
	
}

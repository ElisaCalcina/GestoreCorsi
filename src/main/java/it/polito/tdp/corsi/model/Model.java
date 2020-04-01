package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
		private CorsoDAO dao;
		
	public Model() {
		this.dao= new CorsoDAO();
	}
	
	public boolean esisteCorso(String codins) {
		return dao.esisteCorso(codins);
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		//CorsoDAO dao= new CorsoDAO();
		return dao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso, Integer> getIscrittiByPeriodo(Integer pd){
		//CorsoDAO dao= new CorsoDAO();
		return dao.getIscrittiByPeriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(Corso corso){
		return dao.getStudentiByCorso(corso);
	}
	
	public Map<String, Integer> getDivisioneCDS(Corso corso){
		//prima soluzione
		/*List<Studente> studenti= dao.getStudentiByCorso(corso);

		Map<String, Integer> statistiche= new HashMap<String,Integer>(); //hashMap perchè ha chiavi univoche
		for(Studente s: studenti) {
			if(s.getCDS()!= null && !s.getCDS().equals("")) {
			if(statistiche.containsKey(s.getCDS())) {
				statistiche.put(s.getCDS(), statistiche.get(s.getCDS())+1);
			}else {
				statistiche.put(s.getCDS(), 1);
				}
			}
		}
		return statistiche;*/
	//Seconda soluzione--> passo dal dao perchè devo implementare la query
		return dao.getDivisioneCDS(corso);
		//il controller in questo caso rimane lo stesso
	}
}

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;



public class Annee {
	private int annee;
	private ArrayList<Epreuve> epreuve;

Annee(String annee) {
	this.setAnnee(Integer.parseInt(annee));
	epreuve = new ArrayList<Epreuve>();
}

public int getAnnee() {
	return annee;
}

public void setAnnee(int annee) {
	this.annee = annee;
}

public boolean contient(String string) {
	return epreuve.contains(string);
}

public void addEpreuve(String[] items) {
	epreuve.add(new Epreuve(items[7],Integer.parseInt(items[7])));
}

public void addParticipation(String[] items) {
	for (int i=0; i<epreuve.size(); i++) {
		if (epreuve.get(i).getNomCourse().equalsIgnoreCase(items[7])) {
			epreuve.get(i).addParticipants(items);
		}
	}
}
	
}








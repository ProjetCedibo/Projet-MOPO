import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;



public class Annee {
	private int annee;
	private ArrayList <Epreuve> epreuve;

Annee(String annee) {
	this.setAnnee(Integer.parseInt(annee));
	epreuve = new ArrayList<Epreuve>();
	epreuve.add(new Epreuve("25CTF",25)); 
	epreuve.add(new Epreuve("25CTM",25));
	epreuve.add(new Epreuve("25FTF",25));
	epreuve.add(new Epreuve("25FTM",25));
	epreuve.add(new Epreuve("50CTF",50));
	epreuve.add(new Epreuve("50CTM",50));
	epreuve.add(new Epreuve("76FTF",76));
	epreuve.add(new Epreuve("76FTM",76));

}

public Epreuve getEpreuve(String str) {
	for (int i =0;i<epreuve.size();i++) {
		if (epreuve.get(i).getNomCourse().equalsIgnoreCase(str)) {
		return epreuve.get(i);
		}
		
	}
	return null;
}



public int getAnnee() {
	return annee;
}

public void setAnnee(int annee) {
	this.annee = annee;
}

public boolean contient(String items) {
	Epreuve tmp = new Epreuve(items,Integer.parseInt(items.substring(0,2)));
	System.out.println("Je suis : "+tmp);
	return epreuve.contains(tmp);
}

/*public void addEpreuve(String[] items) {
	epreuve.add(new Epreuve(items[7],Integer.parseInt(items[7].substring(0,2))));
}*/

public void addParticipation(String[] items) {
	for (int i=0; i<epreuve.size(); i++) {
		if (epreuve.get(i).getNomCourse().equalsIgnoreCase(items[7])) {
			epreuve.get(i).addParticipants(items);
		}
	}
}
	
public String toString() {
	String str = "";	
	str = "\n" + getAnnee() + "\n";
	for (Epreuve ep : epreuve) {
		str = str + " " + ep.toString();
		
		}
	return str;
}

}








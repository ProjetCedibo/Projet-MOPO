import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


/**
 * Class permettant de stocker les épreuves qui ont eu lieues durant l'année
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
public class Annee {
	private int annee;
	private ArrayList <Epreuve> epreuve;

/**
 * Constucteur
 * @param annee l'année des épreuves à enregistrer
 */
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


/**
 * Fonction permettant de rechercher les informations sur une épreuve
 * @param str le nom de l'épreuve que l'on cherche
 * @return l'epreuve qui correspond à la recherche
 */
public Epreuve getEpreuve(String str) {
	for (int i =0;i<epreuve.size();i++) {
		if (epreuve.get(i).getNomCourse().equalsIgnoreCase(str)) {
		return epreuve.get(i);
		}
		
	}
	return null;
}



/**
 * Getter sur l'année
 * @return l'année 
 */
public int getAnnee() {
	return annee;
}


/**
 * Setter sur l'année
 * @param année
 */
public void setAnnee(int annee) {
	this.annee = annee;
}


/**
 * Fonction permettant d'ajouter un participant à une épreuve
 * @param items
 */
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








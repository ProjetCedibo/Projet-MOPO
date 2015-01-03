/**
 * Classe permettant de stocker les informations sur les participations des participants
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
public class Participation {

	
	private int dossard;
	private int classement;
	private String categorie;
	private String arrivee;
	private String classement_cat;
	private String epreuve;
	private int annee;
	private Participants p;
	
	/**
	 * Constructeur
	 * @param infos Tableau contenant les informations sur une participation
	 * @param an
	 */
	Participation (String infos [],int an) {
		this.dossard = Integer.parseInt(infos[0]);
		this.classement = Integer.parseInt(infos[1]);
		this.arrivee = infos[6];
		this.categorie = infos[8];
		this.classement_cat=infos[9];	
		this.epreuve = infos[7];
		this.annee = an;
		p = new Participants(infos);
	}


/**
 * Getter sur le dossard
 * @return le numéro de dossard
 */
public int getDossard() {
	return dossard;
}


/**
 * Getter sur le classement
 * @return la position au classement
 */
public int getClassement() {
	return classement;
}


/**
 * Getter sur la catégorie
 * @return la catégorie
 */
public String getCategorie() {
	return categorie;
}


/**
 * Getter sur l'arrivée
 * @return le temps
 */
public int getArrivee() {
	String [] arr = arrivee.split("[^0123456789]");
    return (Integer.parseInt(arr[0])*3600)+(Integer.parseInt(arr[1])*60)+Integer.parseInt(arr[2]);
}


/**
 * Getter sur le classement dans sa catégorie
 * @return la position au classement
 */
public String getClassement_cat() {
	return classement_cat;
}

	
public String toString() {
	return getDossard() + " " + getClassement() + " " + getArrivee() + " " + getCategorie() + " " + getClassement_cat() + "\n";
}


/**
 * Getter sur le participant
 * @return le participant 
 */
public Participants getP() {
	return p;
}


/**
 * Getter sur l'épreuve
 * @return le nom de l'épreuve
 */
public String getEpreuve() {
	return epreuve;
}


public int getannee() {
	return annee;
} 

}

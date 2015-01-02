
public class Participation {

	
	private int dossard;
	private int classement;
	private String categorie;
	private String arrivee;
	private String classement_cat;
	private String epreuve;
	private int annee;
	private Participants p;
	
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


public int getDossard() {
	return dossard;
}


public void setDossard(int dossard) {
	this.dossard = dossard;
}


public int getClassement() {
	return classement;
}


public void setClassement(int classement) {
	this.classement = classement;
}


public String getCategorie() {
	return categorie;
}


public void setCategorie(String categorie) {
	this.categorie = categorie;
}


public int getArrivee() {
	String [] arr = arrivee.split("[^0123456789]");
    return (Integer.parseInt(arr[0])*3600)+(Integer.parseInt(arr[1])*60)+Integer.parseInt(arr[2]);
}


public void setArrivee(String arrivee) {
	this.arrivee = arrivee;
}

public String getClassement_cat() {
	return classement_cat;
}

public void setClassement_cat(String classement_cat) {
	this.classement_cat = classement_cat;
}	
	
public String toString() {
	return getDossard() + " " + getClassement() + " " + getArrivee() + " " + getCategorie() + " " + getClassement_cat() + "\n";
}


public Participants getP() {
	return p;
}


public void setP(Participants p) {
	this.p = p;
}


public String getEpreuve() {
	return epreuve;
} 



}

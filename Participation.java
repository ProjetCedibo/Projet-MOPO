
public class Participation {

	
	private int dossard;
	private int classement;
	private String categorie;
	private String arrivee;
	private String classement_cat;
	
	Epreuve ep = new Epreuve();
	
	Participation (String infos []) {
		this.dossard = Integer.parseInt(infos[0]);
		this.classement = Integer.parseInt(infos[1]);
		this.arrivee = infos[6];
		this.categorie = infos[8];
		this.classement_cat=infos[9];	
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


public String getArrivee() {
	return this.arrivee;
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
	
}

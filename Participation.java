
public class Participation {

	
	private int Dossard;
	private int Classement;
	private String Categorie;
	
	
	static class Arrivee {
		int heure=0;
		int minute=0;
		int seconde=0;
		int dixième=0;
	};

	Epreuve Ep = new Epreuve();
	
	
Arrivee A = new Arrivee();




public int getDossard() {
	return Dossard;
}


public void setDossard(int dossard) {
	Dossard = dossard;
}


public int getClassement() {
	return Classement;
}


public void setClassement(int classement) {
	Classement = classement;
}


public String getCategorie() {
	return Categorie;
}


public void setCategorie(String categorie) {
	Categorie = categorie;
}	
	
}

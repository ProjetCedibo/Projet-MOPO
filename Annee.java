import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;



public class Annee implements Comparable<Epreuve> {
	private int annee;
	List epreuve;

Annee(String annee) {
	this.setAnnee(Integer.parseInt(annee));
	ArrayList<Epreuve> epreuve = new ArrayList<Epreuve>();
}

/*
 * Je voulais comparer le nom des epreuve
 */
public int compareTo(Epreuve o) {

	return 0;
}


public int getAnnee() {
	return annee;
}


public void setAnnee(int annee) {
	this.annee = annee;
}






}

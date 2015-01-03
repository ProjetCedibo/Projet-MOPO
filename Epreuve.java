import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Classe permettant le stockage des informations d'une épreuve
 * Elle contient une liste de participants, le nom de l'épreuve et la distance
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
public class Epreuve {
	ArrayList <Participants> Coureurs;
	private int distance;
	private String nomCourse;
	
	/**
	 * Constructeur
	 * @param nomCourse C'est le nom de l'épreuve ex : 76FTM
	 * @param distance  C'est la distance de l'épreuve ex : 76km
	 */
	Epreuve(String nomCourse, int distance){
		Coureurs = new ArrayList<Participants>();
		this.nomCourse = nomCourse;
		this.distance = distance;
	}
	

	/**
	 * Fonction permettant l'ajout d'un participant à l'epreuve
	 * @param items C'est un tableau qui contient toutes les informations pour ajouter une participation
	 */
	public void addParticipants(String items []){
		Coureurs.add(new Participants(items,1));
		Collections.sort(Coureurs);
	}
	
	
	  public Participants getFirst(){
	    Collections.sort(Coureurs);
	    return Coureurs.get(0);
	  }
	

	/**
	 * Getter de la distance
	 * @return distance
	 */
	public int getDistance() {
		return distance;
	}
	
	
	/**
	 * Getter du nom de la course
	 * @return le nom de la course 
	 */
	public String getNomCourse() {
		return nomCourse;
	}
	
	
	/**
	 * Fonction permettant de connaître le nombre de participants à l'épreuve
	 * @return le nombre de participants
	 */
	public int nombreParticipant(){
		return Coureurs.size();
	}
	
	/**
	 * Fonction permettant de connaître la moyenne du temps mis pour finir l'épreuve
	 * @return la moyenne du temps
	 */
	public String DureeMoyenne(){
		double moyenne = 0.0;
	    
	    for(int i = 0; i<Coureurs.size();i++){
	    	Participants tmp = Coureurs.get(i);
			moyenne = moyenne + (double)(tmp.getArrivee(nomCourse));
		}
	    moyenne = moyenne / (double)(Coureurs.size());
	    String heures   = String.valueOf((int)(moyenne/3600));
	    String minutes  = String.valueOf((int)((moyenne % 3600) / 60));
	    String secondes = String.valueOf((int)((moyenne % 3600) % 60));

	    return heures + "h " + minutes + "min " + secondes + "s";
		}

	public boolean Exist(){
		if(Coureurs.size()>0){
			return true;
		}
		return false;
	}
	
	public String toString() {
		String str = "";	
		str = getNomCourse() + "\n";
		
		Iterator<Participants> it;
	    it = Coureurs.iterator();
	    
	    while (it.hasNext()){
	    	Participants tmp = it.next();
	    	str = str + tmp.toString();

	    }
		return str;
	}	
	
	

	
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Class permettant le stockage des information d'une epreuve
 * elle contient une list de participant, le nom de l'épreuve et la distance
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
	 * @param nomCourse C'est le nom de l'epreuve ex : 76FTM
	 * @param distance  C'est la distande de l'epreuve ex : 76km
	 */
	Epreuve(String nomCourse, int distance){
		Coureurs = new ArrayList<Participants>();
		this.nomCourse = nomCourse;
		this.distance = distance;
	}
	

	/**
	 * Fonction permettant l'ajout d'un participant a l'epreuve
	 * @param items C'est un tableau qui contient toutes les information pour ajouter une participation
	 */
	public void addParticipants(String items []){
		Coureurs.add(new Participants(items, 1));
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
	 * @return le nom de la cours 
	 */
	public String getNomCourse() {
		return nomCourse;
	}
	
	
	/**
	 * Fonction permattant de connaitre le nombre de participant a l'epreuve
	 * @return le nombre de participant
	 */
	public int nombreParticipant(){
		return Coureurs.size();
	}
	
	/**
	 * Fonction permettant connettre la moyenne du temps mis pour finir l'epreuve
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

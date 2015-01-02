import java.util.Iterator;
import java.util.TreeSet;


public class Epreuve implements Comparable<Epreuve> {
	TreeSet <Participants> Coureurs;
	private int distance;
	private String nomCourse;
	
	Epreuve(String nom, int distance){
		this.nomCourse = nom;
		this.distance = distance;
	}
	
	public void addParticipants(String items []){
		Coureurs.add(new Participants(items));
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String getNomCourse() {
		return nomCourse;
	}
	
	public void setNomCourse(String nomCourse) {
		this.nomCourse = nomCourse;
	}
	
	public int nombreParticipant(){
		return Coureurs.size();
	}
	
	public String DureeMoyenne(){
		double moyenne = 0.0;
		Iterator iterator;
	    iterator = Coureurs.iterator();
	    
	    while (iterator.hasNext()){
	    	Participation tmp = (Participation) iterator.next();
			moyenne = moyenne + (double)(tmp.getArrivee());
		}
	    moyenne = moyenne / (double)(Coureurs.size());
	    String heures   = String.valueOf((int)(moyenne/3600));
	    String minutes  = String.valueOf((int)((moyenne % 3600) / 60));
	    String secondes = String.valueOf((int)((moyenne % 3600) % 60));

	    return heures + "h " + minutes + "min " + secondes + "s";
		
	}

	public int compareTo(Epreuve ep) {
		if (this.nomCourse.equalsIgnoreCase(ep.getNomCourse())) {
			return 1;
		}
		else {
			return 0;
		}

	}
	
}

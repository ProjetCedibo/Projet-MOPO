import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


public class Epreuve {
	ArrayList <Participants> Coureurs;
	private int distance;
	private String nomCourse;
	
	Epreuve(String nom, int distance){
		Coureurs = new ArrayList<Participants>();
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

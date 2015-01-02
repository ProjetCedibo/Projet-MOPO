import java.util.TreeSet;


public class Epreuve {
	TreeSet <Participants> Coureurs;
	private int distance;
	private String nomCourse;
	
	Epreuve(String nom, int distance){
		this.nomCourse = nom;
		this.distance = distance;
	}
	
	public void AddParticipant(){
		
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
	
	
	
}

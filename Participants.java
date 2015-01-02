import java.util.ArrayList;


public class Participants implements Comparable<Participants>{

	private String nom;
	private int naissance;
	private String club;
	private String nation;
	ArrayList <Participation> Participe;
	
	Participants(String infos []) {
		Participe = new ArrayList<Participation>();	
		this.nom=infos[2];
	    this.naissance=Integer.parseInt(infos[3]);
	    this.club=infos[4];
	    this.nation=infos[5];
	    addParticipation(infos);
	}
	
	public void addParticipation(String infos []) {
		Participe.add(new Participation(infos));
		
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getNaissance() {
		return naissance;
	}
	
	public void setNaissance(int naissance) {
		this.naissance = naissance;
	}
	
	public String getNation() {
		return nation;
	}
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getClub() {
		return club;
	}
	
	public void setClub(String club) {
		this.club = club;
	}

	public int compareTo(Participants p) {
		if ((((this.nom.equalsIgnoreCase(p.getNom())) && (this.naissance==p.getNaissance()) && (this.club.equalsIgnoreCase(p.getClub())) && (this.nation.equalsIgnoreCase(p.getNation()))))){
			return 0;	
		}
		else {
			return 1;
		}
	}
	
	public String toString() {
		String str = "";	
		str = getNom() + " " + getNaissance() + " " + getClub() + " " + getNation();
		for (Participation par : Participe) {
			str = str + " " + par.toString();
			
		}
		
		
		
		return str;
	}
		
		
		
		
}


import java.util.TreeSet;


public class Participants implements Comparable<Participants>{

	private String nom;
	private int naissance;
	private String club;
	private String nation;
	TreeSet <Participation> Participe;
	
	Participants(String infos []) {
		Participe = new TreeSet <Participation>();	
	    infos[0]="zob";
	    infos[1]="chibre";
		this.nom=infos[2];
	    this.naissance=Integer.parseInt(infos[3]);
	    this.club=infos[4];
	    this.nation=infos[5];
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
		if ((((this.nom==p.getNom()) && (this.naissance==p.getNaissance()) && (this.club==p.getClub()) && (this.nation==p.getNation())))){
			return 1;	
		}
		else {
			return 0;
		}
	}
	
}

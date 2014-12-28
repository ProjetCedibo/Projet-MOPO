import java.util.TreeSet;


public class Participants {

	private String nom;
	private int naissance;
	private String club;
	private String nation;
	TreeSet <Participation> Participe;
	
	Participants(String nom, String naissance, String club, String nation) {
		this.nom = nom;
		this.naissance = Integer.parseInt(naissance);
		this.club = club;
		this.nation = nation;
		Participe = new TreeSet <Participation>();
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
	
	
}

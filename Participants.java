import java.util.ArrayList;

/**
 * Class permettant de stocker les informationd d'un participant a la transjurassienne
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
public class Participants implements Comparable<Participants>{

	private String nom;
	private int naissance;
	private String club;
	private String nation;
	ArrayList <Participation> Participe;
	
	/**
	 * Constucteur
	 * @param infos tableau contenant les informations sur un participant
	 */
	Participants(String infos []) {
		Participe = new ArrayList<Participation>();	
		this.nom=infos[2];
	    this.naissance=Integer.parseInt(infos[3]);
	    this.club=infos[4];
	    this.nation=infos[5];

	}

	
	/**
	 * Constructeur permettant d'ajouter un participant et une participation
	 * @param infos tableau contenant les informations sur un participant
	 * @param an
	 */
	Participants(String infos [], int an) {
		Participe = new ArrayList<Participation>();	
		this.nom=infos[2];
	    this.naissance=Integer.parseInt(infos[3]);
	    this.club=infos[4];
	    this.nation=infos[5];
	    addParticipation(infos,an);
	}
	
	public void addParticipation(String infos [], int an) {
		Participe.add(new Participation(infos, an));
		
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
		String str = "\n";	
		str = getNom() + " " + getNaissance() + " " + getClub() + " " + getNation() + "\n";
		for (Participation par : Participe) {
			str = str + " " + par.toString();	
		}
			
		return str;
	}


	public double getArrivee(String nomEpreuve) {
		for(int i =0; i<Participe.size();i++){
			if(nomEpreuve.equalsIgnoreCase(Participe.get(i).getEpreuve())){
				return Participe.get(i).getArrivee();
			}
		}
		return 0;
	}	
}


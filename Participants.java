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
	
	/**
	 * Fonction permettant d'ajouter une participation a une epreuve a un participant
	 * @param infos tableau contenant les informations nécéssaire a l'ajout d'une participation
	 * @param an
	 */
	public void addParticipation(String infos [], int an) {
		Participe.add(new Participation(infos, an));
		
	}
	
	/**
	 * Getter sur le nom du participant
	 * @return le nom du participant
	 */
	public String getNom() {
		return nom;
	}
	
	
	/**
	 * Getter sur la date du participant
	 * @return la date de naissance du participant
	 */
	public int getNaissance() {
		return naissance;
	}
	
	
	/**
	 * Getter sur la nation du participant
	 * @return la nation du participant
	 */
	public String getNation() {
		return nation;
	}
	

	/**
	 * Getter sur le club du participant
	 * @return le club du participant
	 */
	public String getClub() {
		return club;
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


	/**
	 * Fonction permettant de connaitre le temps mis par le participant pour finir une epreuve
	 * @param nomEpreuve l'epreuve dont on veut connaitre le temps du participant
	 * @return le temps mis par le participant pour finir une epreuve
	 */
	public double getArrivee(String nomEpreuve) {
		for(int i =0; i<Participe.size();i++){
			if(nomEpreuve.equalsIgnoreCase(Participe.get(i).getEpreuve())){
				return Participe.get(i).getArrivee();
			}
		}
		return 0;
	}	
}


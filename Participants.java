import java.util.ArrayList;
import java.util.List;

/**
 * Class permettant de stocker les informations d'un participant à la transjurassienne
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
	 * Fonction permettant d'ajouter une participation à une épreuve à un participant
	 * @param infos tableau contenant les informations nécessaire à l'ajout d'une participation
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
	
	
	public String toString() {
		String str = "\n";	
		str = getNom() + " " + getNaissance() + " " + getClub() + " " + getNation() + "\n";
		for (Participation par : Participe) {
			str = str + " " + par.toString();	
		}
			
		return str;
	}


	/**
	 * Fonction permettant de connaître le temps mis par le participant pour finir une épreuve
	 * @param nomEpreuve l'épreuve dont on veut connaître le temps du participant
	 * @return le temps mis par le participant pour finir une épreuve
	 */
	public double getArrivee(String nomEpreuve) {
		for(int i =0; i<Participe.size();i++){
			if(nomEpreuve.equalsIgnoreCase(Participe.get(i).getEpreuve())){
				return Participe.get(i).getArrivee();
			}
		}
		return 0;
	}



	public int compareTo(Participants o) {
		if(Participe.get(0).getClassement() > o.getParticipe().get(0).getClassement()){
			return 1;
		}else{
			return -1;
		}
	}
	

	private ArrayList<Participation> getParticipe() {
		return Participe;
	}	
}


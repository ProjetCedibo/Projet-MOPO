import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * Class main
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
public class Main {

	public static void main(String[] args) {
		Transjurassienne tj = new Transjurassienne();
		System.out.println("\nXoxo ! :) ");
		System.out.println(tj.Recherche("Benoît"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTF"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM").DureeMoyenne());
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM").nombreParticipant());
		//fenetre fen = new fenetre(tj);
		//fen.setVisible(true);
		
		
		
		
		
		/*public ArrayList<Participants> Recherche(String str) {
			 
			 int cpt=0, cpt2=0;
			 ArrayList <Participants> Resultats = new ArrayList<Participants>();
			 
			 Iterator<Participants> it;
			 it = Skieurs.iterator();
			 
			 while (it.hasNext()){
			 	cpt=0;
			 	cpt2=0;
			 	Participants par = it.next();
			 	
			 	ArrayList <String> noms = new ArrayList<String>();
			 	ArrayList <String> prenom = new ArrayList<String>();
			 	noms.add(par.getNom().split(" ")[0]);
			 	prenom.add(par.getNom().split(" ")[1]);
			 	String[] s = str.split("+");
			 	//String[] noms=par.getNom().split(" ");
			 	System.out.println("Noms: "+noms.get(0));
			 	System.out.println("Prénoms : "+prenom.get(0));
			 	for(int i = 0 ; i< str.length(); i++){
			 		if(par.getNom().charAt(i) == ' '){
			 			cpt = 0;
			 		}
			 		
			 		if(par.getNom().charAt(i) == str.charAt(cpt2) && (cpt<str.length())){
			 			cpt++;
			 		}
			 		cpt2++;
			 	}
			 
			 		if (cpt == str.length()){
			 			//System.out.println(par.getNom());
			 			Resultats.add(par);
			 		}
			 	}
			 
			 return Resultats;
			 }*/
	}
}		

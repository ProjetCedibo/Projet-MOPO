import java.io.BufferedReader;
import java.io.FileReader;

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
		//tj.Recherche("Samuel");
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTF"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM").DureeMoyenne());
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM").nombreParticipant());
		System.out.println(tj.getPalmares("76FTF"));
		//new FenetrePrincipale("Transjurassienne", tj);
		
	}
}		

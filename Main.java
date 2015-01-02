import java.io.BufferedReader;
import java.io.FileReader;


public class Main {

	public static void main(String[] args) {
		Transjurassienne tj = new Transjurassienne();
		System.out.println("\nXoxo ! :) ");
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTF"));
		System.out.println(tj.getAnnee(2011).getEpreuve("76FTM").DureeMoyenne());
		System.out.println(tj.getAnnee(2011).getEpreuve("76FTM").nombreParticipant());
		//System.out.println("resultat de la recherche");
		//tj.getParticipant("Bourgeois");
		//fenetre fen = new fenetre();
		
	}
}		

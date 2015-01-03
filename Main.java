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

		System.out.println("\nXoxo ! :) ");
		//System.out.println(tj.Recherche("Benoît"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTF"));
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM").DureeMoyenne());
		//System.out.println(tj.getAnnee(2011).getEpreuve("76FTM").nombreParticipant());

		//System.out.println(tj.getPalmares("76FTF"));
		new FenetrePrincipale("Transjurassienne");
		
		//Les fonctions pour l'affichage :
		// les 10 participant d'une course dans Transjurassienne: 
		//affiche10(String annee, String course, int debut) 
		//Récupere le nombre de participants :
		//tj.getAnnee(int Annee).getEpreuve(String epreuve ).nombreParticipant()
		//Récupérer le temps moyen : 
		// tj.getAnnee(2011).getEpreuve("76FTM").DureeMoyenne()
		// Récupérer le palmares : 
		//tj.getPalmares(String epreuve)
		
		
	}
}		

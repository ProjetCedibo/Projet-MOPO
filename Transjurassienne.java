import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.io.*;
import java.util.regex.*;


/**
 * Classe permettant de stocker les informations sur la transjurassienne
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
public class Transjurassienne{
	
	private TreeSet<Participants> Skieurs;
	private ArrayList<Annee> Annee;
    private static Pattern pattern;
	private static Matcher matcher;
	/**
	 * Constructeur
	 * il recherche tous les fichiers .csv dans lesquels sont stockés les informations 
	 */
	Transjurassienne(){
		Skieurs = new TreeSet<Participants>();
		setAnnee(new ArrayList<Annee>());
		    File repertoire = new File("./");    
		    String [] listefichiers;
		    listefichiers=repertoire.list();
		   

		    System.out.print("\nChargement des données...\n");

		    for(int i=0;i<listefichiers.length;i++)
		    {
		      if(listefichiers[i].endsWith(".csv")==true)
		      {
		        System.out.print("\nEnregistrement des fichiers csv en cours : \n" + listefichiers[i] + "\n");
		        Annee an = new Annee(listefichiers[i].substring(0,4));
		        Annee.add(an);
		        lectureFichier(listefichiers[i], an);
		      }    
		    }
		  }
	
		  
	/**
	 * Fonction permettant d'enregistrer le contenu d'un fichier 
	 * @param nomFichier le nom du fichier
	 * @param an objet contenant les informations sur l'année
	 */
	public void lectureFichier(String nomFichier, Annee an){
		try
	    {  
	      String ligne;
	      BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader(nomFichier));
	      ligne = lecteurAvecBuffer.readLine();
	      
	      
	      while ((ligne = lecteurAvecBuffer.readLine()) != null){
	    	  
	    	  String[] items=ligne.split(";");
	    	  
	          Participants tmp = new Participants(items, an.getAnnee());
	          //System.out.println(tmp);
	          
	       
	      
	          //System.out.println(items[7]);
	          
	        
	          an.addParticipation(items);
	        	 
	          
	          
	          if (Skieurs.contains(tmp)){
	        	  tmp.addParticipation(items,an.getAnnee());
	          }
	    	  else {
	    		  Skieurs.add(tmp);
	    		  //System.out.println("Je suis passé dans add les amis :) ");
	    	  }
	        	 tmp = null; 
	        	  
	    	//  for (int i=0;i<items.length;i++) /*System.out.print(items[i]+" ")*/;
	          /*System.out.println();*/}
	      
	      	  lecteurAvecBuffer.close();
	    }
	    
		catch(Exception e){
	        
			System.out.println("Erreur fichier : "+e.getMessage()+" "+e.getLocalizedMessage());
	    }
		//System.out.println(an);
		
	}

	/**
	 * Getter sur Annee
	 * @return L'arraylist des années
	 */
	public ArrayList<Annee> getAnnee() {
		return Annee;
	}
	
	
	/**
	 * Getter sur une année précise
	 * @param i l'année cherchée
	 * @return l'année cherchée
	 */
	public Annee getAnnee(int i) {
		for (int j =0;j<Annee.size();j++) {
			if (Annee.get(j).getAnnee()==i) {
			return Annee.get(j);
			}
			
		}
		return null;
	}

	
	public ArrayList<Participants> affiche10(String annee, String course, int debut){
		ArrayList<Participants> TopDix = new ArrayList<Participants>(10);
		/*for(int i = 0; i< 10; i++){
				TopDix.add(getAnnee(Integer.parseInt(annee)).getEpreuve(course).Coureurs.get(i+debut));
		}*/
		TopDix.addAll(getAnnee(Integer.parseInt(annee)).getEpreuve(course).Coureurs.subList(debut, debut+10));
		return TopDix;
	}

	/**
	 * Setter sur l'Année
	 * @param année
	 */
	public void setAnnee(ArrayList<Annee> annee) {
		Annee = annee;
	}
	
	 
	public TreeSet<Participants> Recherche(String str) {
		 int cpt=0, cpt2=0, i=0;
		 ArrayList <Participants> Resultats = new ArrayList<Participants>();
		 ArrayList <String> prenom = new ArrayList<String>();
		 TreeSet<Participants> prenom2 = new TreeSet<Participants>();	
		 Iterator<Participants> it;
		 it = Skieurs.iterator();
		 
		 
		 while(it.hasNext()) {
			 Participants par = it.next();
			// System.out.println(par.getNom());
			 
			 pattern = Pattern.compile(str);
			 matcher = pattern.matcher(par.getNom());
			
			 while(matcher.find()) {
				   prenom2.add(par);
				   
				   for (i=0;i<prenom.size();i++)
				   System.out.println(prenom.get(i));
			  	   }
			 		
		 } 
		 
		 
		    /*
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
		 	}*/
		 
		return prenom2;
		}
	
}



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Class permettant de stocker les informations sur la transjurassienne
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
public class Transjurassienne {
	
	private TreeSet<Participants> Skieurs;
	private ArrayList<Annee> Annee;
	
	/**
	 * Constructeur
	 * il recherche tout les fichiers .csv dans lesquels sont stocké les informations 
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
	 * Fonction permettant d'enregistrer le contenue d'un fichier 
	 * @param nomFichier le nom du fichier
	 * @param an objet contenant les informations sur l'annee
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
	 * Getter sur une annee précise
	 * @param i l'annee chercher
	 * @return l'annee chercher
	 */
	public Annee getAnnee(int i) {
		for (int j =0;j<Annee.size();j++) {
			if (Annee.get(j).getAnnee()==i) {
			return Annee.get(j);
			}
			
		}
		return null;
	}

	


	/**
	 * Setter sur l'Annee
	 * @param annee
	 */
	public void setAnnee(ArrayList<Annee> annee) {
		Annee = annee;
	}

	
	 public void getParticipant(String s){
	        for(Participants p : Skieurs) 
	        {
	            if(s.toLowerCase().startsWith(s.toLowerCase()))
	                System.out.println(p);
	        }
	    }

	

	

}

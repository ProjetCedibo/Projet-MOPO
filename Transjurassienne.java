import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeSet;



public class Transjurassienne {
	
	private TreeSet<Participants> Skieurs;
	private ArrayList<Annee> Annee;
	
	Transjurassienne(){
		Skieurs = new TreeSet<Participants>();
		Annee = new ArrayList<Annee>();
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
		  
	public void lectureFichier(String nomFichier, Annee an){
		try
	    {  
	      String ligne;
	      BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader(nomFichier));
	      ligne = lecteurAvecBuffer.readLine();
	      
	      
	      while ((ligne = lecteurAvecBuffer.readLine()) != null){
	    	  
	    	  String[] items=ligne.split(";");
	          
	    	 
	    	  /*
	    	   * C'est la qu'il faut tester si l'epreuve est connu ou non 
	    	   * je pense il faut passé l'Annee en param du coup XD
	    	   */
	    	  
	    	  
	          Participants tmp = new Participants(items, 1);
	          System.out.println(tmp);
	          
	    	 
	          if (!an.contient(items[7])) {
	        	  System.out.println(an.contient(items[7]));
	        	  an.addEpreuve(items);
	        	  System.out.println("L'épreuve n'existait pas et est ajoutée");
	        	  an.addParticipation(items);  
	        	  System.out.println("On ajoute le participant");
	          	 
	          }
	          else {
	        	  an.addParticipation(items);
	        	  System.out.println("\n L'épreuve existait déjà");
	          }
	          
	          if (Skieurs.contains(tmp)){
	        	  tmp.addParticipation(items);
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
		System.out.println(an);
		
	}
	

}

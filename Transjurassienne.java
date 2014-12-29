import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;


public class Transjurassienne {
	
	private TreeSet<Participants> Skieurs;
	private List Annee;
	
	Transjurassienne(){
		Skieurs = new TreeSet<Participants>();
		try
	      {  
	        String ligne;
	        BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader("D:/Projets Eclipse Ibo/Projet MOPO/src/2011.csv"));
	        while ((ligne = lecteurAvecBuffer.readLine()) != null)     
	            {
	        	String[] items=ligne.split(";");
	            
	             for (int i=0;i<items.length;i++){
	            	System.out.print(items[i]+" ");
	            	 
	             } //this.Skieurs.add(new Participants(items[2], items[3],items[4], items[5]));
	            System.out.println();
	            }
	        lecteurAvecBuffer.close();
	      }
	    catch(Exception e)
	      {
	          System.out.println("Erreur fichier : "+e.getMessage()+" "+e.getLocalizedMessage());
	      }

		  }
	
	
	public TreeSet<Participants> getSkieurs() {
		return Skieurs;
	}
	
	
	public void setSkieurs(TreeSet<Participants> skieurs) {
		Skieurs = skieurs;
	}
	
	
	public List getAnnee() {
		return Annee;
	}
	
	
	public void setAnnee(List annee) {
		Annee = annee;
	}
	






}

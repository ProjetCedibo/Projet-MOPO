import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
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
		   

		    System.out.print("\nChargement des donees...\n");

		    for(int i=0;i<listefichiers.length;i++)
		    {
		      if(listefichiers[i].endsWith(".csv")==true)
		      {
		        System.out.print("\nEnregistrement des fichiers csv en cours : " + listefichiers[i]);
		        Annee.add(new Annee(listefichiers[i].substring(0,4)));
		      }    
		    }
		  }
		  
	
	
	public TreeSet<Participants> getSkieurs() {
		return Skieurs;
	}
	
	
	public void setSkieurs(TreeSet<Participants> skieurs) {
		Skieurs = skieurs;
	}

}

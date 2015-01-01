import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;


public class Annee {
	public int annee;
	List epreuve;

Annee(String annee) {
	this.annee = Integer.parseInt(annee);
	ArrayList<Epreuve> epreuve = new ArrayList<Epreuve>();
}

public void lectureFichier(){
	
	try
    {  
      String ligne;
      BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader("c:/transju/2014.csv"));
      while ((ligne = lecteurAvecBuffer.readLine()) != null)     
          {String[] items=ligne.split(";");
           for (int i=0;i<items.length;i++) System.out.print(items[i]+" ");
          System.out.println();}
      lecteurAvecBuffer.close();
    }
  catch(Exception e)
    {
        System.out.println("Erreur fichier : "+e.getMessage()+" "+e.getLocalizedMessage());
    }

}







}

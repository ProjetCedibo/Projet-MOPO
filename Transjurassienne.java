import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Classe permettant de stocker les informations sur la transjurassienne
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
/**
 * @author cedric
 *
 */
public class Transjurassienne{
	
	private Set<Participants> Skieurs;
	private ArrayList<Annee> Annee;
    private static Pattern pattern;
	private static Matcher matcher;

	
	/**
	 * Constructeur
	 * il recherche tous les fichiers .csv dans lesquels sont stockés les informations 
	 */
	 public Transjurassienne(){

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
	          an.addParticipation(items);

	          if (Skieurs.contains(tmp)){
	        	  tmp.addParticipation(items,an.getAnnee());
	          }
	    	  else {
	    		  Skieurs.add(tmp);
	    	  }
	        	 tmp = null; 
	        	  
	    	}
	      
	      	  lecteurAvecBuffer.close();
	    }
	    
		catch(Exception e){
	        
			System.out.println("Erreur fichier : "+e.getMessage()+" "+e.getLocalizedMessage());
	    }

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

	
	public ArrayList<Participants> getParticip(String annee, String course){
		return getAnnee(Integer.parseInt(annee)).getEpreuve(course).getParticipants();
	}

	/**
	 * Setter sur l'Année
	 * @param année
	 */
	public void setAnnee(ArrayList<Annee> annee) {
		Annee = annee;
	}


	

	/**
	 * Fonction permettant la recherche de participants
	 * @param str le nom a chercher
	 * @return la liste des participants correspondants a la recherche
	 */
	public TreeSet<Participants> recherche(String str) {
		
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
				
			}
		}
		
		return prenom2;
		}


    
   
    /**
     * Fonction recherchant le nom des vainqueurs d'une epreuve, une année sur l'autre
     * @param epreuve l'epreuve dont on veut connaitre les gagnants
     * @return la liste des gagnant de l'epreuve
     */
    public ArrayList<String> getPalmaresNoms(String epreuve){
    	ArrayList <String> res = new ArrayList<String>();
    	for(int i = 0; i < Annee.size(); i++){
    		for(int j = 0; j < Annee.get(i).getEpreuve().size(); j++){
    			if(Annee.get(i).getEpreuve().get(j).getNomCourse().equals(epreuve) && Annee.get(i).getEpreuve().get(j).Exist()){
    				res.add(Annee.get(i).getEpreuve().get(j).getFirst().getNom());
    			}
    		}
    	}
    	return res;
    }
    
    
    /**
     * Fonction pertmettant de connaitre l'année de victoire 
     * @param epreuve l'epreuve dont on veut connaitre les gagnants
     * @return la liste des annees durant lesquelles l'epreuve a eu lieu
     */
    public ArrayList<Integer> getPalmaresAnnee(String epreuve){
    	ArrayList <Integer> res = new ArrayList<Integer>();
    	for(int i = 0; i < Annee.size(); i++){
    		for(int j = 0; j < Annee.get(i).getEpreuve().size(); j++){
    			if(Annee.get(i).getEpreuve().get(j).getNomCourse().equals(epreuve) && Annee.get(i).getEpreuve().get(j).Exist()){
    				res.add(Annee.get(i).getAnnee());
    			}
    		}
    	}
    	return res;
    }
    
    
    /**
     * Fonction qui retourne le pays ainsi que le nombre de participants de cette nationnalitée qui on participés a une course
     * @param annee l'annee de l'epreuve
     * @param epreuve l'epreuve
     * @return un tableau contenant la notionnalitée et le nombre de participants de cette nationnalitée
     */
    public String [][] getPaysParticipant(String annee, String epreuve){
    	ArrayList<String> pays = new ArrayList<String>();
    	ArrayList<Integer> nombrePart = new ArrayList<Integer>();
    	
    	int  test= -1;
    	for( int i =0; i<Annee.size(); i++){
    		if(Integer.toString(Annee.get(i).getAnnee()).equals(annee)){
    			for(int j =0; j< Annee.get(i).getEpreuve().size(); j++){
    				if(Annee.get(i).getEpreuve().get(j).getNomCourse().equals(epreuve)){
    					for(int k = 0; k< Annee.get(i).getEpreuve().get(j).getParticipants().size();k++){
    						test = -1;
    						for(int l = 0; l<pays.size();l++){
    							if(pays.get(l).equals(Annee.get(i).getEpreuve().get(j).getParticipants().get(k).getNation())){
    								test = l;

    							}
    							
    						}
    						if(test != -1){
    								int nb = nombrePart.get(test);
    								//int nb2 = Integer.parseInt(nb);
    								nombrePart.set(test, nb+1);
    						}
    						else{
    							pays.add(Annee.get(i).getEpreuve().get(j).getParticipants().get(k).getNation());
    							nombrePart.add(1);
    						}
    					}
    				}
    			}
    		}
    	}
    	String[][] res = new String[pays.size()][2]; 
    	for(int i = 0; i<pays.size();i++){
    		res [i][0] = pays.get(i);
    		res [i][1] = Integer.toString(nombrePart.get(i));
    	}
    	return res;
    }

}



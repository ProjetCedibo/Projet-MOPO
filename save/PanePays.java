import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanePays extends JPanel{

	private Tableau tableau;
	private Object[][] donnees;
	private String[] entetes = {"Pays" , "Participation"};
	private JScrollPane scrollPane;
	private Transjurassienne tj;
	private FenetrePrincipale fen;
	
	public PanePays(FenetrePrincipale fp) {
		super();
		this.fen = fp;
		this.tj = fen.getTransjurassienne();
		tableau = new Tableau(entetes, donnees);
		//scrollPane = new JScrollPane();
		//scrollPane.add(tableau);
		add(tableau);
	}
	
	private void initDonnees(){
		donnees = new Object[10][2];
		for(int i =0; i<10;i++){
			donnees[i][0] = "";
			donnees[i][1] = "";
		}
	}
	
	public void actualiserDonnees() {
		String annee = fen.getAnnee();
		String course = fen.getCourse();
		
	}
	
	private void actualiserAffichage(){
		//tj.getPaysParticipant(fen.getAnnee(), fen.getCourse());
		tableau = new Tableau(entetes, donnees);
	}
	
}
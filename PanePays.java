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
		actualiserDonnees();
		scrollPane = new JScrollPane();
		scrollPane.add(tableau);
		add(scrollPane);
	}
	
	private void actualiserDonnees() {
		String annee = fen.getAnnee();
		String course = fen.getCourse();
		tableau = new Tableau(entetes, donnees);
	}
	
	private void actualiserAffichage(){
		tj.getPaysParticipant(fen.getAnnee(), fen.getCourse());
	}
	
}
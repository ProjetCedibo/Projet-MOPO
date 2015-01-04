import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanePalmares extends JPanel{

	private FenetrePrincipale fen;
	private Transjurassienne tj;
	
	private Object[][] donnees;
	private String[] entetes = {"Participant" , "Annee"};
	
	private Tableau tableau;
	private Titre titre;
	private JScrollPane scrollPane;
	
	public PanePalmares(FenetrePrincipale fp) {
		super();
		this.fen = fp;
		this.tj = fen.getTransjurassienne();
		
		initDonnees();
		initComposants();
		
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		setLayout(new BorderLayout());
		add(titre,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
	}
	
	private void initComposants() {
		tableau = new Tableau(entetes, donnees);
		titre = new Titre("Palmares");
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(tableau);
	}

	private void initDonnees(){
		donnees = new Object[3][2];
		for(int i =0; i<3;i++){
			donnees[i][0] = "";
			donnees[i][1] = "";
		}
	}
	
	public void actualiserDonnees() {
		ArrayList<String> parNom = tj.getPalmaresNoms(fen.getCourse());
		ArrayList<Integer> parAnnee = tj.getPalmaresAnnee(fen.getCourse());
		donnees = new Object[parNom.size()][2];
		for(int i = 0; i<parNom.size();i++){
			donnees[i][0] = parNom.get(i);
			donnees[i][1] = parAnnee.get(i);
		}
		tableau.setDonnee(donnees);
	}
	
}

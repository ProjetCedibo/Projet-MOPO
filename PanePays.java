import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanePays extends JPanel{

	private FenetrePrincipale fen;
	private Transjurassienne tj;
	
	private Object[][] donnees;
	private String[] entetes = {"Pays" , "Participation"};
	
	private Tableau tableau;
	private Titre titre;
	private JScrollPane scrollPane;
	
	public PanePays(FenetrePrincipale fp) {
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
		titre = new Titre("Pays par participation");
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(tableau);
	}

	private void initDonnees(){
		donnees = new Object[4][2];
		for(int i =0; i<4;i++){
			donnees[i][0] = "";
			donnees[i][1] = "";
		}
	}
	
	
	
	public void actualiserDonnees() {
		String annee = fen.getAnnee();
		String epreuve = fen.getCourse();
		String[][] pays = tj.getPaysParticipant(annee, epreuve);
		donnees = new Object[pays.length][2];
		for(int i = 0; i<donnees.length;i++){
			donnees[i][0] = pays[i][0];
			donnees[i][1] = pays[i][1];
		}
		tableau.setDonnee(donnees);
	}
	
}

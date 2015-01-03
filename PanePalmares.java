import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanePalmares extends JPanel{

	private Tableau tableau;
	private Object[][] donnees;
	private String[] entetes = {"Participant" , "Année"};
	private PaneInfo paneInfo;
	private Transjurassienne tj;
	private FenetrePrincipale fen;
	
	public PanePalmares(FenetrePrincipale fp) {
		super();
		this.fen = fp;
		this.tj = fen.getTransjurassienne();
		initDonnees();
		setLayout(new BorderLayout());
		actualiserAffichage();
	}
	
	private void initDonnees(){
		donnees = new Object[4][2];
		for(int i =0; i<4;i++){
			donnees[i][0] = "";
			donnees[i][1] = "";
		}
	}
	
	private void actualiserAffichage(){
		tableau = new Tableau(entetes, donnees);
		paneInfo = new PaneInfo();
		removeAll();
		add(tableau,BorderLayout.CENTER);
		add(paneInfo,BorderLayout.SOUTH);
	}
	
	private void actualiserDonnees() {
		ArrayList<String> parNom = tj.getPalmaresNoms(fen.getAnnee());
		ArrayList<Integer> parAnnee = tj.getPalmaresAnnee(fen.getAnnee());
		donnees = new Object[parNom.size()][2];
		for(int i = 0; i<parNom.size();i++){
			donnees[i][0] = parNom.get(i);
			donnees[i][1] = parAnnee.get(i);
		}
		actualiserAffichage();
		
	}
	
	private class PaneInfo extends JPanel {
		
		private JLabel labelTemps;
		private JLabel labelNbPart;
		
		public PaneInfo() {
			super();
			labelTemps = new JLabel(tj.getAnnee(Integer.parseInt(fen.getAnnee())).getEpreuve(fen.getCourse()).DureeMoyenne());
			labelNbPart = new JLabel(""+ tj.getAnnee(Integer.parseInt(fen.getAnnee())).getEpreuve(fen.getCourse()).nombreParticipant());
			setLayout(new GridLayout(1,2));
			add(labelTemps);
			add(labelNbPart);
		}
		
		
		
	}
	
}

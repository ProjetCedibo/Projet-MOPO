

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaneClassement extends JPanel implements ActionListener {

	private JPanel paneBouton;
	private JButton bPrecedent;
	private JButton bSuivant;
	private Transjurassienne tj;
	private FenetrePrincipale fen;
	
	private int indiceClassement = 0;
	private int indiceMax;
	private Tableau tableau;
	private Object[][] donnees;
	private String[] entetes = {"Participant" , "Classement"};
	
	public PaneClassement(FenetrePrincipale fp) {
		super();
		initDonnees();
		this.fen = fp;
		this.tj = fp.getTransjurassienne();
		indiceMax = 20;
		initBouton();
		setLayout(new BorderLayout());
		tableau = new Tableau(entetes, donnees);
		add(tableau, BorderLayout.CENTER);
		add(paneBouton, BorderLayout.SOUTH);
	}
	
	private void initDonnees(){
		donnees = new Object[10][2];
		for(int i =0; i<10;i++){
			donnees[i][0] = "";
			donnees[i][1] = "";
		}
	}
	
	public void actualiserDonnees() {
		ArrayList<Participants> par = tj.affiche10(fen.getAnnee(), fen.getCourse(), indiceClassement);
		/*for(int i = 0; i<10;i++){
			donnees[i][0]=par.get(i).getNom();
			donnees[i][1]=""+(i+1);
		}
		*/

	}
	
	private void initBouton() {
		bPrecedent = new JButton("Precedent");
		bSuivant = new JButton("Suivant");
		
		bPrecedent.addActionListener(this);
		bSuivant.addActionListener(this);
		
		paneBouton = new JPanel();
		paneBouton.setLayout(new GridLayout(1,2));
		paneBouton.add(bPrecedent);
		paneBouton.add(bSuivant);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == bSuivant)
			actionSuivant();
		else if (actionEvent.getSource() == bPrecedent)
			actionPrecedent();			
	}
	
	private void actionPrecedent() {
		indiceClassement -= 10;
		if (indiceClassement < 0) indiceClassement = 0;
		actualiserDonnees();
	}
	
	private void actionSuivant() {
		indiceClassement += 10;
		if (indiceClassement > indiceMax) indiceClassement = indiceMax;
		actualiserDonnees();
	}
}

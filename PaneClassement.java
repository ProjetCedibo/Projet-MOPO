import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Class PaneClassement
 * Affiche le classement des participants a une epreuve 10 par 10
 * et des bouttons "suivant" et "precedent"
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */

@SuppressWarnings("serial")
public class PaneClassement extends JPanel implements ActionListener {

	
	private FenetrePrincipale fen;
	private Transjurassienne tj;
	
	private int indiceClassement = 0;
	private int indiceMax;
	private Tableau tableau;
	private Object[][] donnees;
	private String[] entetes = {"Participant" , "Classement"};
	
	private JPanel paneBouton;
	private JButton bPrecedent;
	private JButton bSuivant;
	private Titre titre;
	
	public PaneClassement(FenetrePrincipale fp) {
		super();
		this.fen = fp;
		this.tj = fp.getTransjurassienne();
		
		initDonnees();
		initComposants();
		
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		setLayout(new BorderLayout());
		add(titre, BorderLayout.NORTH);
		add(tableau, BorderLayout.CENTER);
		add(paneBouton, BorderLayout.SOUTH);
	}
	
	private void initDonnees(){
		donnees = new Object[10][2];
		for(int i =0; i<10;i++){
			donnees[i][0] = "";
			donnees[i][1] = "";
		}
		indiceMax = 0;
	}
	
	public void actualiserDonnees(boolean indiceAZero) {
		if(indiceAZero) indiceClassement = 0;
		ArrayList<Participants> par = tj.getParticip(fen.getAnnee(), fen.getCourse());
		for(int i = 0; i<10;i++){
			if(i+indiceClassement<par.size()){
				donnees[i][0]=par.get(i+indiceClassement).getNom();
				donnees[i][1]=par.get(i+indiceClassement).getParticipe().get(0).getClassement();
			}else{
				donnees[i][0] = "";
				donnees[i][1] = "";
			}
		}
		
		int aux = par.size() - 10;
		if (aux / 10 * 10 != aux) indiceMax = aux + 10;
		else indiceMax = aux;
		tableau.setDonnee(donnees);
	}
	
	private void initComposants() {
		titre = new Titre("Classement");
		
		tableau = new Tableau(entetes, donnees);
		
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
		actualiserDonnees(false);
	}
	
	private void actionSuivant() {
		indiceClassement += 10;
		if (indiceClassement > indiceMax) indiceClassement -=10;
		actualiserDonnees(false);
	}
}

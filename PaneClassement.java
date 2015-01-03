

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaneClassement extends JPanel implements ActionListener {

	private JPanel paneBouton;
	private JButton bPrecedent;
	private JButton bSuivant;
	private Transjurassienne tj;
	
	private int indiceClassement = 0;
	private int indiceMax;
	private Tableau tableau;
	private Object[][] donnees;
	private String[] entetes = {"Participant" , "Classement"};
	
	public PaneClassement(Transjurassienne t) {
		super();
		this.tj = t;
		indiceMax = 20;
		initBouton();
		actualiserDonnees();
		setLayout(new BorderLayout());
		add(tableau, BorderLayout.CENTER);
		add(paneBouton, BorderLayout.SOUTH);
	}
	
	private void actualiserDonnees() {
		tableau = new Tableau(entetes, donnees);
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

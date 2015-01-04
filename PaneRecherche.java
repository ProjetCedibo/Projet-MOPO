

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PaneRecherche extends JPanel implements ActionListener {
	
	private Titre titre;
	private JButton bRechercher;
	//private JTextArea textResultat;
	private JTextField textRecherche;
	private JPanel commande;
	private Transjurassienne t;
	private JScrollPane scrollPane;
	private Tableau tableau;
	private Object[][] donnees = {{"", ""/*, "", "", "", "", "","", ""*/}};
	private String[] entetes = {"Nom", "Naissance", "Club", "Annee:Epreuve", /*"Arrivee", "Classement", "Dossars","Categorie", "Classement categorie"*/};
	
	public PaneRecherche(Transjurassienne tj) {
		super();
		this.t = tj;
		initComposant();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		add(commande, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

	}
	
	private void initComposant() {
		titre = new Titre("Entrez un nom ou un prenom :");
		tableau = new Tableau(entetes, donnees);
		
		bRechercher = new JButton("Rechercher");
		bRechercher.addActionListener(this);
		bRechercher.setBackground(new Color(230,255,230));
		
		textRecherche = new JTextField();
		
		/*textResultat = new JTextArea();
		textResultat.setEditable(true);
		textResultat.setBackground(new Color(200,255,200));
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(textResultat);*/
		
		commande = new JPanel();
		commande.setLayout(new GridLayout(1, 3));
		commande.add(titre);
		commande.add(textRecherche);
		commande.add(bRechercher);
		commande.setBackground(new Color(230,255,230));
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(tableau);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == bRechercher) actionRecherche();
	}
	
	
	public void actionRecherche() {
		 String str = textRecherche.getText(); 
		 TreeSet<Participants> participants = t.recherche(str);
		 Iterator<Participants> it;
		 it = participants.iterator();
		 int i = 0;
		 str = "";
		 donnees = new Object[participants.size()][4];
		 
		 while(it.hasNext()){
			 Participants par = it.next();
			 donnees[i][0] = par.getNom();
			 donnees[i][1] = par.getNaissance();
			 donnees[i][2] = par.getClub();
			 donnees[i][3] = par.getParticipe().get(0).getannee()+" : "+ par.getParticipe().get(0).getEpreuve();
			 str += par.getNom() +"a participé en "+ par.getParticipe().get(0).getannee() +" à l'épreuve :"+ par.getParticipe().get(0).getEpreuve() +". Il/Elle a fini en "+par.getParticipe().get(0).getClassement()+" position.\n";
			 i++;
			 
		 }
		 tableau.setDonnee(donnees);

		 str = null;
		 participants = null;
	}
}

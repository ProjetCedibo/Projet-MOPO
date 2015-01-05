

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Class PaneRecherche
 * affiche le champs de recherche, le bouton et les resultats de la recherche
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */

@SuppressWarnings("serial")
public class PaneRecherche extends JPanel implements ActionListener {
	
	private Titre titre;
	private JButton bRechercher;
	private JTextArea textResultat;
	private JTextField textRecherche;
	private JPanel commande;
	private Transjurassienne t;
	private JScrollPane scrollPane;

	
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

		
		bRechercher = new JButton("Rechercher");
		bRechercher.addActionListener(this);
		bRechercher.setBackground(new Color(230,255,230));
		
		textRecherche = new JTextField();
		
		textResultat = new JTextArea();
		textResultat.setEditable(true);
		textResultat.setBackground(new Color(200,255,200));
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(textResultat);
		
		commande = new JPanel();
		commande.setLayout(new GridLayout(1, 3));
		commande.add(titre);
		commande.add(textRecherche);
		commande.add(bRechercher);
		commande.setBackground(new Color(230,255,230));

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
		 str = "";
		 String affiche = "";
		 
		 while(it.hasNext()){
			 Participants par = it.next();
			 
			 affiche += par.getParticipe().get(0).getannee()+ " : " +par.getNom()+" a participé à la course "+par.getParticipe().get(0).getEpreuve() + ". Son classement final fut : "+par.getParticipe().get(0).getClassement()+".\n"; 
			 
		 }
		 textResultat.setText(affiche);
		 str = null;
		 participants = null;
	}
}

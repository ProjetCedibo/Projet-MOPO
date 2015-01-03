import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PaneRecherche extends JPanel {
	
	private JLabel label;
	private JButton bRechercher;
	private JTextArea textResultat;
	private JTextField textRecherche;
	private JPanel commande;
	private Transjurassienne tj;
	private FenetrePrincipale fenetre;
	
	public PaneRecherche(FenetrePrincipale fp) {
		super();
		this.fenetre = fp;
		this.tj = fenetre.getTransjurassienne();
		initComposant();
		setLayout(new BorderLayout());
		add(commande, BorderLayout.NORTH);
		add(textResultat, BorderLayout.CENTER);
		setBorder(new BevelBorder(BevelBorder.RAISED));
	}
	
	private void initComposant() {
		label = new JLabel("  Entrez un nom ou un prenom :");
		
		bRechercher = new JButton("Rechercher");
		bRechercher.addActionListener(fenetre);
		bRechercher.setBackground(new Color(230,255,230));
		
		textRecherche = new JTextField();
		
		textResultat = new JTextArea();
		textResultat.setEditable(false);
		textResultat.setBackground(new Color(200,255,200));
		
		commande = new JPanel();
		commande.setLayout(new GridLayout(1, 3));
		commande.add(label);
		commande.add(textRecherche);
		commande.add(bRechercher);
		commande.setBackground(new Color(230,255,230));
	}
	
	
	
	public JButton getButtonRechercher(){
		return bRechercher;
	}

	public void actionRecherche() {
		 String str = textRecherche.getText();
		 ArrayList<Participants> participants = tj.recherche(str);
		 str = "";
		for(int i =0; i<participants.size(); i++){
			str += participants.get(i) + "\n";
		}
		textResultat = new JTextArea("TOTO");
		//textResultat = new JTextArea(str);
	}
	
}

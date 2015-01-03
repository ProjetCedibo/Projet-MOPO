

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PaneRecherche extends JPanel implements ActionListener {
	
	private JLabel label;
	private JButton bRechercher;
	private JTextArea textResultat;
	private JTextField textRecherche;
	private JPanel commande;
	private JScrollPane scrollPane;
	private Transjurassienne t;
	
	public PaneRecherche(Transjurassienne tj) {
		super();
		this.t = tj;
		initComposant();
		setLayout(new BorderLayout());
		add(commande, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		setBorder(new BevelBorder(BevelBorder.RAISED));
	}
	
	private void initComposant() {
		label = new JLabel("  Entrez un nom ou un prénom :");
		
		bRechercher = new JButton("Rechercher");
		bRechercher.addActionListener(this);
		bRechercher.setBackground(new Color(230,255,230));
		
		textRecherche = new JTextField();
		
		textResultat = new JTextArea();
		textResultat.setEditable(false);
		textResultat.setBackground(new Color(200,255,200));
		
		scrollPane = new JScrollPane();
		JPanel pane = new JPanel();
		pane.add(textResultat);
		scrollPane.add(pane);
		
		commande = new JPanel();
		commande.setLayout(new GridLayout(1, 3));
		commande.add(label);
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
		 while(it.hasNext()){
			 Participants par = it.next();
			 str += par.getNom() +" A participer en "+ par.getParticipe().get(0).getannee() +" A l'epreuve :"+ par.getParticipe().get(0).getEpreuve() + "\n";
			 
		 }
		 	System.out.println(str);
		 //textResultat = new JTextArea("TOTO");
		 textResultat.setText(str);
		 str = null;
		 participants = null;
	}
}

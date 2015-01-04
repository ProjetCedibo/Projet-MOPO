import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class TableauRecherche extends JPanel {
	
	private JTable tableau;
	
	private Object[][] donnees;
	private String[] entetes = {"Nom", "Naissance", 
			"Club", "Annee:Epreuve", "Arrivee",
			"Classement", "Dossars","Categorie"};
	
	private DefaultTableModel dtm;

	public TableauRecherche(Object[][] donnees) {
		super();
		this.donnees = donnees;
		initTableau();
		setLayout(new BorderLayout());
		add(tableau.getTableHeader(), BorderLayout.NORTH);
        add(tableau, BorderLayout.CENTER);
	}
	
	private void initTableau() {
		dtm = new DefaultTableModel(donnees,entetes);
		tableau = new JTable(dtm);
		tableau.setEnabled(false);
	}
	
	public void setDonnee(Object[][] newDonnees) {
		if (donnees.length > newDonnees.length)
			supprimerLignes(donnees.length - newDonnees.length);
		else if (donnees.length < newDonnees.length)
			ajouterLignes(newDonnees.length - donnees.length);
				
		donnees = newDonnees;
		for (int i = 0 ; i < donnees.length ; i++)
			for (int j = 0 ; j < 8 ; i++)
				tableau.setValueAt(donnees[i][j], i, j);
	}

	private void ajouterLignes(int nbLigne) {
		Object[] tmp = new Object[nbLigne];
		for(int i = 0; i<tmp.length;i++)
			tmp[i] = "";
		for(int i = 0; i<tmp.length;i++)
			dtm.addRow(tmp);
		
	}

	private void supprimerLignes(int nbLigne) {
		for (int i = 0 ; i < nbLigne ; i++)
			dtm.removeRow(i);
	}
	
}

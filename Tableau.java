import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Tableau extends JPanel {
	
	private JTable tableau;
	
	private Object[][] donnees;
	private String[] entetes;
	private DefaultTableModel dtm;

	public Tableau(String[] entetes, Object[][] donnees) {
		super();
		this.donnees = donnees;
		this.entetes = entetes;
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
		int lon =  ((String) donnees[0][0]).length();
		for (int i = 0 ; i < donnees[i].length ; i++) {
			for(int j = 0; j < lon ; j++){
				tableau.setValueAt(donnees[i][j], i, j);
				//tableau.setValueAt(donnees[i][1], i, 1);
			}
		}
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

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JPanel;

public class Tableau extends JPanel {
	
	private JTable tableau;

	public Tableau(String[] entetes, Object[][] donnees) {
		super();
		
		tableau = new JTable(donnees, entetes);
		
		setLayout(new BorderLayout());
		add(tableau.getTableHeader(), BorderLayout.NORTH);
        add(tableau, BorderLayout.CENTER);
	}

}

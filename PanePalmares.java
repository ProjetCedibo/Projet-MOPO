import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanePalmares extends JPanel{

	private Tableau tableau;
	private Object[][] donnees;
	private String[] entetes = {"Participant" , "Classement"};
	private PaneInfo paneInfo;
	private Transjurassienne tj;
	
	public PanePalmares(Transjurassienne t) {
		super();
		this.tj = t;
		actualiserDonnees();
		setLayout(new BorderLayout());
		add(tableau,BorderLayout.CENTER);
		add(paneInfo,BorderLayout.SOUTH);
	}
	
	private void actualiserDonnees() {
		paneInfo = new PaneInfo();
		tableau = new Tableau(entetes, donnees);
	}
	
	private class PaneInfo extends JPanel {
		
		public PaneInfo() {
			super();
			
		}
	}
}

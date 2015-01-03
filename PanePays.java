import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanePays extends JPanel{

	private Tableau tableau;
	private Object[][] donnees;
	private String[] entetes = {"Pays" , "Participation"};
	private JScrollPane scrollPane;
	private Transjurassienne tj;
	
	public PanePays(Transjurassienne t) {
		super();
		this.tj = t;
		actualiserDonnees();
		scrollPane = new JScrollPane();
		scrollPane.add(tableau);
		add(scrollPane);
	}
	
	private void actualiserDonnees() {
		tableau = new Tableau(entetes, donnees);
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FenetrePrincipale extends JFrame {
	
	private JPanel panePrincipal;
	private JPanel paneTab;
	private PaneRecherche paneRecherche;
	private BarreMenu barreMenu;
	private Transjurassienne t;
	private PaneClassement paneClas;
	private PanePalmares panePalma;
	private PanePays panePay;
	private String annee, course;
	private boolean execute = false;
	


	public FenetrePrincipale(String titre) {
		super(titre);
		this.t = new Transjurassienne(this);;
		initComposant();
		initFenetre();
	}
	
	private void initComposant() {
		
		paneTab = new JPanel();
		paneTab.setLayout(new GridLayout(1, 3));
		
		paneRecherche = new PaneRecherche(t);
		
		panePrincipal = new JPanel();
		panePrincipal.setLayout(new GridLayout(2, 1));
		panePrincipal.add(paneTab);
		panePrincipal.add(paneRecherche);
		
		barreMenu = new BarreMenu(this);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(barreMenu, BorderLayout.NORTH);
		getContentPane().add(panePrincipal, BorderLayout.CENTER);
	}
	
	private void initFenetre() {
		setLocationRelativeTo(null);
		addWindowListener(new Fermeture());
		setSize(700,600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public void actualiserDonnee() {
		if(!execute){
			execute = true;
			paneClas = new PaneClassement(this);
			panePalma = new PanePalmares(t);
			panePay = new PanePays(t);
			paneTab.removeAll();
			paneTab.add(paneClas);
			paneTab.add(panePalma);
			paneTab.add(panePay);
		}
		paneClas.actualiserDonnees();
		
	}
	
	private void quitter() {
		Object options[] = {"OUI", "NON"};
		int n = JOptionPane.showOptionDialog(null, 
				"etes-vous sur(e) de vouloir quitter ?",
				"Confirmation", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null,
				options, options[1]);
		if (n == 0) System.exit(0);
	}
	
	private class Fermeture extends WindowAdapter {
		public void windowClosing(WindowEvent event) {
			quitter();
		 }
	}

	public Transjurassienne getTransjurassienne() {
		return t;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}

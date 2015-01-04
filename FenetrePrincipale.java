
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class FenetrePrincipale extends JFrame {
	
	private JPanel panePrincipal;
	private JPanel paneRens;
	private JPanel paneTab;
	
	private PaneRecherche paneRecherche;
	private PaneInfo paneInfo;
	private PaneClassement paneClas;
	private PanePalmares panePalma;
	private PanePays panePay;
	
	private BarreMenu barreMenu;
	
	private Transjurassienne t;
	
	private String annee, course;

	public FenetrePrincipale(String titre) {
		super(titre);
		this.t = new Transjurassienne(this);;
		initComposant();
		initFenetre();
	}
	
	private void initComposant() {
		paneClas = new PaneClassement(this);
		panePalma = new PanePalmares(this);
		panePay = new PanePays(this);
		
		
		paneTab = new JPanel();
		paneTab.setLayout(new GridLayout(1, 3));
		paneTab.add(paneClas);
		paneTab.add(panePalma);
		paneTab.add(panePay);
		
		paneInfo = new PaneInfo(this);
		paneRecherche = new PaneRecherche(t);
		
		paneRens = new JPanel();
		paneRens.setLayout(new BorderLayout());
		paneRens.add(paneInfo, BorderLayout.NORTH);
		paneRens.add(paneRecherche, BorderLayout.CENTER);
		
		panePrincipal = new JPanel();
		panePrincipal.setLayout(new GridLayout(2, 1));
		panePrincipal.add(paneTab);
		panePrincipal.add(paneRens);
		barreMenu= new BarreMenu(this);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panePrincipal, BorderLayout.CENTER);
		getContentPane().add(barreMenu, BorderLayout.NORTH);
		
	}
	
	
	private void initFenetre() {
		setIconImage(new ImageIcon(this.getClass().getResource(File.separator+"logo.png")).getImage());
		setLocation(100,100);
		addWindowListener(new Fermeture());
		setSize(1000,600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public void actualiserDonnee() {
		panePalma.actualiserDonnees();
		panePay.actualiserDonnees();
		paneClas.actualiserDonnees(true);
		paneInfo.actualiserDonnees();
		
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

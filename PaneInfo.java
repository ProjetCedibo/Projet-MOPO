import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class PaneInfo
 * affiche les statistiques ("heure" et "nombre participant")
 * 
 * @author Ibrahim Akrach
 * @author Cedric Petetin
 *
 */
@SuppressWarnings("serial")
public class PaneInfo extends JPanel {
	
		private FenetrePrincipale fen;
		private Transjurassienne tj;
		
		private Info infoTemps;
		private Info infolNbPart;
		
		public PaneInfo(FenetrePrincipale fp) {
			super();
			this.fen = fp;
			this.tj = fen.getTransjurassienne();
			
			initComposants();
			
			setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			setLayout(new GridLayout(1,2));
			add(infoTemps);
			add(infolNbPart);
		}
		
		private void initComposants() {
			infoTemps = new Info("Temps moyen");
			infolNbPart = new Info("Nombre participants");
		}

		public void actualiserDonnees(){
			infoTemps.setText("Temps moyen : " + tj.getAnnee(Integer.parseInt(fen.getAnnee())).
					getEpreuve(fen.getCourse()).DureeMoyenne());
			infolNbPart.setText("Nombre participants : "+ tj.getAnnee(Integer.parseInt(fen.getAnnee())).
					getEpreuve(fen.getCourse()).nombreParticipant());
		}
		
		private class Info extends JLabel {
			public Info (String txt) {
				super(txt);
				setVerticalAlignment(JLabel.CENTER);
				setFont(new Font("Arial" , 2 , 14));
				setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			}
			
		}
		
	}
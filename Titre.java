import java.awt.Font;

import javax.swing.JLabel;


public class Titre extends JLabel {

	public Titre(String titre) {
		super(titre);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		setFont(new Font("Times New Roman" , 1 , 16));
	}
}

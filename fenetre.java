import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;

import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;


public class fenetre extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public fenetre(Transjurassienne t) {
		setTitle("Transjurassienne");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		
		String tmp = "";
		for(int i = 0; i<t.getAnnee().size();i++){
			tmp = Integer.toString(t.getAnnee().get(i).getAnnee());
			JMenu menuItem = new JMenu(tmp);
			for(int j = 0; j<t.getAnnee().get(i).getEpreuve().size();j++){
				if(t.getAnnee().get(i).getEpreuve().get(j).Exist()){
					tmp = t.getAnnee().get(i).getEpreuve().get(j).getNomCourse();
					JMenuItem item = new JMenuItem(tmp);
					menuItem.add(item);
				}
				
			}
			menuBar.add(menuItem);
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
	}

}

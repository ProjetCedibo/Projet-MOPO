import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;


public class fenetre extends JFrame implements MouseListener{

	private JPanel contentPane;
	private ArrayList<MenuTop> menu;
	private ArrayList<JMenu> jmenu; 
	private Transjurassienne t;


	
	/**
	 * Create the frame.
	 */
	public fenetre(Transjurassienne t) {
		this.t = t;
		setTitle("Transjurassienne");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		jmenu= new ArrayList<JMenu>();
		menu = new ArrayList<MenuTop>();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		//les boutons du menu
		
		String tmp = "";
		for(int i = 0; i<t.getAnnee().size();i++){
			tmp = Integer.toString(t.getAnnee().get(i).getAnnee());
			jmenu.add(new JMenu(tmp));
			menu.add(new MenuTop());
			//les sous-menu
			for(int j = 0; j<t.getAnnee().get(i).getEpreuve().size();j++){
				if(t.getAnnee().get(i).getEpreuve().get(j).Exist()){
					tmp = t.getAnnee().get(i).getEpreuve().get(j).getNomCourse();
					menu.get(i).add(new JMenuItem(tmp));
				}
			}
			
		}
		for(int i = 0; i<menu.size();i++){
			menuBar.add(jmenu.get(i));
			for(int j =0; j<menu.get(i).size();j++){
				jmenu.get(i).add(menu.get(i).get(j));
				menu.get(i).get(j).addMouseListener(this);
			}
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
	}

	private class MenuTop extends ArrayList<JMenuItem>{
		
		public MenuTop(){
			super();
			
		}
		
	}
	
	private void action(int indiceMenu, int indiceMenuItem){
		String annee = jmenu.get(indiceMenu).getText();
		String course = menu.get(indiceMenu).get(indiceMenuItem-1).getText();
		System.out.println(annee + " "+ course +"\n");
		System.out.println(t.affiche10(annee, course, 0) + "\n");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		boolean stop = true;
		int indiceMenu = 0;
		int indiceMenuItem = 0;
		
		do{
			stop = menu.get(indiceMenu).get(indiceMenuItem) == e.getSource();
			indiceMenuItem++;
			if(!stop)
				if(indiceMenuItem >= menu.get(indiceMenu).size()){
					indiceMenuItem = 0;
					indiceMenu++;
				}
		}while(!stop && indiceMenu < menu.size());
		if(stop) action(indiceMenu, indiceMenuItem);
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

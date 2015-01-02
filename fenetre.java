import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Fenetre extends JFrame{
String txt2;
private JButton a;
private JButton b;
private JButton d;
private Container c;
private JPanel z2,z3;
public Fenetre() {
// mettre un titre à la fenetre
setTitle ("Transjurassienne");
// donner les dimensions de la fenetre
setSize(300,150);
// creer un conteneur c : couche sur laquel les objets graphiques vont etre incorpores
c=this.getContentPane();
a=new JButton("Rechercher un coureur");
b=new JButton("Classement par année");
d=new JButton("Palmares");
c.add(b,"Center");
c.add(a,"North");
c.add(d,"South");
EcouteurBoutonChoix ebc =new EcouteurBoutonChoix(this);
b.addActionListener(ebc);
txt2=ebc.txt;
this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public void itemStateChanged (ItemEvent ev) {
Object source=ev.getSource();
if (source== b) {
}
if (source== a) {
}
z2= new JPanel();
z2.setLayout(new FlowLayout(FlowLayout.LEFT));
z2.setBackground (Color.black);
//z2.add(lundi);
z3= new JPanel();
z3.setLayout(new FlowLayout(FlowLayout.LEFT));
z3.setBackground (Color.black);
//z3.add(lundi);
//z3.add(mardi);
c.add(z2);
c.add(z3);
z2.revalidate();
z3.revalidate();
}
}
package kus.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddingJPanels {

	public static void main(String... args) {
		JFrame jF = new JFrame();
		PanelMain pM = new PanelMain();
		
		Panel p = new Panel("sas");
		JPanel jp = makeJPanel(10);
		p.setPreferredSize(new Dimension(600,600));
		JScrollPane scroll = new JScrollPane();
		scroll.add(jp);
		JScrollBar verticalPane = scroll.getVerticalScrollBar();
		verticalPane.setValue(verticalPane.getMinimum());
		verticalPane.setValue(20);
		//scroll.setPreferredSize(new Dimension(570, 300));
		scroll.setPreferredSize(new Dimension(400,500));
		pM.add(scroll);
		//JTabbedPane tB = new JTabbedPane();
		//tB.addTab(":]", null, pM, "Tab 3");
		jF.add(scroll);
		jF.setSize(new Dimension(500,500));
		jF.setVisible(true);
	}

	
	
	
	
	
	static JPanel makeJPanel(int i){
		JPanel jPl = new JPanel();
		jPl.setLayout(new GridLayout(i,0));
		JLabel lebel;
		
		for(int j=0;j<i;++j){
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(2,2));
			JButton b = new JButton("asa");
			p.add(b);
			p.setBorder(BorderFactory.createLineBorder(Color.black));
			p.setPreferredSize(new Dimension(400,400));
			lebel = new JLabel("Napis: "+j);
			p.add(lebel);
			JTextField jTF = new JTextField("Nic",20);
			p.add(jTF);
			jPl.add(p);
		}
		return jPl;
	}
}

class Frame extends JFrame {
	public Frame() {
		super("Frame");
		this.setPreferredSize(new Dimension(200, 200));

	}

	public void see() {
		this.setVisible(true);
	}
}

class PanelMain extends JPanel {
	JButton b = new JButton("press me");
	
	public PanelMain() {
		this.add(b);
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Pressed");
			}
			
		});
	}
}

class Panel extends JPanel {
	JLabel l;

	public Panel(String s) {
		l = new JLabel(s);
		this.add(l);
	}
}




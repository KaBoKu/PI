package kus.swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class AddingJPanels {

	public static void main(String... args) {
		JFrame jF = new JFrame();
		PanelMain pM = new PanelMain();
		
		Panel p = new Panel("sas");
		JScrollPane scroll = new JScrollPane();
		scroll.add(p);
		scroll.setPreferredSize(new Dimension(400,500));
		pM.add(scroll);
		JTabbedPane tB = new JTabbedPane();
		tB.addTab(":]", null, pM, "Tab 3");
		jF.add(tB);
		jF.setVisible(true);
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
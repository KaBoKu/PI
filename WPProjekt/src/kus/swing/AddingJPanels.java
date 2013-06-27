package kus.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class AddingJPanels {

	public static void main(String... args) {
		JFrame jF = new JFrame();
		PanelMain pM = new PanelMain();
		JTextArea textAreal = new JTextArea("lalamido", 5, 10);
		textAreal.setEditable(false);
		textAreal.setPreferredSize(new Dimension(465, 530));
		textAreal.setLineWrap(true);
		textAreal.setBackground(new Color(228, 228, 226));
		Border br = new BevelBorder(BevelBorder.LOWERED);
		textAreal.setBorder(br);
		textAreal.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 16));
		
		Panel p = new Panel("sas");
		JPanel jp = makeJPanel(10);
		p.setPreferredSize(new Dimension(200,200));
		JScrollPane scroll = new JScrollPane(jp);
		//scroll.add(textAreal);
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
			p.setLayout(new GridBagLayout());
			GridBagConstraints gBC = new GridBagConstraints();
			JButton b = new JButton("asa");
			
			
			gBC.weightx = 0;
			gBC.weighty = 0;
			gBC.gridx = 0;
			gBC.gridy = 0;
			gBC.gridwidth = 1;
			gBC.insets = new Insets(30, 0, 0, 0);
			gBC.anchor = GridBagConstraints.NORTH;
			
			p.add(b,gBC);
			p.setBorder(BorderFactory.createLineBorder(Color.black));
			p.setPreferredSize(new Dimension(400,400));
			lebel = new JLabel("Napis: "+j);
			
			gBC.weightx = 0;
			gBC.weighty = 0;
			gBC.gridx = 0;
			gBC.gridy = 1;
			gBC.gridwidth = 1;
			gBC.insets = new Insets(30, 0, 0, 0);
			gBC.anchor = GridBagConstraints.NORTH;
			
			p.add(lebel);
			JTextField jTF = new JTextField("Nic",20);
			
			
			gBC.weightx = 0;
			gBC.weighty = 0;
			gBC.gridx = 0;
			gBC.gridy = 3;
			gBC.gridwidth = 1;
			gBC.insets = new Insets(30, 0, 0, 0);
			gBC.anchor = GridBagConstraints.NORTH;
			
			p.add(jTF);
			PanelMain pM = new PanelMain();
			jPl.add(pM);
		}
		return jPl;
	}
}


class PanelMain extends JPanel {
	JButton b = new JButton("press MEEEE");
	static int l=0;
	public PanelMain() {
		this.add(b);
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l+=1;;
				System.out.println("l :"+l);
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




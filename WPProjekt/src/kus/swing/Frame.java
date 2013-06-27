package kus.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Frame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jF = new JFrame();
		jF.setSize(new Dimension(600, 800));
		JPanel p = createEventPanel();
		//jF.add(p);
		//jF.pack();
		
		JScrollPane jSP = new JScrollPane();
		jSP.setSize(400,400);
		jSP.add(p);
		
		JScrollPane scrollBar=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		jF.add(scrollBar);
		jF.setVisible(true);
		
	}

	static protected JPanel createEventPanel() {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gBC = new GridBagConstraints();
		JPanel jPanel = new JPanel();
		jPanel.setLayout(gridBag);
		jPanel.setPreferredSize(new Dimension(400, 400));
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		JButton Done = new JButton("Dodaj");
		JLabel Start = new JLabel("Data Rozpoczêcia");
		JLabel End = new JLabel("Data Zakoñczenia");
		JLabel Title = new JLabel("Tytu³");
		JLabel About = new JLabel("Opis");
		JLabel Where = new JLabel("Gdzie");
		JFormattedTextField DataStart = new JFormattedTextField(df);
		DataStart.setColumns(10);
		JFormattedTextField DataEnd = new JFormattedTextField(df);
		DataEnd.setColumns(10);
		JTextField TitleField = new JTextField("", 20);
		JTextField AboutField = new JTextField("", 20);
		JTextField WhereField = new JTextField("", 20);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 0;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(Start, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 0;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(DataStart, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 2;
		gBC.gridy = 0;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(End, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 3;
		gBC.gridy = 0;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(DataEnd, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(Title, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(TitleField, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 2;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(About, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 3;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(AboutField, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 2;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(Where, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 2;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.NORTH;
		gBC.insets = new Insets(0, 0, 0, 0);

		jPanel.add(WhereField, gBC);

		//jPanel.setPreferredSize(new Dimension(200, 200));
		//jPanel.setSize(200, 200);
		jPanel.setBackground(Color.BLUE);
		return jPanel;

	}
}

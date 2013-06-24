package kus.jcalendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;

public class Kalendar extends JPanel {
	JCalendar jC;
	JButton jBut;
	String data;
	public Kalendar() {
		super();
		jC = new JCalendar();
		this.setPreferredSize(new Dimension(100, 100));
		// jC.addPropertyChangeListener(this);
		jC.isWeekOfYearVisible();
		// jC.propertyChange(null);new Color (246, 27, 27)
		jC.setDecorationBackgroundColor(new Color(246, 27, 27));
		jC.setWeekOfYearVisible(false);
		jC.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				// System.out.println(evt);
				
				if ("calendar".equals(evt.getPropertyName())) {
					System.out.println(evt.getPropertyName() + ": "
							+ evt.getNewValue());
					//(GregorianCalendar) evt
					Calendar cal = (Calendar) evt.getNewValue();

					   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					
					
					System.out.println(data=dateFormat.format(cal.getTime()));
				}
			}

		});
		jBut = new JButton("Data");
		jBut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Data press");
				JOptionPane.showMessageDialog(null,  "The runtime for  short integers is "+data, "Final Runtime", JOptionPane.PLAIN_MESSAGE);

			}});
		this.setLayout(new FlowLayout());
		add(jC);
		add(jBut);
	}

	// @Override
	// public void propertyChange(PropertyChangeEvent arg0) {

	// }
}

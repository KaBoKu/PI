package kus.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;

import kus.eventy.Event;
import kus.eventy.Countdown.EventsHolder;
import kus.eventy.owner.Owner;
import kus.eventy.strategy.StrategyMail;
import kus.eventy.strategy.StrategySound;
import kus.parser.SwingNBPParser;
import kus.parser.SwingParser;
import kus.parser.WeatherParser;

import com.toedter.calendar.JCalendar;

public class Window extends JFrame {

	/**
	 * Launch the application.
	 */

	private JTextArea textAreal;
	private String www2;

	JTextField name;
	JTextField surname;
	JTextField email;
	JTextField phone;
	JTextField about;

	private JLabel countLabel1;
	private JLabel countLabelabout1;
	private JLabel countLabel2;
	private JLabel countLabelabout2;
	private JLabel countLabel3;
	private JLabel countLabelabout3;
	private JLabel countLabel4;
	private JLabel countLabelabout4;
	private JLabel countLabel5;
	private JLabel countLabelabout5;
	private JLabel countLabel6;
	private JLabel countLabelabout6;

	SwingNBPParser sNBP;
	WeatherParser wP;
	static Owner own;
	String ala = "koala";
	EventsHolder eHolder;

	JFormattedTextField jTDateStart;
	JFormattedTextField jTDateEnd;
	JTextField jTTitle;
	JTextField jTWhere;
	JTextField jTAbout;

	JCheckBox CEmail;
	JCheckBox CSound;

	JButton jButt;

	public static void main(String[] args) {
		own = own.INSTANCE;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen splash = SplashScreen.getSplashScreen();
					if (splash == null)
						System.out.println("null");

					Graphics2D g = (Graphics2D) splash.createGraphics();

					Dimension dim = splash.getSize();
					for (int i = 0; i < 1000; i++) {
						g.setColor(Color.RED);
						g.fillRect(50, 350, i / 2 - 70, 20);
						splash.update();
						try {
							Thread.sleep(5);
						} catch (InterruptedException ignored) {
						}
					}
					Window window = new Window();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		eHolder = new EventsHolder();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// new JFrame();
		//
		/*
		 * own.setAbout("Brak"); own.setEmail("Brak"); own.setName("Brak");
		 * own.setPhone("Brak"); own.setSurname("Brak");
		 */
		this.setBounds(300, 300, 650, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setDefaultLookAndFeelDecorated(true);

		ImagePanel panel = new ImagePanel(
				new ImageIcon(
						"D:/WorkSpaceJuno/WPProjekt/src/kus/swing/134757.jpg")
						.getImage());

		JTabbedPane jtbExample = new JTabbedPane();
		JPanel jplInnerPanel1 = createWeather();

		jtbExample.setBackground(Color.cyan);

		jplInnerPanel1.setBackground(Color.RED);

		jtbExample.addTab("Pogoda", null, jplInnerPanel1, "Tab 1");
		jtbExample.setSelectedIndex(0);

		jtbExample.addTab("Pogoda", null, jplInnerPanel1, "Tab 2");
		JPanel jplInnerPanel2 = createXMLPanel("TVN24",
				"http://www.tvn24.pl/najwazniejsze.xml", "UTF-8");
		jtbExample.addTab("RSSKana³ TVN24", null, jplInnerPanel2, "Tab 3");
		JPanel jplInnerPanel3 = createXMLPanel("Gazeta",
				"http://rss.gazeta.pl/pub/rss/wiadomosci_kraj.htm",
				"ISO-8859-2");
		jtbExample.addTab("RSSKana³ Gazeta", null, jplInnerPanel3, "Tab 4");
		JPanel jplInnerPanel4 = createXMNBP("NBP");
		jtbExample.addTab("Kursy Walut NBP", null, jplInnerPanel4, "Tab 5");
		// Add the tabbed pane to this panel.

		JPanel jplInnerPanel5 = createOwnerPanel();
		jtbExample.addTab("Dane u¿ytkownika", null, jplInnerPanel5, "Tab 6");
		JPanel jplInnerPanel6 = createCalendarPanel();
		jtbExample.addTab("Kalendarz", null, jplInnerPanel6, "Tab 7");

		JPanel jplInnerPanel7 = createTerminarzPanel();
		// jtbExample.addTab("Terminy", null, jplInnerPanel7, "Tab 8");
		setLayout(new GridLayout(1, 1));
		add(jtbExample);

	}

	protected class ImagePanel extends JPanel {
		private Image img;

		public ImagePanel(String img) {
			this(new ImageIcon(img).getImage());
		}

		public ImagePanel(Image img) {
			this.img = img;
			Dimension size = new Dimension(img.getWidth(null),
					img.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			// setLayout(null);
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}

	}

	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}

	protected JPanel createXMLPanel(String text, String www, String encoding) {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gBC = new GridBagConstraints();
		// this.setBackground(Color.black);
		JButton jButton = new JButton("Odœwie¿");

		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		SwingParser sP = null;
		try {
			sP = new SwingParser(www, encoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		text = sP.getXML();
		textAreal = new JTextArea(text, 5, 10);
		textAreal.setEditable(false);
		textAreal.setPreferredSize(new Dimension(400, 300));
		textAreal.setLineWrap(true);
		Border br = new BevelBorder(BevelBorder.LOWERED);
		textAreal.setBorder(br);
		textAreal.setFont(new Font("Verdana", Font.BOLD, 16));
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(gridBag);
		www2 = www;

		JScrollPane scroll = new JScrollPane(textAreal);
		scroll.setPreferredSize(new Dimension(400, 300));

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SwingParser sP = null;
				try {
					sP = new SwingParser(www2, "");
				} catch (UnsupportedEncodingException eX) {
					// TODO Auto-generated catch block
					eX.printStackTrace();
				}

				String s = sP.getXML();
				textAreal.setText(s);
			}

		});

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 0;
		gBC.gridwidth = 2;
		gBC.anchor = GridBagConstraints.NORTH;

		jplPanel.add(jlbDisplay, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.WEST;

		jplPanel.add(scroll/* textAreal */, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.PAGE_START;

		jplPanel.add(jButton, gBC);
		return jplPanel;
	}

	protected JPanel createXMNBP(String text) {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gBC = new GridBagConstraints();

		JButton jButton = new JButton("Odœwie¿");

		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);

		sNBP = new SwingNBPParser();

		textAreal = new JTextArea(sNBP.getXML(), 5, 10);
		textAreal.setEditable(false);
		textAreal.setPreferredSize(new Dimension(400, 300));
		textAreal.setLineWrap(true);
		textAreal.setFont(new Font("Verdana", Font.BOLD, 18));

		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(gridBag);

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = sNBP.getXML();
				textAreal.setText(sNBP.getXML());
			}

		});

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 0;
		gBC.gridwidth = 2;
		gBC.anchor = GridBagConstraints.NORTH;

		jplPanel.add(jlbDisplay, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.WEST;

		jplPanel.add(textAreal, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.PAGE_START;

		jplPanel.add(jButton, gBC);
		return jplPanel;
	}

	protected JPanel createWeather() {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gBC = new GridBagConstraints();
		;// = new WeatherParser();
		JButton jButton = new JButton("Odœwie¿");

		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel("Pogoda");

		sNBP = new SwingNBPParser();

		textAreal = new JTextArea(wP.HTML(), 5, 10);
		textAreal.setEditable(false);
		Border br = new BevelBorder(BevelBorder.LOWERED);
		textAreal.setBorder(br);

		textAreal.setPreferredSize(new Dimension(400, 300));
		textAreal.setLineWrap(true);
		textAreal.setFont(new Font("Verdana", Font.BOLD, 18));
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(gridBag);

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = sNBP.getXML();
				textAreal.setText(wP.HTML());
			}

		});

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 0;
		gBC.gridwidth = 2;
		gBC.anchor = GridBagConstraints.NORTH;

		jplPanel.add(jlbDisplay, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.WEST;

		jplPanel.add(textAreal, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.PAGE_START;

		jplPanel.add(jButton, gBC);
		return jplPanel;
	}

	protected JPanel createOwnerPanel() {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gBC = new GridBagConstraints();

		JLabel labEmail = new JLabel("Mail: ");
		JLabel labName = new JLabel("Imiê: ");
		JLabel labPhone = new JLabel("Numer telefonu: ");
		JLabel labAbout = new JLabel("Info: ");
		JLabel labSurname = new JLabel("Nazwisko: ");
		email = new JTextField("", 20);
		name = new JTextField("", 20);
		phone = new JTextField("", 20);
		about = new JTextField("", 20);
		surname = new JTextField("", 20);
		JButton jButton = new JButton("Aktualuizuj");
		this.email.setText("email " + own.getEmail());
		this.name.setText("name " + own.getName());
		this.phone.setText("phone " + own.getPhone());
		this.about.setText("about " + own.getAbout());
		this.surname.setText("surname " + own.getSurname());
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel("U¿ytkownik");
		/*email.setPreferredSize(new Dimension(100, 10));
		email.setSize(100, 10);*/
		sNBP = new SwingNBPParser();

		jlbDisplay.setHorizontalAlignment(JLabel.RIGHT);
		// jplPanel.setLayout(gridBag);
		//GridLayout gL = new GridLayout(6, 2, 15, 30);
		jplPanel.setLayout(gridBag);
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				own.setEmail(email.getText());
				own.setAbout(about.getText());
				own.setName(name.getText());
				own.setPhone(phone.getText());
				own.setSurname(surname.getText());

				email.setText(own.getEmail());
				about.setText(own.getAbout());
				name.setText(own.getName());
				phone.setText(own.getPhone());
				surname.setText(own.getSurname());

			}

		});

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 0;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_END;
		// email.setPreferredSize(preferredSize)
		jplPanel.add(labEmail, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 0;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_START;
		// email.setPreferredSize(preferredSize)
		jplPanel.add(email, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_END;

		// email.setPreferredSize(preferredSize)
		jplPanel.add(labName, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_START;

		jplPanel.add(name, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 2;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_END;

		// email.setPreferredSize(preferredSize)
		jplPanel.add(labSurname, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 2;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_START;

		jplPanel.add(surname, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 3;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_END;

		// email.setPreferredSize(preferredSize)
		jplPanel.add(labPhone, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 3;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_START;

		jplPanel.add(phone, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 4;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_END;

		// email.setPreferredSize(preferredSize)
		jplPanel.add(labAbout, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 4;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_START;

		jplPanel.add(about, gBC);
//
		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.LINE_END;

	//	jplPanel.add(jButton, gBC);

		return jplPanel;
	}

	protected JPanel createCalendarPanel() {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gBC = new GridBagConstraints();

		ImagePanel jplPanel = new ImagePanel(
				"D:/WorkSpaceJuno/WPProjekt/src/kus/swing/kalendarz.jpg");

		jplPanel.setPreferredSize(new Dimension(300, 300));
		jplPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

		// jplPanel.setLayout(gridBag);
		Kalendar kal = new Kalendar();
		// this.setLayout(new BoxLayout(kal, BoxLayout.X_AXIS));
		// kal.setSize(200, 300);
		kal.setPreferredSize(new Dimension(170, 165));
		jplPanel.add(kal);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 0;
		gBC.gridwidth = 0;
		gBC.anchor = GridBagConstraints.CENTER;
		gBC.ipadx = 0;
		gBC.ipady = 0;
		// kal.setPreferredSize(new Dimension(300, 300));
		// kal.setBounds(0, 0, 150, 150);
		// jplPanel.add(kal, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.WEST;

		// jplPanel.add(name, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 2;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.WEST;

		// jplPanel.add(surname, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 0;
		gBC.gridy = 3;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.WEST;

		// jplPanel.add(phone, gBC);

		gBC.weightx = 0.5;
		gBC.weighty = 0.5;
		gBC.gridx = 1;
		gBC.gridy = 1;
		gBC.gridwidth = 1;
		gBC.anchor = GridBagConstraints.PAGE_START;

		// jplPanel.add(jButton, gBC);
		return jplPanel;
	}

	protected class Kalendar extends JPanel {
		JCalendar jC;
		JButton jBut;
		String data;

		class AboutDialog extends JDialog implements ActionListener {
			public AboutDialog(JFrame parent, String title, String message,
					Date data) {
				/*
				 * Date start; Date end; boolean emailWaring; boolean
				 * soundWaring; private String title; String where; String
				 * about;
				 */

				super(parent, title, true);
				Date dataInner = data;
				JLabel lDateStart = new JLabel("Pocz¹tek");
				JLabel lDateEnd = new JLabel("Koniec");
				JLabel lEmailW = new JLabel("Email powiadomienie");
				JLabel lSoundW = new JLabel("DŸwiêk powiadomienie");
				JLabel lTitle = new JLabel("Nazwa");
				JLabel lWhere = new JLabel("Gdzie");
				JLabel lAbout = new JLabel("Opis");

				jTDateStart = new JFormattedTextField(new DateFormatter(
						new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa",
								Locale.ENGLISH)));
				jTDateEnd = new JFormattedTextField(new DateFormatter(
						new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa",
								Locale.ENGLISH)));
				jTTitle = new JTextField("Nazwa", 20);
				jTWhere = new JTextField("Gdzie", 20);
				jTAbout = new JTextField("Opis", 20);

				jTDateStart.setEditable(true);

				CEmail = new JCheckBox("Email powiadomienie");
				CSound = new JCheckBox("DŸwiêk powiadomienie");

				JButton jButt = new JButton("Ustaw");

				GridBagLayout gridBag = new GridBagLayout();
				GridBagConstraints gBC = new GridBagConstraints();

				Event e = new Event();
				eHolder.add(e);
				if (parent != null) {
					Dimension parentSize = parent.getSize();
					Point p = parent.getLocation();
					setLocation(p.x + parentSize.width / 4, p.y
							+ parentSize.height / 4);
				}
				this.setLayout(gridBag);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 0;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.PAGE_END;
				// email.setPreferredSize(preferredSize)
				this.add(lDateStart, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 1;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.CENTER;
				// email.setPreferredSize(preferredSize)
				jTDateStart.setValue(dataInner);
				this.add(jTDateStart, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 2;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.PAGE_END;
				// email.setPreferredSize(preferredSize)
				this.add(lDateEnd, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 3;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.CENTER;
				// jTDateEnd.setBounds(135, 34, 187, 19);
				jTDateEnd.setPreferredSize(new Dimension(150, 20));
				this.add(jTDateEnd, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 4;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.PAGE_END;
				// email.setPreferredSize(preferredSize)
				this.add(lTitle, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 5;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.CENTER;

				this.add(jTTitle, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 6;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.PAGE_END;
				// email.setPreferredSize(preferredSize)
				this.add(lWhere, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 7;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.CENTER;

				this.add(jTWhere, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 8;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.PAGE_END;
				// email.setPreferredSize(preferredSize)
				this.add(lAbout, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = 9;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.CENTER;

				this.add(jTAbout, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 1;
				gBC.gridy = 3;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.CENTER;

				this.add(jButt, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 1;
				gBC.gridy = 4;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.CENTER;
				this.add(CEmail, gBC);

				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 1;
				gBC.gridy = 5;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.CENTER;

				this.add(CSound, gBC);

				JPanel messagePane = new JPanel();

				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.setSize(600, 800);

				jButt.addActionListener(this);

				setVisible(true);
			}

			// GridBagLayout gBag = new GridBagLayout();
			// GridBagConstraints gBC = new GridBagConstraints();

			public void actionPerformed(ActionEvent e) {
				Event eV = new Event();
				eV.setStart((Date) jTDateStart.getValue());
				eV.setEnd((Date) jTDateEnd.getValue());
				eV.setAbout(jTAbout.getText());
				eV.setTitle(jTTitle.getText());
				eV.setWhere(jTWhere.getText());

				eV.setEmailWaring(CEmail.isSelected());
				eV.setSoundWaring(CSound.isSelected());

				StrategySound sS = new StrategySound();
				StrategyMail sM = new StrategyMail(sS);
				eV.setsT(sM);
				// eV.setsT(al);

				eHolder.add(eV);
				setVisible(false);
				dispose();
			}
		}

		public Kalendar() {
			super();
			jC = new JCalendar();
			jC.setMinimumSize(new Dimension(300, 300));
			// this.setPreferredSize(new Dimension(500, 500));
			// this.setSize(350, 350);
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
						// (GregorianCalendar) evt
						Calendar cal = (Calendar) evt.getNewValue();

						DateFormat dateFormat = new SimpleDateFormat(
								"yyyy/MM/dd HH:mm:ss");

						System.out.println(data = dateFormat.format(cal
								.getTime()));
						AboutDialog dlg = new AboutDialog(new JFrame(),
								"Wydarzenie", "Wydarzenie", cal.getTime());

					}
				}

			});
			jBut = new JButton("Data");
			jBut.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("Data press");
					JOptionPane.showMessageDialog(null,
							"The runtime for  short integers is " + data,
							"Final Runtime", JOptionPane.PLAIN_MESSAGE);

				}
			});
			// this.setLayout(new FlowLayout());
			add(jC);
			// add(jBut);
		}

		// @Override
		// public void propertyChange(PropertyChangeEvent arg0) {

		// }
	}

	protected ImagePanel createTerminarzPanel() {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gBC = new GridBagConstraints();

		// = new WeatherParser();
		int i = eHolder.size();
		ImagePanel jplPanel = new ImagePanel(
				"D:/WorkSpaceJuno/WPProjekt/src/kus/swing/papier.jpg");
		countLabel1 = new JLabel();
		countLabelabout1 = new JLabel();
		countLabel2 = new JLabel();
		countLabelabout2 = new JLabel();
		countLabel3 = new JLabel();
		countLabelabout3 = new JLabel();
		countLabel4 = new JLabel();
		countLabelabout4 = new JLabel();
		countLabel5 = new JLabel();
		countLabelabout5 = new JLabel();
		countLabel6 = new JLabel();
		countLabelabout6 = new JLabel();
		JLabel tab[] = new JLabel[12];
		tab[0] = countLabel1;
		tab[1] = countLabelabout1;
		tab[2] = countLabel2;
		tab[3] = countLabelabout2;
		tab[4] = countLabel3;
		tab[5] = countLabelabout3;
		tab[6] = countLabel4;
		tab[7] = countLabelabout4;
		tab[8] = countLabel5;
		tab[9] = countLabelabout5;
		tab[10] = countLabel6;
		tab[11] = countLabelabout6;
		JButton b = new JButton("Asdas");
		jplPanel.setLayout(gridBag);

		if (i != 0) {
			countLabel1.setText("Nie ma ¿adnych eventów");
			gBC.weightx = 0.5;
			gBC.weighty = 0.5;
			gBC.gridx = 0;
			gBC.gridy = 0;
			gBC.gridwidth = 2;
			gBC.anchor = GridBagConstraints.NORTH;
			gBC.ipadx = 10;
			gBC.ipady = 10;
			jplPanel.add(countLabel1, gBC);
		} else {
			for (int j = 0; j < 6; ++j) {
				gBC.weightx = 0.5;
				gBC.weighty = 0.5;
				gBC.gridx = 0;
				gBC.gridy = j;
				gBC.gridwidth = 1;
				gBC.anchor = GridBagConstraints.NORTH;
				gBC.ipadx = 10;
				gBC.ipady = 10;
				tab[j].setText("text");
				tab[j + 1].setText("info o event");
				jplPanel.add(tab[j], gBC);
			}
		}
		/*
		 * jButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO
		 * Auto-generated method stub own.setEmail(email.getText());
		 * own.setAbout(about.getText()); own.setName(name.getText());
		 * own.setPhone(phone.getText()); own.setSurname(surname.getText());
		 * 
		 * email.setText(own.getEmail()); about.setText(own.getAbout());
		 * name.setText(own.getName()); phone.setText(own.getPhone());
		 * surname.setText(own.getSurname());
		 * 
		 * }
		 * 
		 * });
		 * 
		 * gBC.weightx = 0.5; gBC.weighty = 0.5; gBC.gridx = 0; gBC.gridy = 0;
		 * gBC.gridwidth = 2; gBC.anchor = GridBagConstraints.WEST; gBC.ipadx =
		 * 10; gBC.ipady = 10; kal.setPreferredSize(new Dimension(300, 300));
		 * jplPanel.add(kal, gBC);
		 * 
		 * gBC.weightx = 0.5; gBC.weighty = 0.5; gBC.gridx = 0; gBC.gridy = 1;
		 * gBC.gridwidth = 1; gBC.anchor = GridBagConstraints.WEST;
		 * 
		 * // jplPanel.add(name, gBC);
		 * 
		 * gBC.weightx = 0.5; gBC.weighty = 0.5; gBC.gridx = 0; gBC.gridy = 2;
		 * gBC.gridwidth = 1; gBC.anchor = GridBagConstraints.WEST;
		 * 
		 * // jplPanel.add(surname, gBC);
		 * 
		 * gBC.weightx = 0.5; gBC.weighty = 0.5; gBC.gridx = 0; gBC.gridy = 3;
		 * gBC.gridwidth = 1; gBC.anchor = GridBagConstraints.WEST;
		 * 
		 * // jplPanel.add(phone, gBC);
		 * 
		 * gBC.weightx = 0.5; gBC.weighty = 0.5; gBC.gridx = 1; gBC.gridy = 1;
		 * gBC.gridwidth = 1; gBC.anchor = GridBagConstraints.PAGE_START;
		 */
		// jplPanel.add(jButton, gBC);
		return jplPanel;
	}

}

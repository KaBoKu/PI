package kus.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JDialogCenterExample
{
  static JFrame frame;
 static String ala = "";
  public static void main(String[] args)
  {
    // schedule this for the event dispatch thread (edt)
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        displayJFrame();
      }
    });
  }

  static void displayJFrame()
  {
    frame = new JFrame("Our JDialog Center Example");

    // create our jbutton, then tell it what to do when
    // it is pressed
    JButton showDialogButton = new JButton("Show Dialog");
    showDialogButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // display/center the jdialog when the button is pressed
        ala = "ola";
    	  JDialog d = new JDialog(frame, "Hello", true);
        JLabel l = new JLabel(ala);
    	  d.add(l);
    	  d.setLocationRelativeTo(frame);
        d.setVisible(true);
      }
    });

    // put the button on the frame
    frame.getContentPane().setLayout(new FlowLayout());
    frame.add(showDialogButton);

    // set up the jframe, then display it
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(300, 200));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
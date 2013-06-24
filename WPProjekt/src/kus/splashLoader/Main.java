package kus.splashLoader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
  public static void main(String args[]) throws Exception{
    SplashScreen splash = SplashScreen.getSplashScreen();
    if(splash == null)System.out.println("null");
    
    Graphics2D g = (Graphics2D) splash.createGraphics();
    
    Dimension dim = splash.getSize();
    for (int i = 0; i < 1000; i++) {
      g.setColor(Color.RED);
      g.fillRect(50, 300, i/2 - 70, 20);
      splash.update();
      try {
        Thread.sleep(5);
      } catch (InterruptedException ignored) {
      }
    }
    JFrame frame = new JFrame("Splash Me2");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel label = new JLabel("Hello, Splash", JLabel.CENTER);
    frame.add(label, BorderLayout.CENTER);
    frame.setSize(300, 95);
    frame.setVisible(true);
  }
}


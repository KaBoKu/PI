package kus.splashLoader;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Rectangle2D;

public class SplashDemo extends Frame implements ActionListener {
    static void renderSplashFrame(Graphics2D g, int frame, Rectangle2D.Double pB) {
        final String[] comps = {"foo", "bar", "baz"};
        //Font font = new Font("Arial", Font.PLAIN, 24);
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120,140,200,40);
        g.setPaintMode();
        g.setColor(Color.RED);
        //g.setFont(font);
        int x = (int) pB.x;
        int y = (int) pB.y;
        int wid = (int) pB.getWidth();
        int hgt = (int) pB.getHeight();
        frame = (int) (wid*frame/100.0f);
        g.fillRect(x, y+1, frame, hgt-1);
        //g.drawString("Loading "+comps[(frame/5)%3]+"...", 250, 50);     
    }
    public SplashDemo() {
        super("SplashScreen demo");
        setSize(300, 200);
        setLayout(new BorderLayout());
        Menu m1 = new Menu("File");
        MenuItem mi1 = new MenuItem("Exit");
        m1.add(mi1);
        mi1.addActionListener(this);
        this.addWindowListener(closeWindow);
        
        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        mb.add(m1);
        final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }
        Graphics2D splashGraphics = splash.createGraphics();
        Dimension ssDim = splash.getSize();
        int heightSplash = ssDim.height;
        int widthSplash = ssDim.width;
        Rectangle2D.Double splashProgressArea = new Rectangle2D.Double(widthSplash * .25, heightSplash*.92, widthSplash*.4, 12 );
        splashGraphics.setPaint(Color.BLUE);
        splashGraphics.draw(splashProgressArea);
        splashGraphics.setPaint(Color.LIGHT_GRAY);
        splashGraphics.fill(splashProgressArea);
        
        for(int i=0; i<100; i++) {
            renderSplashFrame(g, i, splashProgressArea);
            splash.update();
            try {
                Thread.sleep(90);
            }
            catch(InterruptedException e) {
            }
        }
       
        
        //splashProgress(0);
       
        splash.close();
        setVisible(true);
        toFront();
    }
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
    
    private static WindowListener closeWindow = new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            e.getWindow().dispose();
        }
    };
    
    public static void main (String args[]) {
        SplashDemo test = new SplashDemo();
    }
}
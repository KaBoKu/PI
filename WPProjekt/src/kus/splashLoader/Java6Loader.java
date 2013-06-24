package kus.splashLoader;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

class Java6Loader implements Loader {
	 
    private static final long serialVersionUID = 1L;

    private SplashScreen screen;

    private Renderer renderer;

    public Java6Loader() {
            screen = SplashScreen.getSplashScreen();
            if (screen == null) {
                    System.out.println("Splash Screen not supported");
                    return;
            }
    }

    public void configure() {
            renderer.configure(this);
    }

    public void done() {
            if (screen != null) {
                    screen.close();
            }
    }

    public Graphics2D getGraphics() {
            return screen == null ? null : screen.createGraphics();
    }

    public Dimension getSize() {
            return screen == null ? new Dimension(0, 0) : screen.getSize();
    }

    public void setRenderer(Renderer renderer) {
            this.renderer = renderer;
    }

    public void update(int step) {
            if (screen != null) {
                    renderer.render(getGraphics(), step);
                    screen.update();
            }
    }
}
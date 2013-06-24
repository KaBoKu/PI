package kus.splashLoader;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
 
public class Java5Loader implements Loader {
 
        private final Dimension size = new Dimension(800, 600);
        private final Frame frame = new Frame();
        private Image image;
        private Graphics2D graphics;
        private Renderer renderer;
 
        public Java5Loader(String imageSRC) {
                image = frame.getToolkit().getImage(imageSRC);
                frame.setUndecorated(true);
                frame.setSize(size);
                frame.setVisible(true);
                int screenHeight = frame.getGraphicsConfiguration().getDevice()
                                .getDisplayMode().getHeight();
                int screenWidth = frame.getGraphicsConfiguration().getDevice()
                                .getDisplayMode().getWidth();
                frame.setLocation((int) ((screenWidth - size.getWidth()) * 0.5),
                                (int) ((screenHeight - size.getHeight()) * 0.5));
        }
 
        @Override
        public void configure() {
                renderer.configure(this);
        }
 
        private void createGraphics() {
                graphics = (Graphics2D) frame.getGraphics();
                graphics.drawImage(image, 0, 0, null);
        }
 
        @Override
        public void done() {
                frame.setVisible(false);
                frame.dispose();
        }
 
        @Override
        public Graphics2D getGraphics() {
                createGraphics();
                return graphics;
        }
 
        @Override
        public Dimension getSize() {
                return size;
        }
 
        public void setRenderer(Renderer renderer) {
                this.renderer = renderer;
        }
 
        @Override
        public void update(int step) {
                renderer.render(getGraphics(), step);
        }
 
}

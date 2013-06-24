package kus.splashLoader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
 
public class DefaultRenderer implements Renderer{
 
        private static final int barHeight = 18;
        private static final int barWidth = 200;
        private int posX;
        private int posY;
        private int bytesWidth;
        private int bytesHeight;
 
        public void configure(Loader loader) {
                Dimension size = loader.getSize();
                posX = (int) (0.5 * (size.getHeight() - barHeight));
                posY = (int) (0.9 * (size.getWidth() - barWidth));
                if (loader.getGraphics() != null) {
                        FontMetrics fontMetrics = loader.getGraphics().getFontMetrics();
                        bytesWidth = 50 + (int) (0.25 * (fontMetrics.bytesWidth(
                                        "Loading 00%"
                                                        .getBytes(), 0, 11)));
                        bytesHeight = (int) (fontMetrics.getHeight() + ((barHeight * 0.75 - fontMetrics
                                        .getHeight()) * 0.75));
                }
        }
 
        public void render(Graphics2D splashScreen, int step) {
                splashScreen.setColor(Color.GRAY);
                splashScreen.fillRect(posX, posY, barWidth, barHeight);
                splashScreen.setColor(Color.BLACK);
                splashScreen.fillRect(posX, posY, (step * barWidth / 100), barHeight);
                splashScreen.setColor(Color.WHITE);
                splashScreen.drawString("Loading "
                                + (step < 10 ? (" " + step) : (step)) + "%", posX + bytesWidth,
                                posY + bytesHeight);
        }
}
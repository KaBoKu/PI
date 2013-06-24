package kus.splashLoader;

import java.awt.Graphics2D;

public interface Renderer {
 
        /**
         * Okre�la po�o�enie paska post�pu i konfiguruje renderer na podstawie {@link Loader Loadera}.
         * @param loader 
         */
        public abstract void configure(Loader loader);
 
        /**
         * Renderuje pasek post�pu dla danego kroku.
         * @param splashScreen
         * @param step
         */
        public abstract void render(Graphics2D splashScreen, int step);
 
}
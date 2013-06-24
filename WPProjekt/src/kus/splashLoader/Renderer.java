package kus.splashLoader;

import java.awt.Graphics2D;

public interface Renderer {
 
        /**
         * Okreœla po³o¿enie paska postêpu i konfiguruje renderer na podstawie {@link Loader Loadera}.
         * @param loader 
         */
        public abstract void configure(Loader loader);
 
        /**
         * Renderuje pasek postêpu dla danego kroku.
         * @param splashScreen
         * @param step
         */
        public abstract void render(Graphics2D splashScreen, int step);
 
}
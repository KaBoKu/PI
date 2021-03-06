package kus.splashLoader;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
/**
 * Interfejs opakowujący różne rodzaje ekranu powitalnego.
 * 
 * @author koziolek
 * 
 */
interface Loader {
 
        /**
         * Wywoływana po utworzeniu instancji interfejsu w celu dokonania
         * konfiguracji.
         */
        public abstract void configure();
 
        /**
         * Wywoływana po zakończeniu ładowania.
         */
        public abstract void done();
 
        /**
         * Wywoływana przy zmianie stanu ładowania.
         * 
         * @param step
         *            numer kroku.
         */
        public abstract void update(int step);
 
        /**
         * Pozwala na pobranie obiektu {@link Graphics2D} dla aktualnej wersji ekranu powitalnego. 
         * @return
         */
        public abstract Graphics getGraphics();

		public abstract Dimension getSize();
 
}
package kus.splashLoader;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
/**
 * Interfejs opakowuj�cy r�ne rodzaje ekranu powitalnego.
 * 
 * @author koziolek
 * 
 */
interface Loader {
 
        /**
         * Wywo�ywana po utworzeniu instancji interfejsu w celu dokonania
         * konfiguracji.
         */
        public abstract void configure();
 
        /**
         * Wywo�ywana po zako�czeniu �adowania.
         */
        public abstract void done();
 
        /**
         * Wywo�ywana przy zmianie stanu �adowania.
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
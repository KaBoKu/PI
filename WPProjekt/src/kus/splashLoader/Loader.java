package kus.splashLoader;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
/**
 * Interfejs opakowuj¹cy ró¿ne rodzaje ekranu powitalnego.
 * 
 * @author koziolek
 * 
 */
interface Loader {
 
        /**
         * Wywo³ywana po utworzeniu instancji interfejsu w celu dokonania
         * konfiguracji.
         */
        public abstract void configure();
 
        /**
         * Wywo³ywana po zakoñczeniu ³adowania.
         */
        public abstract void done();
 
        /**
         * Wywo³ywana przy zmianie stanu ³adowania.
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
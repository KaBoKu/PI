package kus.splashLoader;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;

public class SplashScreenDemo {
	 
    public static void main(String[] args) throws InterruptedException {
            double ver = Double.parseDouble(System.getProperty("java.version")
                            .substring(0, 3));
            Java6Loader myLoader = null;
            if (ver >= 1.6) {
                    myLoader = new Java6Loader();
            } else {
                    String resource = "./pl/koziolekweb/programmers/java/splashscreen/dragons.jpg";
                   // myLoader = new Java5Loader(resource);
            }
            myLoader.setRenderer(new DefaultRenderer());
            myLoader.configure();
            for (int i = 0; i < 100; i += 3) {
                    myLoader.update(i);
                    Thread.sleep(10);
            }
            myLoader.done();
    }
}

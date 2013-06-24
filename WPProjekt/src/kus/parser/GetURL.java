package kus.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author BoloUX
 * Klasa s³u¿y do tego aby pobieraæ do stringa strony
 */
public class GetURL {

    public String GURL(String adress) {//adress to adres URL
        String wynik="";
        try {
            URL u = new URL(adress);
          
            BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
            String linia = "", linia1 = "";

            while (((linia = br.readLine())) != null) {
                //System.out.println(linia);
                linia1 += linia;
            }
            wynik=linia1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wynik;
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kus.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author BoloUX
 */
public class Extract {

    public String pobranie() {
        String wynik="";
        try {
            URL u = new URL("http://www.nbp.pl/Kursy/KursyC.html");//Tabela kursów sk¹d bêdziemy braæ dane
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));

            String linia, linia1 = "";
            while (((linia = br.readLine())) != null) {
                linia1 += linia;
            }

            String temp[];
            temp = linia1.split("<a href=\"/|\" target=\"_blank\"");//Wyciêcie adresu wzglednego xmla
            wynik=temp[3];
        } catch (MalformedURLException ex) {
           ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wynik;
    }
}
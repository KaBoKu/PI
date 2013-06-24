package kus.parser;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



public class Main {

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		Extract  e = new Extract();
		GetURL gURL =  new GetURL();
		XMLp xml = new XMLp();
		//NBPParser xmlP = new NBPParser();
		//System.out.println(gURL.GURL("http://www.nbp.pl/Kursy/KursyC.html"));
		//System.out.println(gURL.GURL("http://www.nbp.pl/"+e.pobranie()));
	//	xml.xml(gURL.GURL("http://www.nbp.pl/"+e.pobranie()));
		//System.out.println(gURL.GURL("http://www.tvn24.pl/najwazniejsze.xml")); 
		RSSParser t = new RSSParser();
		//xmlP.xml(gURL.GURL("http://www.nbp.pl/"+e.pobranie()),"tabela_kursow");
		//t.xml("http://www.tvn24.pl/najwazniejsze.xml");
		//BigDecimal a = new BigDecimal("3.2");
		//String s = gURL.GURL("http://www.tvn24.pl/najwazniejsze.xml");
	//	String s2 = gURL.GURL("http://rss.gazeta.pl/pub/rss/wiadomosci.htm");
	//	System.out.println(s2);
	//	String ss = new String(t.xml(s2,"channel").getBytes("UTF-8"), "UTF-8");
		//System.out.println(ss);
		
		//System.out.println(a.toString());
		KursyKeeper kk = new KursyKeeper();
		
		 WeatherParser hP = new WeatherParser();
	        System.out.println(hP.HTML());
		
	}

}

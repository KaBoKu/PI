package kus.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

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
		
	        String adress="http://weather.yahooapis.com/forecastrss?w=12862220&u=c";
	        URL urlik = new URL(adress);
	        BufferedReader br = new BufferedReader(new InputStreamReader(urlik.openStream()));
	        String line ="", line0 = "";
	        while((line0=br.readLine())!=null){
	        	line+=line0;
	        	line+="\n";
	        }
	        System.out.println(line);
	        String linie = gURL.GURL("http://weather.yahooapis.com/forecastrss?w=12862220&u=c");
	        RSSYahooWether p = new RSSYahooWether();
	        String a = new String(p.xml(line, "channel", "windows-1250").getBytes(),"windows-1250");
	        System.out.println(a);
	        System.out.println(YahooCodes2.getDescribe(0));
	        SwingWeahterParser swp =  new SwingWeahterParser("http://weather.yahooapis.com/forecastrss?w=12862220&u=c","windows-1250");
	        System.out.println("=============================");
	        System.out.println(swp.getXML());
	
	        
	}
	
	
	

}

enum YahooCodes2{
	 
	TORNADO(0,"tornado");
	private final String describe; 
	private final int code;
	private static  Map<Integer, YahooCodes2> mapEnum;
	YahooCodes2(int code,String str){
		describe=str;
		this.code = code;
	}
	
	static void initMap(){
		mapEnum = new HashMap<Integer,YahooCodes2>();
		for(YahooCodes2 yC : values() ){
			mapEnum.put(yC.code, yC);
		}
	}
	
	public static  String getDescribe(int i){
		initMap();		
		return mapEnum.get(i).describe;
	}
/*		0 	tornado
	1 	tropical storm
	2 	hurricane
	3 	severe thunderstorms
	4 	thunderstorms
	5 	mixed rain and snow
	6 	mixed rain and sleet
	7 	mixed snow and sleet
	8 	freezing drizzle
	9 	drizzle
	10 	freezing rain
	11 	showers
	12 	showers
	13 	snow flurries
	14 	light snow showers
	15 	blowing snow
	16 	snow
	17 	hail
	18 	sleet
	19 	dust
	20 	foggy
	21 	haze
	22 	smoky
	23 	blustery
	24 	windy
	25 	cold
	26 	cloudy
	27 	mostly cloudy (night)
	28 	mostly cloudy (day)
	29 	partly cloudy (night)
	30 	partly cloudy (day)
	31 	clear (night)
	32 	sunny
	33 	fair (night)
	34 	fair (day)
	35 	mixed rain and hail
	36 	hot
	37 	isolated thunderstorms
	38 	scattered thunderstorms
	39 	scattered thunderstorms
	40 	scattered showers
	41 	heavy snow
	42 	scattered snow showers
	43 	heavy snow
	44 	partly cloudy
	45 	thundershowers
	46 	snow showers
	47 	isolated thundershowers
	3200 	not available*/
	
	
}

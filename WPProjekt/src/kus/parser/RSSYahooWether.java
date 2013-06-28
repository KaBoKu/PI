package kus.parser;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class RSSYahooWether extends TemplateXML{

	@Override
	public String extractData(Document doc) {
		// TODO Auto-generated method stub
		String result="";
		String code="";
		System.out.println(doc.getDocumentElement());
		Node n = doc.getDocumentElement();
		NodeList nL = doc.getElementsByTagName("*");
		System.out.println(nL.getLength());
		for(int i=0;i<nL.getLength();++i){
			Node cN = nL.item(i);
			System.out.println(cN.getNodeName());
			Element el = (Element) cN;
			if (el.getTagName().startsWith("yweather:wind")){
				System.out.println("Temperatura: "+el.getAttribute("chill")+"C");
				result+="Temperatura: "+el.getAttribute("chill")+"C"+"\n";
				System.out.println("Prêdkoœæ kierunek: "+el.getAttribute("direction")+" Stopni");
				result+="Wiatr kierunek: "+el.getAttribute("direction")+" Stopni"+"\n";
				System.out.println("Prêdkoœæ wiatru: "+el.getAttribute("speed")+"km/h");
				result+="Prêdkoœæ wiatru: "+el.getAttribute("speed")+"km/h"+"\n";
			}
			if (el.getTagName().startsWith("yweather:atmosphere")){
				System.out.println("Wilgotnoœæ: "+el.getAttribute("humidity")+"%");
				result+="Wilgotnoœæ: "+el.getAttribute("humidity")+"%"+"\n";
				System.out.println("Widocznoœæ: "+el.getAttribute("visibility")+"km");
				result+="Widocznoœæ: "+el.getAttribute("visibility")+"km"+"\n";
				System.out.println("Ciœnienie: "+el.getAttribute("pressure")+"mb");
				result+="Ciœnienie: "+el.getAttribute("pressure")+"mb"+"\n";
			}
			
			if (el.getTagName().startsWith("yweather:astronomy")){
				System.out.println("Wschód: "+el.getAttribute("sunrise"));
				result+="Wschód: "+el.getAttribute("sunrise")+"\n";
				System.out.println("Zachód: "+el.getAttribute("sunset"));
				result+="Zachód: "+el.getAttribute("sunset")+"\n";
			}
			if (el.getTagName().startsWith("yweather:condition")){
				System.out.println("Opis: "+el.getAttribute("text"));
				System.out.println("Kod: "+el.getAttribute("code"));
				code+=el.getAttribute("code");
			}
			
			
		}
		System.out.println("system "+Charset.defaultCharset());
		//System.out.println(result=result+"\ncode "+code);
		result=result.replace("am","przedpo³udniem");
		result=result.replace("pm","popo³udniu");
		return result;//element.getAttribute("city");
	}

	@Override
	public String getBaseData(NodeList nList0) {
		// TODO Auto-generated method stub
		return null;
	}

}

 enum YahooCodes{
	 
		TORNADO(0,"tornado"),TROPICAL_STORM(1,"burza tropikalna"),HURRICANE(2,"huragan"),SEVERE_THUNDERSTORMS(3,"ma³e burze");
		private final String describe; 
		private final int code;
		private static  Map<Integer, YahooCodes> mapEnum;
		YahooCodes(int code,String str){
			describe=str;
			this.code = code;
		}
		
		static void initMap(){
			mapEnum = new HashMap<Integer,YahooCodes>();
			for(YahooCodes yC : values() ){
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

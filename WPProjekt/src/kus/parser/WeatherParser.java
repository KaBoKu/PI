package kus.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WeatherParser {
	// Parser do pogody na stronie onet.pl
	// Zbiera wszytskie dane do stringa i trzeba je tam obrobic

	public static String HTML() {
		Document doc;
		StringBuilder sb = new StringBuilder();
		try {

			// need http protocol
			doc = Jsoup
					.connect(
							"http://pogoda.onet.pl/prognoza-pogody/dzis/europa,polska,krakow,9202.html")
					.get();

			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all links
			// Elements links =
			// doc.select("div[class=weather-city] ");//.first();
			Element links = doc.select("div[class=weather-city]").first();
			// for (Element link : links) {

			// get the value from href attribute
			System.out.println("\nlink : " + links.attr("class"));
			// System.out.println(doc.body().text());
			System.out.println("text : " + links.text());
			//sb.append(links.text() + "\n");
			// }
			Elements e = links.getAllElements();
			for(Element ee : e){
				//System.out.println("olo "+ee.text());
				sb.append(ee.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String [] a = sb.toString().split("Jutro");
		System.out.println(a[0]);
		return a[0];
		//return sb.toString();
	}
}

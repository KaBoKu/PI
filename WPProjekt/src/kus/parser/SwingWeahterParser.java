package kus.parser;

import java.io.UnsupportedEncodingException;

public class SwingWeahterParser {
	GetURL gURL = new GetURL();
	RSSYahooWether t = new RSSYahooWether();
	String s = null;
	String result = null;

	public SwingWeahterParser(String RSS,String encoding) throws UnsupportedEncodingException {
		s = gURL.GURL(RSS);
		if(s.equals("b��d sieci")) result="Brak po��czenia z sieci�, albo odpowiednie serwisy s� niedost�pne.";
		else result = new String(t.xml(s, "channel",encoding));
	}

	public String getXML() {
		return result;
	}
}

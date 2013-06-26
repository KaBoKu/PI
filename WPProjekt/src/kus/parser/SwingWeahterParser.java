package kus.parser;

import java.io.UnsupportedEncodingException;

public class SwingWeahterParser {
	GetURL gURL = new GetURL();
	RSSYahooWether t = new RSSYahooWether();
	String s = null;
	String result = null;

	public SwingWeahterParser(String RSS,String encoding) throws UnsupportedEncodingException {
		s = gURL.GURL(RSS);
		if(s.equals("b³¹d sieci")) result="Brak po³¹czenia z sieci¹, albo odpowiednie serwisy s¹ niedostêpne.";
		else result = new String(t.xml(s, "channel",encoding));
	}

	public String getXML() {
		return result;
	}
}

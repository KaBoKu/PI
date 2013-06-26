package kus.parser;

import java.io.UnsupportedEncodingException;

public class SwingParser {
	GetURL gURL = new GetURL();
	RSSParser t = new RSSParser();
	String s = null;
	String result = null;

	public SwingParser(String RSS,String encoding) throws UnsupportedEncodingException {
		s = gURL.GURL(RSS);
		if(s.equals("b³¹d sieci")) result="Brak po³¹czenia z sieci¹, albo odpowiednie serwisy s¹ niedostêpne.";
		else result = new String(t.xml(s, "channel",encoding));
	}

	public String getXML() {
		return result;
	}

}

package kus.parser;

import java.io.UnsupportedEncodingException;

public class SwingParser {
	GetURL gURL = new GetURL();
	RSSParser t = new RSSParser();
	String s = null;
	String result = null;

	public SwingParser(String RSS,String encoding) throws UnsupportedEncodingException {
		s = gURL.GURL(RSS);
		if(s.equals("b��d sieci")) result="Brak po��czenia z sieci�, albo odpowiednie serwisy s� niedost�pne.";
		else result = new String(t.xml(s, "channel",encoding));
	}

	public String getXML() {
		return result;
	}

}

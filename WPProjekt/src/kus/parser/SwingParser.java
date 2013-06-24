package kus.parser;

import java.io.UnsupportedEncodingException;

public class SwingParser {
	GetURL gURL = new GetURL();
	RSSParser t = new RSSParser();
	String s = null;
	String result = null;

	public SwingParser(String RSS,String encoding) throws UnsupportedEncodingException {
		s = gURL.GURL(RSS);
		result = new String(t.xml(s, "channel",encoding));
	}

	public String getXML() {
		return result;
	}

}

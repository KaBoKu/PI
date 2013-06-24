package kus.parser;

public class SwingNBPParser {
	Extract  e = new Extract();
	GetURL gURL =  new GetURL();
	XMLp xml = new XMLp();
	public String getXML(){
		xml.xml(gURL.GURL("http://www.nbp.pl/"+e.pobranie()));
		return xml.xml(gURL.GURL("http://www.nbp.pl/"+e.pobranie()));
	}
}

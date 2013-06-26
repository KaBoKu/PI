package kus.parser;

public class SwingNBPParser {
	Extract  e = new Extract();
	GetURL gURL =  new GetURL();
	XMLp xml = new XMLp();
	String s ="";
	public String getXML(){
		s = gURL.GURL("http://www.nbp.pl/"+e.pobranie());
		if(s.equals("b³¹d sieci")) return "Brak po³¹czenia z sieci¹, albo odpowiednie serwisy s¹ niedostêpne.";
	
		xml.xml(gURL.GURL("http://www.nbp.pl/"+e.pobranie()));
		return xml.xml(gURL.GURL("http://www.nbp.pl/"+e.pobranie()));
	}
}

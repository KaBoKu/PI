package kus.parser;

public class SwingNBPParser {
	Extract  e = new Extract();
	GetURL gURL =  new GetURL();
	XMLp xml = new XMLp();
	String s ="";
	public String getXML(){
		s = gURL.GURL("http://www.nbp.pl/"+e.pobranie());
		if(s.equals("b��d sieci")) return "Brak po��czenia z sieci�, albo odpowiednie serwisy s� niedost�pne.";
	
		xml.xml(gURL.GURL("http://www.nbp.pl/"+e.pobranie()));
		return xml.xml(gURL.GURL("http://www.nbp.pl/"+e.pobranie()));
	}
}

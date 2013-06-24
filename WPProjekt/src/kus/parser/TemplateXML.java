package kus.parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class TemplateXML {



	public abstract String extractData(Document doc);

	/**
	 * @param nList0
	 */
	public abstract String getBaseData(NodeList nList0);

	/**
	 * @param doc
	 * @return
	 */
	public final NodeList getElementsByTag(Document doc, String tagName) {
		NodeList nList0 = doc.getElementsByTagName(tagName);// "tabela_kursow");
		return nList0;
	}

	/**
	 * @param adres
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public final Document prepareXML(String adres)
			throws ParserConfigurationException, SAXException, IOException {
		String xml = adres;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new java.io.StringReader(
				xml)));// parse potrzebuje obróbki po samego Stringa nie
						// akceputje
		doc.getDocumentElement().normalize();
		return doc;
	}

	protected static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}
	
	protected String xml(String adres,String root,String encoding){
		String result = "";
		try {
			
			Document doc = prepareXML(adres);
			// MySQLcon c= new MySQLcon();

			NodeList nList0 = getElementsByTag(doc, root);

			getBaseData(nList0);
			//byte[] s = extractData(doc).getBytes();
			result = new String(extractData(doc).getBytes(), encoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}



package kus.parser;

//import com.mysql.jdbc.Statement;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLp {

	void xml() {
		try {
			// Funkcja testowa przeznaczona;
			File fXmlFile = new File("d:\\a004z120105.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList0 = getElementsByTag(doc, "tabela_kursow");

			for (int temp = 0; temp < nList0.getLength(); temp++) {

				Node nNode = nList0.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					System.out.print("numer_tabeli : "
							+ getTagValue("numer_tabeli", eElement));
					// System.out.print("data_notowania : " +
					// getTagValue("data_notowania", eElement));
					System.out.print("data_publikacji : "
							+ getTagValue("data_publikacji", eElement));
					/*
					 * <numer_tabeli>4/C/NBP/2012</numer_tabeli>
					 * <data_notowania>2012-01-04</data_notowania>
					 * <data_publikacji>2012-01-05</data_publikacji>
					 */
				}
			}

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("pozycja");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.print("Nazwa Waluty : "
							+ getTagValue("nazwa_waluty", eElement));
					System.out.print(" Przelicznik : "
							+ getTagValue("przelicznik", eElement));
					System.out.print(" Kod Waluty : "
							+ getTagValue("kod_waluty", eElement));
					System.out.print(" Kurs sredni : "
							+ getTagValue("kurs_sredni", eElement) + "\n");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String xml(String adres/* ,Statement stm */) {
		String result = "";
		try {
			Document doc = prepareXML(adres);
			// MySQLcon c= new MySQLcon();

			NodeList nList0 = getElementsByTag(doc, "tabela_kursow");

			getBaseData(nList0);

			extractData(doc);
			result = new String(extractData(doc).getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param doc
	 */
	public String extractData(Document doc) {
		System.out.println("Root element :"
				+ doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("pozycja");
		System.out.println("-----------------------");
		StringBuilder sb = new StringBuilder();
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				String kod = getTagValue("kod_waluty", eElement);
				String kupno = getTagValue("kurs_kupna", eElement);
				String sprzedarz = getTagValue("kurs_sprzedazy", eElement);
				System.out.println(kupno + " " + sprzedarz + " " + kod);
				// Zamiana przecinka na kropkê aby MySql przyjmowa³ wpisy
				kupno = kupno.replace(',', '.');
				sprzedarz = sprzedarz.replace(',', '.');
				System.out.println(kupno + " " + sprzedarz + " " + kod);
				sb.append(kupno + " " + sprzedarz + " " + kod+"\n");
				// Funkcja wpisuj¹ca do tabel wyniki z xml-a
				// c.in(stm, kupno, sprzedarz, kod);
				/*
				 * <pozycja> <nazwa_waluty>dolar amerykañski</nazwa_waluty>
				 * <przelicznik>1</przelicznik> <kod_waluty>USD</kod_waluty>
				 * <kurs_kupna>3,4315</kurs_kupna>
				 * <kurs_sprzedazy>3,5009</kurs_sprzedazy> </pozycja>
				 */
				
			}
			
		}
		return sb.toString();
	}

	/**
	 * @param nList0
	 */
	public String getBaseData(NodeList nList0) {
		StringBuilder sb = new StringBuilder();
		for (int temp = 0; temp < nList0.getLength(); temp++) {

			Node nNode = nList0.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("numer_tabeli : "
						+ getTagValue("numer_tabeli", eElement));
				System.out.println("data_notowania : "
						+ getTagValue("data_notowania", eElement));
				System.out.println("data_publikacji : "
						+ getTagValue("data_publikacji", eElement));

				/*
				 * <tabela_kursow typ="C" uid="12c004">
				 * <numer_tabeli>4/C/NBP/2012</numer_tabeli>
				 * <data_notowania>2012-01-04</data_notowania>
				 * <data_publikacji>2012-01-05</data_publikacji>
				 */
			}
		}
		return null;
	}

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

	private final static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}
}
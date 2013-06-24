package kus.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NBPParser extends TemplateXML{

	@Override
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

	@Override
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

}

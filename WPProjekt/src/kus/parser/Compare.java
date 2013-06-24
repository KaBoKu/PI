package kus.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Compare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			readStringReader l = new readStringReader("¹³¹óóawpd	ê");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;

		
		 try {
		        url = new URL("http://rss.gazeta.pl/pub/rss/wiadomosci.htm");
		        is = url.openStream();  // throws an IOException
		        br = new BufferedReader(new InputStreamReader(is));

		        while ((line = br.readLine()) != null) {
		            byte[] c = line.getBytes();
		        	int i=0;
		        	String kl = new String(c,"ISO-8859-2");
		        	System.out.println(kl);
		            
		        }
		    } catch (MalformedURLException mue) {
		         mue.printStackTrace();
		    } catch (IOException ioe) {
		         ioe.printStackTrace();
		    } finally {
		        try {
		            is.close();
		        } catch (IOException ioe) {
		            // nothing to see here
		        }
		    }
	}
	
	 
}

class readStringReader{
	private String adress;
	private StringReader sReader;
	private InputStream iS;
	
	readStringReader(String adress) throws IOException{
		this.adress = adress;
		sReader = new StringReader(adress);
		int tmp;
		while((tmp=sReader.read())!=-1){
			char c = (char)tmp;
			System.out.println("char: "+c);
		}
	}
}

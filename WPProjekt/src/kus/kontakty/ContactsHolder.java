package kus.kontakty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
//Klasa trzymajaca kontakty
public class ContactsHolder {
	private Map<Integer, Contact> contactHolder = new HashMap<Integer, Contact>();
	public int size(){
		return contactHolder.size();
	}
	public void add(Contact c,int id){
		contactHolder.put(id, c);
	}
	
	public List<Contact> sreach(String nazwisko) {
		List<Contact> result = new ArrayList();
		Pattern p = Pattern.compile("^nazwisko.*");
		// Matcher m = p.matcher("ala");

		return result;
	}

	public List<Contact> find(String nazwisko) {
		List<Contact> result = new ArrayList();
		Iterator it = contactHolder.entrySet().iterator();
		Map.Entry p;
		Contact c;
		while (it.hasNext()) {
			p = (Map.Entry) it.next();
			c = (Contact) p.getValue();
			System.out.println("sa: "+c.getNazwisko());
			if(nazwisko.equals(c.getNazwisko()))result.add(c);
		}
		return result;
	}
}

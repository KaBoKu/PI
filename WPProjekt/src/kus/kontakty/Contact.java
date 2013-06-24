package kus.kontakty;
//Klasa kontakt chyba za wiele nie trzeba tutaj tlumaczyc co i po co. POJO class.
public class Contact {
	int id;

	String nazwisko;
	String imie;
	String nrTel;
	String email;
	String adresWWW;
	String nrKom;
	String adresDom;
	String praca;
	String opis;

	public Contact() {
		super();
		this.nazwisko = "";
		this.imie = "";
		this.nrTel = "";
		this.email = "";
		this.adresWWW = "";
		this.nrKom = "";
		this.adresDom = "";
		this.praca = "";
		this.opis = "";
	}

	public Contact(String nazwisko, String imie, String nrTel, String email,
			String adresWWW, String nrKom, String adresDom, String praca,
			String opis) {
		super();
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.nrTel = nrTel;
		this.email = email;
		this.adresWWW = adresWWW;
		this.nrKom = nrKom;
		this.adresDom = adresDom;
		this.praca = praca;
		this.opis = opis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNrTel() {
		return nrTel;
	}

	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresWWW() {
		return adresWWW;
	}

	public void setAdresWWW(String adresWWW) {
		this.adresWWW = adresWWW;
	}

	public String getNrKom() {
		return nrKom;
	}

	public void setNrKom(String nrKom) {
		this.nrKom = nrKom;
	}

	public String getAdresDom() {
		return adresDom;
	}

	public void setAdresDom(String adresDom) {
		this.adresDom = adresDom;
	}

	public String getPraca() {
		return praca;
	}

	public void setPraca(String praca) {
		this.praca = praca;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
}

package kus.eventy.owner;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 31.05.13
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */
public enum Owner {
    INSTANCE;
    

	public String name;
    public String surname;
    public String email;
    public String phone;
    public String about;
    
    private Owner() {
		this.name = "brak";
		this.surname = "brak";
		this.email = "brak";
		this.phone = "brak";
		this.about = "brak";
	}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }




}

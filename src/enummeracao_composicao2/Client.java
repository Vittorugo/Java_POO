package enummeracao_composicao2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private String email;
	private Date birthDate;
	
	
	public Client() {
		
	}
	
	public Client(String name, String email, Date birthDate) {
		
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	public String toString() {
		return this.name + " ( " + dateFormat.format(this.getBirthDate()) + " ) - " + this.getEmail();
	}
	
	//Getters and Setters 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
}

package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer id;
	private Date moment;
	private String name;
	private String email;
	private String phoneNumber;
	private String occupation;
	
	public Worker() {
		
	}

	public Worker(Integer id, Date moment, String name, String email, String phoneNumber, String occupation) {
		
		this.id = id;
		this.moment = moment;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.occupation = occupation;
	}

	public Integer getId() {
		return id;
	}

	public Date getMoment() {
		return moment;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String toString() {
		return id + ": " + name + ", " + occupation + ", " + email + ", " + phoneNumber 
				+ " - Date of Registration: " + sdf.format(moment) + "\n";
	}
}

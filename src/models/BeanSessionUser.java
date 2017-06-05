package models;

import java.io.Serializable;

public class BeanSessionUser implements Serializable{
	private static final long serialVersionUID = 1L;

	private String username = "";
	private String email = "";
	private String dob_day = "";
	private String dob_month = "";
	private String dob_year = "";
	private String name = "";
	private String surname = "";
	private String gender = "";
	
	private String currentPage = "";
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getDob_day() {
		return dob_day;
	}

	public String getDob_month() {
		return dob_month;
	}

	public String getDob_year() {
		return dob_year;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getGender() {
		return gender;
	}

	public String getBirth()  {
		return dob_year + "-" + dob_month + "-" + dob_day;
	}
	
	public String getCurrentPage(){
		return currentPage;
	}

	/*Setters*/
	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDob_day(String dob_day) {
		this.dob_day = dob_day;
	}

	public void setDob_month(String dob_month) {
		this.dob_month = dob_month;
	}

	public void setDob_year(String dob_year) {
		this.dob_year = dob_year;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setCurrentPage(String currentPage){
		this.currentPage = currentPage;
	}
}

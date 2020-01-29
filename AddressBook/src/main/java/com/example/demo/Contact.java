package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
	@JsonProperty("id")
	private String id;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("familyname")
	private String familyname;
	@JsonProperty("phonenumber")
	private String phonenumber;
	@JsonProperty("email")
	private String email;

	public Contact(String id, String firstname, String familyname, String phonenumber, String email) {
		this.id = id;
		this.firstname = firstname;
		this.familyname = familyname;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	@JsonIgnore
	public String getId() {
		return id;
	}
	@JsonIgnore
	public String getFirstName() {
		return firstname;
	}
	@JsonIgnore
	public String getFamilyName() {
		return familyname;
	}
	@JsonIgnore
	public String getPhoneNumber() {
		return phonenumber;
	}
	@JsonIgnore
	public String getEmail() {
		return email;
	}
	@JsonIgnore
	public void setId(String id) {
		this.id = id;
	}
	@JsonIgnore
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	@JsonIgnore
	public void setFamilyName(String familyname) {
		this.familyname = familyname;
	}
	@JsonIgnore
	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@JsonIgnore
	public void setEmail(String email) {
		this.email = email;
	}
	
}
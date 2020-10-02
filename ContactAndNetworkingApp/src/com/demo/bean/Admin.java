package com.demo.bean;

public class Admin {

	private String aemail;
	private String aname;
	private String apass;
	private String amob;
	
	//Default Constructor
	public Admin() {
		super();
	}
	
	//Parameterized Constructor
	public Admin(String aemail, String aname, String apass, String amob) {
		super();
		this.aemail = aemail;
		this.aname = aname;
		this.apass = apass;
		this.amob = amob;
	}
	
	//Overrided toString method
	@Override
	public String toString() {
		return "Admin [aemail=" + aemail + ", aname=" + aname + ", apass=" + apass + ", amob=" + amob + "]";
	}
	
	//Getters and setters
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}
	public String getAmob() {
		return amob;
	}
	public void setAmob(String amob) {
		this.amob = amob;
	}
	
	
}

package com.demo.bean;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Contact {
	
	private String cemail;
	private String cfullName;   
	private String cmob;
	private String cgender;
	private Date cbdate;
	private String caddress;
	private String ccity;
	private String cstate;
	private String ccountry;
	private String ccompany;
	private BufferedImage cimage;
	
	//Default Constructor
	public Contact() {
		super();
	}
	
	//Parameterized Constructor
	public Contact(String cemail, String cfullName, String cmob, String cgender, Date cbdate, String caddress,
			String ccity, String cstate, String ccountry, String ccompany, BufferedImage cimage) {
		super();
		this.cemail = cemail;
		this.cfullName = cfullName;
		this.cmob = cmob;
		this.cgender = cgender;
		this.cbdate = cbdate;
		this.caddress = caddress;
		this.ccity = ccity;
		this.cstate = cstate;
		this.ccountry = ccountry;
		this.ccompany = ccompany;
		this.cimage = cimage;
	}
	
	//Overrided toString method
	@Override
	public String toString() {
		return "Contact [cemail=" + cemail + ", cfullName=" + cfullName + ", cmob=" + cmob + ", cgender=" + cgender
				+ ", cbdate=" + cbdate + ", caddress=" + caddress + ", ccity=" + ccity + ", cstate=" + cstate
				+ ", ccountry=" + ccountry + ", ccompany=" + ccompany + ", cimage=" + cimage + "]";
	}
	
	//Getters and setters
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCfullName() {
		return cfullName;
	}
	public void setCfullName(String cfullName) {
		this.cfullName = cfullName;
	}
	public String getCmob() {
		return cmob;
	}
	public void setCmob(String cmob) {
		this.cmob = cmob;
	}
	public String getCgender() {
		return cgender;
	}
	public void setCgender(String cgender) {
		this.cgender = cgender;
	}
	public Date getCbdate() {
		return cbdate;
	}
	public void setCbdate(Date cbdate) {
		this.cbdate = cbdate;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	public String getCcountry() {
		return ccountry;
	}
	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}
	public String getCcompany() {
		return ccompany;
	}
	public void setCcompany(String ccompany) {
		this.ccompany = ccompany;
	}
	public BufferedImage getCimage() {
		return cimage;
	}
	public void setCimage(BufferedImage cimage) {
		this.cimage = cimage;
	}
	
}

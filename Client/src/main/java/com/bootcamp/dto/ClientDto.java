package com.bootcamp.dto;

import java.sql.Timestamp;

public class ClientDto {
	
	
	String cId;
	String cPw;
	String cName;
	String cPhone;
	String cEmail;
	Timestamp cDate;
	Timestamp cMdate;
	Timestamp cDdate;
	String cImage;
	
	public ClientDto() {
		
	}

	public ClientDto(String cId, String cPw, String cName, String cPhone, String cEmail, Timestamp cDate,
			Timestamp cMdate, Timestamp cDdate, String cImage) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
		this.cDate = cDate;
		this.cMdate = cMdate;
		this.cDdate = cDdate;
		this.cImage = cImage;
	}
	
	
	public ClientDto(String cId, String cPw, String cPhone, String cEmail, String cImage) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
		this.cImage = cImage;
	}
	
	public ClientDto(String cId, String cPw) {
		super();
		this.cId = cId;
		this.cPw = cPw;
	}
	
	
	public ClientDto(String cId, String cPw, String cPhone, String cEmail) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
	}
	
	

	public ClientDto(String cId, String cPw, String cName, String cPhone, String cEmail, Timestamp cDate) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
		this.cDate = cDate;
	}
	
	
	public ClientDto(String cId, String cPw, Timestamp cDdate) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cDdate = cDdate;
	}

	public ClientDto(String cId) {
		super();
		this.cId = cId;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcPw() {
		return cPw;
	}

	public void setcPw(String cPw) {
		this.cPw = cPw;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public Timestamp getcDate() {
		return cDate;
	}

	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}

	public Timestamp getcMdate() {
		return cMdate;
	}

	public void setcMdate(Timestamp cMdate) {
		this.cMdate = cMdate;
	}

	public Timestamp getcDdate() {
		return cDdate;
	}

	public void setcDdate(Timestamp cDdate) {
		this.cDdate = cDdate;
	}

	public String getcImage() {
		return cImage;
	}

	public void setcImage(String cImage) {
		this.cImage = cImage;
	}

	
	
	
}

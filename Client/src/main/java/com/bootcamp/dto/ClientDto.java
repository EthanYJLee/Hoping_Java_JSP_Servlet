package com.bootcamp.dto;

public class ClientDto {
	
	String cId;
	String cName;
	String cPhone;
	String cEmail;
	String cImage;
	
	public ClientDto() {
		// TODO Auto-generated constructor stub
	}

	public ClientDto(String cId, String cName, String cPhone, String cEmail, String cImage) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
		this.cImage = cImage;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
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

	public String getcImage() {
		return cImage;
	}

	public void setcImage(String cImage) {
		this.cImage = cImage;
	}

	
	
}

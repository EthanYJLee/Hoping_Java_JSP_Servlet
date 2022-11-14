package com.bootcamp.joindto;

public class HostClientDto {
	
	int hSeq;
	String hId;
	String cId;
	String cName;
	String cPhone;
	String cEmail;
	String hImage;
	String hSummary;
	
	public HostClientDto() {
		// TODO Auto-generated constructor stub
	}

	public HostClientDto(int hSeq, String hId, String cId, String cName, String cPhone, String cEmail, String hImage,
			String hSummary) {
		super();
		this.hSeq = hSeq;
		this.hId = hId;
		this.cId = cId;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
		this.hImage = hImage;
		this.hSummary = hSummary;
	}
	

	public HostClientDto(String hId, String cName, String cPhone, String cEmail, String hImage, String hSummary) {
		super();
		this.hId = hId;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
		this.hImage = hImage;
		this.hSummary = hSummary;
	}

	public HostClientDto(int hSeq, String hId, String cId) {
		super();
		this.hSeq = hSeq;
		this.hId = hId;
		this.cId = cId;
	}

	public int gethSeq() {
		return hSeq;
	}

	public void sethSeq(int hSeq) {
		this.hSeq = hSeq;
	}

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
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

	public String gethImage() {
		return hImage;
	}

	public void sethImage(String hImage) {
		this.hImage = hImage;
	}

	public String gethSummary() {
		return hSummary;
	}

	public void sethSummary(String hSummary) {
		this.hSummary = hSummary;
	}

	
		
}

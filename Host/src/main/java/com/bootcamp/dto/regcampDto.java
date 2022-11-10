package com.bootcamp.dto;


public class regcampDto {
	
	
	//캠핑장 등록
	String regTel = "";
	String regCategory = "";
	String regDetailaddress = "";
	String regName = "";
	String regSummary = "";
	String regImage1 = "";
	int host_hSeq;
	

	
	
	public regcampDto() {
		// TODO Auto-generated constructor stub
	}




	public regcampDto(String regImage1, String regName, String regDetailaddress ) {
		super();
		this.regImage1 = regImage1;
		this.regName = regName;
		this.regDetailaddress = regDetailaddress;
	}




	public regcampDto(String regTel, String regCategory, String regDetailaddress,
			String regName, String regSummary, int host_hSeq) {
		super();
		this.regTel = regTel;
		this.regCategory = regCategory;
		this.regDetailaddress = regDetailaddress;
		this.regName = regName;
		this.regSummary = regSummary;
		this.host_hSeq = host_hSeq;
	}




	public String getRegTel() {
		return regTel;
	}




	public void setRegTel(String regTel) {
		this.regTel = regTel;
	}




	public String getRegCategory() {
		return regCategory;
	}




	public void setRegCategory(String regCategory) {
		this.regCategory = regCategory;
	}




	public String getRegDetailaddress() {
		return regDetailaddress;
	}




	public void setRegDetailaddress(String regDetailaddress) {
		this.regDetailaddress = regDetailaddress;
	}




	public String getRegName() {
		return regName;
	}




	public void setRegName(String regName) {
		this.regName = regName;
	}




	public String getRegSummary() {
		return regSummary;
	}




	public void setRegSummary(String regSummary) {
		this.regSummary = regSummary;
	}




	public int getHost_hSeq() {
		return host_hSeq;
	}




	public void setHost_hSeq(int host_hSeq) {
		this.host_hSeq = host_hSeq;
	}




	public String getRegImage1() {
		return regImage1;
	}




	public void setRegImage1(String regImage1) {
		this.regImage1 = regImage1;
	}



	





}
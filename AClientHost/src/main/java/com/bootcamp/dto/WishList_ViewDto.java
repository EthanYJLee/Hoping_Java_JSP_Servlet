package com.bootcamp.dto;

public class WishList_ViewDto {
	
	public WishList_ViewDto() {
		// TODO Auto-generated constructor stub
	}
	
	int regSeq;
	String regImage1;
	String regDetailaddress;
	String regName;
	String regTel;
	
	public WishList_ViewDto(int regSeq, String regImage1, String regDetailaddress, String regName, String regTel) {
		super();
		this.regSeq = regSeq;
		this.regImage1 = regImage1;
		this.regDetailaddress = regDetailaddress;
		this.regName = regName;
		this.regTel = regTel;
	}
	public int getRegSeq() {
		return regSeq;
	}
	public void setRegSeq(int regSeq) {
		this.regSeq = regSeq;
	}
	public String getRegImage1() {
		return regImage1;
	}
	public void setRegImage1(String regImage1) {
		this.regImage1 = regImage1;
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
	public String getRegTel() {
		return regTel;
	}
	public void setRegTel(String regTel) {
		this.regTel = regTel;
	}
	
	
	
	

}

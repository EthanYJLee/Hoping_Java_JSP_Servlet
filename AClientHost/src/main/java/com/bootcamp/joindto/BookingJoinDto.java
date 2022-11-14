package com.bootcamp.joindto;

public class BookingJoinDto {

	String regSeq;
	String regName;
	String regCategory;
	int roNum;
	int roPrice;
	String boCheckindate;
	String boCheckoutdate;
	

	public BookingJoinDto(){
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingJoinDto(String regSeq, String regName, String regCategory, int roNum, int roPrice,
			String boCheckindate, String boCheckoutdate) {
		super();
		this.regSeq = regSeq;
		this.regName = regName;
		this.regCategory = regCategory;
		this.roNum = roNum;
		this.roPrice = roPrice;
		this.boCheckindate = boCheckindate;
		this.boCheckoutdate = boCheckoutdate;
	}

	public String getRegSeq() {
		return regSeq;
	}

	public void setRegSeq(String regSeq) {
		this.regSeq = regSeq;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getRegCategory() {
		return regCategory;
	}

	public void setRegCategory(String regCategory) {
		this.regCategory = regCategory;
	}

	public int getRoNum() {
		return roNum;
	}

	public void setRoNum(int roNum) {
		this.roNum = roNum;
	}

	public int getRoPrice() {
		return roPrice;
	}

	public void setRoPrice(int roPrice) {
		this.roPrice = roPrice;
	}

	public String getBoCheckindate() {
		return boCheckindate;
	}

	public void setBoCheckindate(String boCheckindate) {
		this.boCheckindate = boCheckindate;
	}

	public String getBoCheckoutdate() {
		return boCheckoutdate;
	}

	public void setBoCheckoutdate(String boCheckoutdate) {
		this.boCheckoutdate = boCheckoutdate;
	}


}


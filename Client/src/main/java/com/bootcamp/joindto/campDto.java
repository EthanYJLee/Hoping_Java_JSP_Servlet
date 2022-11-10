package com.bootcamp.joindto;

public class campDto {

	int regSeq;
	String regName;
	String regCategory;
	int roNum;
	int roPrice;
	int roMax;
	

	public campDto(){
		super();
		// TODO Auto-generated constructor stub
	}


	public campDto(int regSeq, String regName, String regCategory, int roNum, int roPrice, int roMax) {
		super();
		this.regSeq = regSeq;
		this.regName = regName;
		this.regCategory = regCategory;
		this.roNum = roNum;
		this.roPrice = roPrice;
		this.roMax = roMax;
	}


	public int getBoSeq() {
		return regSeq;
	}


	public void setBoSeq(int regSeq) {
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


	public int getRoMax() {
		return roMax;
	}


	public void setRoMax(int roMax) {
		this.roMax = roMax;
	}

	
}


package com.bootcamp.joindto;

public class campDto {

	int regSeq;
	String regName;
	int roNum;
	int roPrice;
	int roOccupied;
	
	public campDto(){
		super();
		// TODO Auto-generated constructor stub
	}

	public campDto(int regSeq, String regName, int roNum, int roPrice, int roOccupied) {
		super();
		this.regSeq = regSeq;
		this.regName = regName;
		this.roNum = roNum;
		this.roPrice = roPrice;
		this.roOccupied = roOccupied;
	}

	public int getRegSeq() {
		return regSeq;
	}

	public void setRegSeq(int regSeq) {
		this.regSeq = regSeq;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
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

	public int getRoOccupied() {
		return roOccupied;
	}

	public void setRoOccupied(int roOccupied) {
		this.roOccupied = roOccupied;
	}
	
}

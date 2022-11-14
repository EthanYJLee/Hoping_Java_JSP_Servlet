package com.bootcamp.joindto;

import java.sql.Timestamp;

public class BookJoinDto {

	String regSeq;
	String regName;
	String regCategory;
	int roNum;
	int roPrice;
	Timestamp boCheckindate;
	Timestamp boCheckoutdate;
	int boGroup;
	int boSeq;
	String client_cId;
	String regImage2;
	int days;

	public BookJoinDto(){
		super();
		// TODO Auto-generated constructor stub
	}

	public BookJoinDto(String regSeq, String regName, String regCategory, int roNum, int roPrice,
			Timestamp boCheckindate, Timestamp boCheckoutdate,int boGroup, String client_cId, String regImage2, int days) {
		super();
		this.regSeq = regSeq;
		this.regName = regName;
		this.regCategory = regCategory;
		this.roNum = roNum;
		this.roPrice = roPrice;
		this.boCheckindate = boCheckindate;
		this.boCheckoutdate = boCheckoutdate;
		this.boGroup = boGroup;
		this.client_cId = client_cId;
		this.regImage2 = regImage2;
		this.days = days;
	}
	
	public BookJoinDto(String regSeq, String regName, String regCategory, int roNum, int roPrice,
			Timestamp boCheckindate, int boGroup, int boSeq, String client_cId) {
		super();
		this.regSeq = regSeq;
		this.regName = regName;
		this.regCategory = regCategory;
		this.roNum = roNum;
		this.roPrice = roPrice;
		this.boCheckindate = boCheckindate;
		this.boGroup = boGroup;
		this.boSeq = boSeq;
		this.client_cId = client_cId;
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

	public Timestamp getBoCheckindate() {
		return boCheckindate;
	}

	public void setBoCheckindate(Timestamp boCheckindate) {
		this.boCheckindate = boCheckindate;
	}
	public Timestamp getBoCheckoutdate() {
		return boCheckoutdate;
	}

	public void setBoCheckoutdate(Timestamp boCheckoutdate) {
		this.boCheckoutdate = boCheckoutdate;
	}

	public int getBoGroup() {
		return boGroup;
	}

	public void setBoGroup(int boGroup) {
		this.boGroup = boGroup;
	}

	public int getBoSeq() {
		return boSeq;
	}

	public void setBoSeq(int boSeq) {
		this.boSeq = boSeq;
	}

	public String getClient_cId() {
		return client_cId;
	}

	public void setClient_cId(String client_cId) {
		this.client_cId = client_cId;
	}

	public String getRegImage2() {
		return regImage2;
	}

	public void setRegImage2(String regImage2) {
		this.regImage2 = regImage2;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

}


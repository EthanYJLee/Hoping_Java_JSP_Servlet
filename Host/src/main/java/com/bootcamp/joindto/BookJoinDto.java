package com.bootcamp.joindto;

import java.sql.Timestamp;

public class BookJoinDto {
	
	int boSeq;
	String regName;
	String pay_cid;
	int total;
	Timestamp boDate;
	int roNum;
	Timestamp boCheckindate;
	Timestamp boCheckoutdate;
	int boCount;
	int boPrice;
	
	public BookJoinDto() {

	}

	public BookJoinDto(int boSeq, String regName, String pay_cid, int total, Timestamp boDate, int roNum,
			Timestamp boCheckindate, Timestamp boCheckoutdate, int boCount) {
		super();
		this.boSeq = boSeq;
		this.regName = regName;
		this.pay_cid = pay_cid;
		this.total = total;
		this.boDate = boDate;
		this.roNum = roNum;
		this.boCheckindate = boCheckindate;
		this.boCheckoutdate = boCheckoutdate;
		this.boCount = boCount;
	}

	public BookJoinDto(int boSeq, String regName, String pay_cid, int total, Timestamp boDate, int roNum,
			Timestamp boCheckindate, Timestamp boCheckoutdate, int boCount, int boPrice) {
		super();
		this.boSeq = boSeq;
		this.regName = regName;
		this.pay_cid = pay_cid;
		this.total = total;
		this.boDate = boDate;
		this.roNum = roNum;
		this.boCheckindate = boCheckindate;
		this.boCheckoutdate = boCheckoutdate;
		this.boCount = boCount;
		this.boPrice = boPrice;
	}

	public int getBoSeq() {
		return boSeq;
	}

	public void setBoSeq(int boSeq) {
		this.boSeq = boSeq;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getPay_cid() {
		return pay_cid;
	}

	public void setPay_cid(String pay_cid) {
		this.pay_cid = pay_cid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Timestamp getBoDate() {
		return boDate;
	}

	public void setBoDate(Timestamp boDate) {
		this.boDate = boDate;
	}

	public int getRoNum() {
		return roNum;
	}

	public void setRoNum(int roNum) {
		this.roNum = roNum;
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

	public int getBoCount() {
		return boCount;
	}

	public void setBoCount(int boCount) {
		this.boCount = boCount;
	}

	public int getBoPrice() {
		return boPrice;
	}

	public void setBoPrice(int boPrice) {
		this.boPrice = boPrice;
	}

	
	
	

}

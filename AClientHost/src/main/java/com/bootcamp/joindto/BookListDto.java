package com.bootcamp.joindto;

import java.sql.Timestamp;

public class BookListDto {
	
	int boSeq;
	int boPrice;
	int boGroup;
	String regName;
	String pay_client_cId;
	int total;
	Timestamp boDate;
	int roNum;
	int pay_room_regcamp_regSeq;
	Timestamp checkin;
	Timestamp checkout;
	int boCount;
	int pay_room_regcamp_host_hSeq;
	int pay_room_roSeq;
	
	public BookListDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BookListDto(int boGroup, String regName, String pay_client_cId, int total, Timestamp boDate, int roNum,
			Timestamp checkin, Timestamp checkout, int boCount) {
		super();
		this.boGroup = boGroup;
		this.regName = regName;
		this.pay_client_cId = pay_client_cId;
		this.total = total;
		this.boDate = boDate;
		this.roNum = roNum;
		this.checkin = checkin;
		this.checkout = checkout;
		this.boCount = boCount;
	}
	
	public BookListDto(int boPrice, int boGroup, String regName, String pay_client_cId, int total, Timestamp boDate,
			int roNum, Timestamp checkin, Timestamp checkout, int boCount) {
		super();
		this.boPrice = boPrice;
		this.boGroup = boGroup;
		this.regName = regName;
		this.pay_client_cId = pay_client_cId;
		this.total = total;
		this.boDate = boDate;
		this.roNum = roNum;
		this.checkin = checkin;
		this.checkout = checkout;
		this.boCount = boCount;
	}

	public int getBoSeq() {
		return boSeq;
	}

	public void setBoSeq(int boSeq) {
		this.boSeq = boSeq;
	}

	public int getBoPrice() {
		return boPrice;
	}

	public void setBoPrice(int boPrice) {
		this.boPrice = boPrice;
	}

	public int getBoGroup() {
		return boGroup;
	}

	public void setBoGroup(int boGroup) {
		this.boGroup = boGroup;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getPay_client_cId() {
		return pay_client_cId;
	}

	public void setPay_client_cId(String pay_client_cId) {
		this.pay_client_cId = pay_client_cId;
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

	public int getPay_room_regcamp_regSeq() {
		return pay_room_regcamp_regSeq;
	}

	public void setPay_room_regcamp_regSeq(int pay_room_regcamp_regSeq) {
		this.pay_room_regcamp_regSeq = pay_room_regcamp_regSeq;
	}

	public Timestamp getCheckin() {
		return checkin;
	}

	public void setCheckin(Timestamp checkin) {
		this.checkin = checkin;
	}

	public Timestamp getCheckout() {
		return checkout;
	}

	public void setCheckout(Timestamp checkout) {
		this.checkout = checkout;
	}

	public int getBoCount() {
		return boCount;
	}

	public void setBoCount(int boCount) {
		this.boCount = boCount;
	}

	public int getPay_room_regcamp_host_hSeq() {
		return pay_room_regcamp_host_hSeq;
	}

	public void setPay_room_regcamp_host_hSeq(int pay_room_regcamp_host_hSeq) {
		this.pay_room_regcamp_host_hSeq = pay_room_regcamp_host_hSeq;
	}

	public int getPay_room_roSeq() {
		return pay_room_roSeq;
	}

	public void setPay_room_roSeq(int pay_room_roSeq) {
		this.pay_room_roSeq = pay_room_roSeq;
	}
	
}

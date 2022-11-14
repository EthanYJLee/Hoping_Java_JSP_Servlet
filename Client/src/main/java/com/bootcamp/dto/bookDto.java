package com.bootcamp.dto;

import java.sql.Timestamp;

public class bookDto {
	int boSeq;
	int boPrice;
	Timestamp boDate;
	Timestamp boCheckindate;
	int boGroup;
	int boCount;
	Timestamp boCanceldate;
	String pay_cid;
	int pay_room_roSeq;
	int pay_room_regcamp_regSeq;
	int pay_room_regcamp_host_hSeq;
	String pay_client_cId;
	
	public bookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public bookDto(int boSeq, int boPrice, Timestamp boDate, Timestamp boCheckindate, int boGroup, int boCount,
			Timestamp boCanceldate, String pay_cid, int pay_room_roSeq, int pay_room_regcamp_regSeq,
			int pay_room_regcamp_host_hSeq, String pay_client_cId) {
		super();
		this.boSeq = boSeq;
		this.boPrice = boPrice;
		this.boDate = boDate;
		this.boCheckindate = boCheckindate;
		this.boGroup = boGroup;
		this.boCount = boCount;
		this.boCanceldate = boCanceldate;
		this.pay_cid = pay_cid;
		this.pay_room_roSeq = pay_room_roSeq;
		this.pay_room_regcamp_regSeq = pay_room_regcamp_regSeq;
		this.pay_room_regcamp_host_hSeq = pay_room_regcamp_host_hSeq;
		this.pay_client_cId = pay_client_cId;
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

	public Timestamp getBoDate() {
		return boDate;
	}

	public void setBoDate(Timestamp boDate) {
		this.boDate = boDate;
	}

	public Timestamp getBoCheckindate() {
		return boCheckindate;
	}

	public void setBoCheckindate(Timestamp boCheckindate) {
		this.boCheckindate = boCheckindate;
	}

	public int getBoGroup() {
		return boGroup;
	}

	public void setBoGroup(int boGroup) {
		this.boGroup = boGroup;
	}

	public int getBoCount() {
		return boCount;
	}

	public void setBoCount(int boCount) {
		this.boCount = boCount;
	}

	public Timestamp getBoCanceldate() {
		return boCanceldate;
	}

	public void setBoCanceldate(Timestamp boCanceldate) {
		this.boCanceldate = boCanceldate;
	}

	public String getPay_cid() {
		return pay_cid;
	}

	public void setPay_cid(String pay_cid) {
		this.pay_cid = pay_cid;
	}

	public int getPay_room_roSeq() {
		return pay_room_roSeq;
	}

	public void setPay_room_roSeq(int pay_room_roSeq) {
		this.pay_room_roSeq = pay_room_roSeq;
	}

	public int getPay_room_regcamp_regSeq() {
		return pay_room_regcamp_regSeq;
	}

	public void setPay_room_regcamp_regSeq(int pay_room_regcamp_regSeq) {
		this.pay_room_regcamp_regSeq = pay_room_regcamp_regSeq;
	}

	public int getPay_room_regcamp_host_hSeq() {
		return pay_room_regcamp_host_hSeq;
	}

	public void setPay_room_regcamp_host_hSeq(int pay_room_regcamp_host_hSeq) {
		this.pay_room_regcamp_host_hSeq = pay_room_regcamp_host_hSeq;
	}

	public String getPay_client_cId() {
		return pay_client_cId;
	}

	public void setPay_client_cId(String pay_client_cId) {
		this.pay_client_cId = pay_client_cId;
	}

}

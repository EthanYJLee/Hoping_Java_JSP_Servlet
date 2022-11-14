package com.bootcamp.dto;

import java.sql.Timestamp;

public class wishDto {
	
	int sWeq;
	Timestamp wDate;
	String client_cId;
	int host_hSeq;
	
	public wishDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public wishDto(int sWeq, Timestamp wDate, String client_cId, int host_hSeq) {
		super();
		this.sWeq = sWeq;
		this.wDate = wDate;
		this.client_cId = client_cId;
		this.host_hSeq = host_hSeq;
	}

	public int getsWeq() {
		return sWeq;
	}

	public void setsWeq(int sWeq) {
		this.sWeq = sWeq;
	}

	public Timestamp getwDate() {
		return wDate;
	}

	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}

	public String getClient_cId() {
		return client_cId;
	}

	public void setClient_cId(String client_cId) {
		this.client_cId = client_cId;
	}

	public int getHost_hSeq() {
		return host_hSeq;
	}

	public void setHost_hSeq(int host_hSeq) {
		this.host_hSeq = host_hSeq;
	}

	
}

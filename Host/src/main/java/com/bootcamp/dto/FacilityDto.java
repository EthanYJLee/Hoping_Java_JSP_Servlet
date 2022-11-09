package com.bootcamp.dto;

public class FacilityDto {
	
	int fIndex;
	String fName;
	int regcamp_regSeq;
	int regcamp_host_hSeq;
	
	public FacilityDto() {
		// TODO Auto-generated constructor stub
	}
	
	public FacilityDto(String fName) {
		super();
		this.fName = fName;
	}

	public int getfIndex() {
		return fIndex;
	}

	public void setfIndex(int fIndex) {
		this.fIndex = fIndex;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getRegcamp_regSeq() {
		return regcamp_regSeq;
	}

	public void setRegcamp_regSeq(int regcamp_regSeq) {
		this.regcamp_regSeq = regcamp_regSeq;
	}

	public int getRegcamp_host_hSeq() {
		return regcamp_host_hSeq;
	}

	public void setRegcamp_host_hSeq(int regcamp_host_hSeq) {
		this.regcamp_host_hSeq = regcamp_host_hSeq;
	}
	
}

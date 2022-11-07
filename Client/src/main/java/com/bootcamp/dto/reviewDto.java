package com.bootcamp.dto;

import java.sql.Timestamp;

public class reviewDto {
	int rvSeq;
	String rvid;
	String rvName;
	String rvTitle;
	String rvContent;
	int rvStar;
	Timestamp rvTime;
	Timestamp rvMtime;
	Timestamp rvDTime;
	
	public reviewDto() {
		
	}

	public reviewDto(int rvSeq, String rvid, String rvName, String rvTitle, String rvContent, int rvStar,
			Timestamp rvTime, Timestamp rvMtime, Timestamp rvDTime) {
		super();
		this.rvSeq = rvSeq;
		this.rvid = rvid;
		this.rvName = rvName;
		this.rvTitle = rvTitle;
		this.rvContent = rvContent;
		this.rvStar = rvStar;
		this.rvTime = rvTime;
		this.rvMtime = rvMtime;
		this.rvDTime = rvDTime;
	}

	public int getRvSeq() {
		return rvSeq;
	}

	public void setRvSeq(int rvSeq) {
		this.rvSeq = rvSeq;
	}

	public String getRvid() {
		return rvid;
	}

	public void setRvid(String rvid) {
		this.rvid = rvid;
	}

	public String getRvName() {
		return rvName;
	}

	public void setRvName(String rvName) {
		this.rvName = rvName;
	}

	public String getRvTitle() {
		return rvTitle;
	}

	public void setRvTitle(String rvTitle) {
		this.rvTitle = rvTitle;
	}

	public String getRvContent() {
		return rvContent;
	}

	public void setRvContent(String rvContent) {
		this.rvContent = rvContent;
	}

	public int getRvStar() {
		return rvStar;
	}

	public void setRvStar(int rvStar) {
		this.rvStar = rvStar;
	}

	public Timestamp getRvTime() {
		return rvTime;
	}

	public void setRvTime(Timestamp rvTime) {
		this.rvTime = rvTime;
	}

	public Timestamp getRvMtime() {
		return rvMtime;
	}

	public void setRvMtime(Timestamp rvMtime) {
		this.rvMtime = rvMtime;
	}

	public Timestamp getRvDTime() {
		return rvDTime;
	}

	public void setRvDTime(Timestamp rvDTime) {
		this.rvDTime = rvDTime;
	}

	
}

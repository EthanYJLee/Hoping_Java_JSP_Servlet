package com.bootcamp.dto;

import java.sql.Timestamp;

public class AskDto {
	
	int aSeq;
	String aCId;
	String aTitle;
	String aContent;
	Timestamp aTime;
	Timestamp aMtime;
	Timestamp aDtime;
	int aRegSeq;
	
	public AskDto() {
		// TODO Auto-generated constructor stub
	}

	public int getaSeq() {
		return aSeq;
	}

	public void setaSeq(int aSeq) {
		this.aSeq = aSeq;
	}

	public String getaCId() {
		return aCId;
	}

	public void setaCId(String aCId) {
		this.aCId = aCId;
	}

	public String getaTitle() {
		return aTitle;
	}

	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	public Timestamp getaTime() {
		return aTime;
	}

	public void setaTime(Timestamp aTime) {
		this.aTime = aTime;
	}

	public Timestamp getaMtime() {
		return aMtime;
	}

	public void setaMtime(Timestamp aMtime) {
		this.aMtime = aMtime;
	}

	public Timestamp getaDtime() {
		return aDtime;
	}

	public void setaDtime(Timestamp aDtime) {
		this.aDtime = aDtime;
	}

	public int getaRegSeq() {
		return aRegSeq;
	}

	public void setaRegSeq(int aRegSeq) {
		this.aRegSeq = aRegSeq;
	}
	

}

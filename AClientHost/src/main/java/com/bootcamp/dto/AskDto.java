package com.bootcamp.dto;

import java.sql.Timestamp;

public class AskDto {
	
	int aSeq;
	String aCId;
	String aTitle;
	String aContent;
	String aTime;
	String aMtime;
	String aDtime;
	int aRegSeq;
	
	public AskDto() {
		// TODO Auto-generated constructor stub
	}

	public AskDto(int aSeq, String aCId, String aTitle, String aContent, String aTime, int aRegSeq) {
		super();
		this.aSeq = aSeq;
		this.aCId = aCId;
		this.aTitle = aTitle;
		this.aContent = aContent;
		this.aTime = aTime;
		this.aRegSeq = aRegSeq;
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

	public String getaTime() {
		return aTime;
	}

	public void setaTime(String aTime) {
		this.aTime = aTime;
	}

	public String getaMtime() {
		return aMtime;
	}

	public void setaMtime(String aMtime) {
		this.aMtime = aMtime;
	}

	public String getaDtime() {
		return aDtime;
	}

	public void setaDtime(String aDtime) {
		this.aDtime = aDtime;
	}

	public int getaRegSeq() {
		return aRegSeq;
	}

	public void setaRegSeq(int aRegSeq) {
		this.aRegSeq = aRegSeq;
	}

	
	

}

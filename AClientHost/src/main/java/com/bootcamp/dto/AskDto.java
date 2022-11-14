package com.bootcamp.dto;


public class AskDto {
	
	int aSeq;
	String aCId;
	String aTitle;
	String aContent;
	String aTime;
	String aMtime;
	String aDtime;
	int aRegSeq;
	
	//22-11-15 호식 
	// 문의 답변용으로 만듬
	boolean answer = false;
	
	
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
	//22-11-15 hosik
	//anwer용으로 만듬 
	public AskDto(boolean answer) {
		super();
		this.answer = answer;
	}
	
	
	

	public int getaRegSeq() {
		return aRegSeq;
	}

	public int getaSeq() {
		return aSeq;
	}


	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
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

	
	public void setaRegSeq(int aRegSeq) {
		this.aRegSeq = aRegSeq;
	}

	
	

}

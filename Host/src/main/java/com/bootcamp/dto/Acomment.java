package com.bootcamp.dto;

public class Acomment {
	
	int acSeq;
	String acTitle;
	String acContent;
	String acTime;
	int ask_aSeq;
	int host_hSeq;
	
	public Acomment() {
		// TODO Auto-generated constructor stub
	}

	public Acomment(int acSeq, String acTitle, String acContent, String acTime, int ask_aSeq, int host_hSeq) {
		super();
		this.acSeq = acSeq;
		this.acTitle = acTitle;
		this.acContent = acContent;
		this.acTime = acTime;
		this.ask_aSeq = ask_aSeq;
		this.host_hSeq = host_hSeq;
	}

	public int getAcSeq() {
		return acSeq;
	}

	public void setAcSeq(int acSeq) {
		this.acSeq = acSeq;
	}

	public String getAcTitle() {
		return acTitle;
	}

	public void setAcTitle(String acTitle) {
		this.acTitle = acTitle;
	}

	public String getAcContent() {
		return acContent;
	}

	public void setAcContent(String acContent) {
		this.acContent = acContent;
	}

	public String getAcTime() {
		return acTime;
	}

	public void setAcTime(String acTime) {
		this.acTime = acTime;
	}

	public int getAsk_aSeq() {
		return ask_aSeq;
	}

	public void setAsk_aSeq(int ask_aSeq) {
		this.ask_aSeq = ask_aSeq;
	}

	public int getHost_hSeq() {
		return host_hSeq;
	}

	public void setHost_hSeq(int host_hSeq) {
		this.host_hSeq = host_hSeq;
	}
	
	
}

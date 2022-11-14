package com.bootcamp.dto;

public class HostDto {
	
	
	String hId;
	
	
	String hSummary;
	String hImage;
	
	public HostDto() {
		// TODO Auto-generated constructor stub
	}

	public HostDto(String hId, String hSummary, String hImage) {
		super();
		this.hId = hId;
		this.hSummary = hSummary;
		this.hImage = hImage;
	}

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public String gethSummary() {
		return hSummary;
	}

	public void sethSummary(String hSummary) {
		this.hSummary = hSummary;
	}

	public String gethImage() {
		return hImage;
	}

	public void sethImage(String hImage) {
		this.hImage = hImage;
	}

	
	

}

package com.bootcamp.joindto;

import java.sql.Date;

public class DetailStatDto {
	Date boDate;
	int boPrice;
	int boGroup;
	
	public DetailStatDto() {
		// TODO Auto-generated constructor stub
	}

	public DetailStatDto(Date boDate, int boPrice, int boGroup) {
		super();
		this.boDate = boDate;
		this.boPrice = boPrice;
		this.boGroup = boGroup;
	}

	public Date getBoDate() {
		return boDate;
	}

	public void setBoDate(Date boDate) {
		this.boDate = boDate;
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
	
	

}

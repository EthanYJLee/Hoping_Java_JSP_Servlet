package com.bootcamp.joindto;

import java.sql.Timestamp;

public class checkdate2Dto {

	// 22.11.11  Hosik - created checkdate2 dto ... 이거 맞나 ...? 
	
	//Property
	
	int roSeq;
	int roNum;
	int roPrice;
	int roMax;
	int roOccupied;
	Timestamp roDate;
	Timestamp roMdate;
	Timestamp roDdate;
	int regcamp_regSeq;
	int regcamp_host_hSeq;
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
	int regSeq;
	String regTel; 
	String regCategory; 
	String regDetailaddress; 
	String regName; 
	Timestamp regDate; 
	Timestamp regMdate;
	Timestamp regDdate;
	String regSummary; 
	String regImage1; 
	String regImage2; 
	String regImage3; 
	String regImage4; 
	int host_hSeq;
	
	
	public checkdate2Dto() {
		// TODO Auto-generated constructor stub
	}


	public checkdate2Dto(int roPrice, int roMax, int regcamp_regSeq, String regName, String regImage4) {
		super();
		this.roPrice = roPrice;
		this.roMax = roMax;
		this.regcamp_regSeq = regcamp_regSeq;
		this.regName = regName;
		this.regImage4 = regImage4;
	}


	public checkdate2Dto(int roPrice, int roMax, int regcamp_regSeq, String regName) {
		super();
		this.roPrice = roPrice;
		this.roMax = roMax;
		this.regcamp_regSeq = regcamp_regSeq;
		this.regName = regName;
	}
	
	
	
/* 22-11-12 -Hosik
  			 Createdcheckdate2Dto(int regcamp_host_hSeq, String pay_client_cId, String regName)
			 asktoHost. 클라이언트 -> 호스트에게 질문하는데 페이지 넘길때 넘길 값 담은 dto
			 pay_client_cId의 경우는 pay realation을 사용 안하기로 해서 client ID값을 임의 넣었습니다	
			 만약에 사용할 일이 있따면 어떻게 따로 만들어야 될 수 도 있는데 이때 사용되는값은
			 session으로 로그인 한 아이디를 넣을꺼라 아마 안바뀌어도 크게 상관없을꺼라 생각되서 여기에 사용함 
			
*/
	public checkdate2Dto(int regcamp_host_hSeq, String pay_client_cId, String regName) {
		super();
		this.regcamp_host_hSeq = regcamp_host_hSeq;
		this.pay_client_cId = pay_client_cId;
		this.regName = regName;
	}


	public int getRoPrice() {
		return roPrice;
	}


	public void setRoPrice(int roPrice) {
		this.roPrice = roPrice;
	}


	public int getRoMax() {
		return roMax;
	}


	public void setRoMax(int roMax) {
		this.roMax = roMax;
	}


	public int getRegcamp_regSeq() {
		return regcamp_regSeq;
	}


	public void setRegcamp_regSeq(int regcamp_regSeq) {
		this.regcamp_regSeq = regcamp_regSeq;
	}


	public int getRegSeq() {
		return regSeq;
	}


	public void setRegSeq(int regSeq) {
		this.regSeq = regSeq;
	}


	public String getRegName() {
		return regName;
	}


	public void setRegName(String regName) {
		this.regName = regName;
	}


	public String getRegImage4() {
		return regImage4;
	}


	public void setRegImage4(String regImage4) {
		this.regImage4 = regImage4;
	}
	
	
	
	
	
	
}//Class end 

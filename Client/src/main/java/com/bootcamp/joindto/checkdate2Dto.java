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
	
	


	public checkdate2Dto(int roNum, int boSeq, String regName, String regImage1) {
		super();
		this.roNum = roNum;
		this.boSeq = boSeq;
		this.regName = regName;
		this.regImage1 = regImage1;
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


	public int getRoSeq() {
		return roSeq;
	}


	public void setRoSeq(int roSeq) {
		this.roSeq = roSeq;
	}


	public int getRoNum() {
		return roNum;
	}


	public void setRoNum(int roNum) {
		this.roNum = roNum;
	}


	public int getRoOccupied() {
		return roOccupied;
	}


	public void setRoOccupied(int roOccupied) {
		this.roOccupied = roOccupied;
	}


	public Timestamp getRoDate() {
		return roDate;
	}


	public void setRoDate(Timestamp roDate) {
		this.roDate = roDate;
	}


	public Timestamp getRoMdate() {
		return roMdate;
	}


	public void setRoMdate(Timestamp roMdate) {
		this.roMdate = roMdate;
	}


	public Timestamp getRoDdate() {
		return roDdate;
	}


	public void setRoDdate(Timestamp roDdate) {
		this.roDdate = roDdate;
	}


	public int getRegcamp_host_hSeq() {
		return regcamp_host_hSeq;
	}


	public void setRegcamp_host_hSeq(int regcamp_host_hSeq) {
		this.regcamp_host_hSeq = regcamp_host_hSeq;
	}


	public int getBoSeq() {
		return boSeq;
	}


	public void setBoSeq(int boSeq) {
		this.boSeq = boSeq;
	}


	public int getBoPrice() {
		return boPrice;
	}


	public void setBoPrice(int boPrice) {
		this.boPrice = boPrice;
	}


	public Timestamp getBoDate() {
		return boDate;
	}


	public void setBoDate(Timestamp boDate) {
		this.boDate = boDate;
	}


	public Timestamp getBoCheckindate() {
		return boCheckindate;
	}


	public void setBoCheckindate(Timestamp boCheckindate) {
		this.boCheckindate = boCheckindate;
	}


	public int getBoGroup() {
		return boGroup;
	}


	public void setBoGroup(int boGroup) {
		this.boGroup = boGroup;
	}


	public int getBoCount() {
		return boCount;
	}


	public void setBoCount(int boCount) {
		this.boCount = boCount;
	}


	public Timestamp getBoCanceldate() {
		return boCanceldate;
	}


	public void setBoCanceldate(Timestamp boCanceldate) {
		this.boCanceldate = boCanceldate;
	}


	public String getPay_cid() {
		return pay_cid;
	}


	public void setPay_cid(String pay_cid) {
		this.pay_cid = pay_cid;
	}


	public int getPay_room_roSeq() {
		return pay_room_roSeq;
	}


	public void setPay_room_roSeq(int pay_room_roSeq) {
		this.pay_room_roSeq = pay_room_roSeq;
	}


	public int getPay_room_regcamp_regSeq() {
		return pay_room_regcamp_regSeq;
	}


	public void setPay_room_regcamp_regSeq(int pay_room_regcamp_regSeq) {
		this.pay_room_regcamp_regSeq = pay_room_regcamp_regSeq;
	}


	public int getPay_room_regcamp_host_hSeq() {
		return pay_room_regcamp_host_hSeq;
	}


	public void setPay_room_regcamp_host_hSeq(int pay_room_regcamp_host_hSeq) {
		this.pay_room_regcamp_host_hSeq = pay_room_regcamp_host_hSeq;
	}


	public String getPay_client_cId() {
		return pay_client_cId;
	}


	public void setPay_client_cId(String pay_client_cId) {
		this.pay_client_cId = pay_client_cId;
	}


	public String getRegTel() {
		return regTel;
	}


	public void setRegTel(String regTel) {
		this.regTel = regTel;
	}


	public String getRegCategory() {
		return regCategory;
	}


	public void setRegCategory(String regCategory) {
		this.regCategory = regCategory;
	}


	public String getRegDetailaddress() {
		return regDetailaddress;
	}


	public void setRegDetailaddress(String regDetailaddress) {
		this.regDetailaddress = regDetailaddress;
	}


	public Timestamp getRegDate() {
		return regDate;
	}


	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}


	public Timestamp getRegMdate() {
		return regMdate;
	}


	public void setRegMdate(Timestamp regMdate) {
		this.regMdate = regMdate;
	}


	public Timestamp getRegDdate() {
		return regDdate;
	}


	public void setRegDdate(Timestamp regDdate) {
		this.regDdate = regDdate;
	}


	public String getRegSummary() {
		return regSummary;
	}


	public void setRegSummary(String regSummary) {
		this.regSummary = regSummary;
	}


	public String getRegImage1() {
		return regImage1;
	}


	public void setRegImage1(String regImage1) {
		this.regImage1 = regImage1;
	}


	public String getRegImage2() {
		return regImage2;
	}


	public void setRegImage2(String regImage2) {
		this.regImage2 = regImage2;
	}


	public String getRegImage3() {
		return regImage3;
	}


	public void setRegImage3(String regImage3) {
		this.regImage3 = regImage3;
	}


	public int getHost_hSeq() {
		return host_hSeq;
	}


	public void setHost_hSeq(int host_hSeq) {
		this.host_hSeq = host_hSeq;
	}
	
	
	
	
	
	
}//Class end 

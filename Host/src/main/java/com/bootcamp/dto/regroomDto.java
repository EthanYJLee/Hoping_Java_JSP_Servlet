package com.bootcamp.dto;

public class regroomDto {

	
	//캠핑장 룸 등록
		int roNum;
		int roPrice;
		int roMax;
		int roOccupied;
		int regcamp_regSeq;
		
		public regroomDto() {
			// TODO Auto-generated constructor stub
		}

		public regroomDto(int roNum, int roPrice, int roMax, int regcamp_regSeq) {
			super();
			this.roNum = roNum;
			this.roPrice = roPrice;
			this.roMax = roMax;
			this.regcamp_regSeq = regcamp_regSeq;
		}
		

		public regroomDto(int roNum, int roPrice, int roMax) {
			super();
			this.roNum = roNum;
			this.roPrice = roPrice;
			this.roMax = roMax;
		}

		public int getRoNum() {
			return roNum;
		}

		public void setRoNum(int roNum) {
			this.roNum = roNum;
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
		
		
		
}

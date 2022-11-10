package com.bootcamp.dto;

public class regroomDto {

	
	//캠핑장 룸 등록
		int roNum;
		int roPrice;
		int roMax;
		int roOccupied;
		int regcamp_regSeq;
		int regcamp_host_hSeq;
		
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

		
		
		public regroomDto(int roNum, int roPrice, int roMax, int regcamp_regSeq, int regcamp_host_hSeq) {
			super();
			this.roNum = roNum;
			this.roPrice = roPrice;
			this.roMax = roMax;
			this.regcamp_regSeq = regcamp_regSeq;
			this.regcamp_host_hSeq = regcamp_host_hSeq;
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

		public int getRoOccupied() {
			return roOccupied;
		}

		public void setRoOccupied(int roOccupied) {
			this.roOccupied = roOccupied;
		}

		public int getRegcamp_regSeq() {
			return regcamp_regSeq;
		}

		public void setRegcamp_regSeq(int regcamp_regSeq) {
			this.regcamp_regSeq = regcamp_regSeq;
		}

		public int getRegcamp_host_hSeq() {
			return regcamp_host_hSeq;
		}

		public void setRegcamp_host_hSeq(int regcamp_host_hSeq) {
			this.regcamp_host_hSeq = regcamp_host_hSeq;
		}

	
		
}

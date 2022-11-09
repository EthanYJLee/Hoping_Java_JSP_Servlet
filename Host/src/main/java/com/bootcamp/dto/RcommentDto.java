package com.bootcamp.dto;

import java.sql.Timestamp;

public class RcommentDto {
	int rcSeq;
	String rcContent;
	Timestamp rcTime;
	Timestamp rMtime;
	Timestamp rcDtime;
	int rcLevel;
	int rcGroup;
	String client_cId;
	int review_rvSeq;
	int review_regcamp_regSeq;
	int review_regcamp_host_hSeq;

	public RcommentDto() {
		// TODO Auto-generated constructor stub
	}

	public RcommentDto(int rcSeq, String rcContent, Timestamp rcTime, Timestamp rMtime, Timestamp rcDtime, int rcLevel,
			int rcGroup, String client_cId, int review_rvSeq, int review_regcamp_regSeq, int review_regcamp_host_hSeq) {
		super();
		this.rcSeq = rcSeq;
		this.rcContent = rcContent;
		this.rcTime = rcTime;
		this.rMtime = rMtime;
		this.rcDtime = rcDtime;
		this.rcLevel = rcLevel;
		this.rcGroup = rcGroup;
		this.client_cId = client_cId;
		this.review_rvSeq = review_rvSeq;
		this.review_regcamp_regSeq = review_regcamp_regSeq;
		this.review_regcamp_host_hSeq = review_regcamp_host_hSeq;
	}

	public int getRcSeq() {
		return rcSeq;
	}

	public void setRcSeq(int rcSeq) {
		this.rcSeq = rcSeq;
	}

	public String getRcContent() {
		return rcContent;
	}

	public void setRcContent(String rcContent) {
		this.rcContent = rcContent;
	}

	public Timestamp getRcTime() {
		return rcTime;
	}

	public void setRcTime(Timestamp rcTime) {
		this.rcTime = rcTime;
	}

	public Timestamp getrMtime() {
		return rMtime;
	}

	public void setrMtime(Timestamp rMtime) {
		this.rMtime = rMtime;
	}

	public Timestamp getRcDtime() {
		return rcDtime;
	}

	public void setRcDtime(Timestamp rcDtime) {
		this.rcDtime = rcDtime;
	}

	public int getRcLevel() {
		return rcLevel;
	}

	public void setRcLevel(int rcLevel) {
		this.rcLevel = rcLevel;
	}

	public int getRcGroup() {
		return rcGroup;
	}

	public void setRcGroup(int rcGroup) {
		this.rcGroup = rcGroup;
	}

	public String getClient_cId() {
		return client_cId;
	}

	public void setClient_cId(String client_cId) {
		this.client_cId = client_cId;
	}

	public int getReview_rvSeq() {
		return review_rvSeq;
	}

	public void setReview_rvSeq(int review_rvSeq) {
		this.review_rvSeq = review_rvSeq;
	}

	public int getReview_regcamp_regSeq() {
		return review_regcamp_regSeq;
	}

	public void setReview_regcamp_regSeq(int review_regcamp_regSeq) {
		this.review_regcamp_regSeq = review_regcamp_regSeq;
	}

	public int getReview_regcamp_host_hSeq() {
		return review_regcamp_host_hSeq;
	}

	public void setReview_regcamp_host_hSeq(int review_regcamp_host_hSeq) {
		this.review_regcamp_host_hSeq = review_regcamp_host_hSeq;
	}

}

package com.bootcamp.joindto;

import java.sql.Timestamp;

public class HostReplyReviewDto {
	int rvSeq;
	int regcamp_regSeq;
	String rvCId;
	String rvCName;
	String rvTitle;
	String rvContent;
	Timestamp rvTime;
	Timestamp rvMtime;
	Timestamp rvDtime;
	int rvStar;
	int regcamp_host_hSeq;
	String regName;

	public HostReplyReviewDto() {
		// TODO Auto-generated constructor stub
	}

	public HostReplyReviewDto(String rvCId, int regcamp_regSeq, int regcamp_host_hSeq) {
		super();
		this.rvCId = rvCId;
		this.regcamp_regSeq = regcamp_regSeq;
		this.regcamp_host_hSeq = regcamp_host_hSeq;
	}

	public HostReplyReviewDto(String regName, String rvCName, String rvCId, String rvTitle, Timestamp rvTime,
			String rvContent) {
		super();
		this.regName = regName;
		this.rvCName = rvCName;
		this.rvCId = rvCId;
		this.rvTitle = rvTitle;
		this.rvTime = rvTime;
		this.rvContent = rvContent;
	}

	public HostReplyReviewDto(int regcamp_regSeq, String rvTitle, String rvCName, Timestamp rvTime, String rvContent) {
		super();
		this.regcamp_regSeq = regcamp_regSeq;
		this.rvTitle = rvTitle;
		this.rvCName = rvCName;
		this.rvTime = rvTime;
		this.rvContent = rvContent;
	}

	public HostReplyReviewDto(int rvSeq, String regName, String rvCId, String rvCName, String rvTitle,
			Timestamp rvTime) {
		super();
		this.rvSeq = rvSeq;
		this.regName = regName;
		this.rvCId = rvCId;
		this.rvCName = rvCName;
		this.rvTitle = rvTitle;
		this.rvTime = rvTime;
	}

	public int getRvSeq() {
		return rvSeq;
	}

	public void setRvSeq(int rvSeq) {
		this.rvSeq = rvSeq;
	}

	public int getRegcamp_regSeq() {
		return regcamp_regSeq;
	}

	public void setRegcamp_regSeq(int regcamp_regSeq) {
		this.regcamp_regSeq = regcamp_regSeq;
	}

	public String getRvCId() {
		return rvCId;
	}

	public void setRvCId(String rvCId) {
		this.rvCId = rvCId;
	}

	public String getRvCName() {
		return rvCName;
	}

	public void setRvCName(String rvCName) {
		this.rvCName = rvCName;
	}

	public String getRvTitle() {
		return rvTitle;
	}

	public void setRvTitle(String rvTitle) {
		this.rvTitle = rvTitle;
	}

	public String getRvContent() {
		return rvContent;
	}

	public void setRvContent(String rvContent) {
		this.rvContent = rvContent;
	}

	public Timestamp getRvTime() {
		return rvTime;
	}

	public void setRvTime(Timestamp rvTime) {
		this.rvTime = rvTime;
	}

	public Timestamp getRvMtime() {
		return rvMtime;
	}

	public void setRvMtime(Timestamp rvMtime) {
		this.rvMtime = rvMtime;
	}

	public Timestamp getRvDtime() {
		return rvDtime;
	}

	public void setRvDtime(Timestamp rvDtime) {
		this.rvDtime = rvDtime;
	}

	public int getRvStar() {
		return rvStar;
	}

	public void setRvStar(int rvStar) {
		this.rvStar = rvStar;
	}

	public int getRegcamp_host_hSeq() {
		return regcamp_host_hSeq;
	}

	public void setRegcamp_host_hSeq(int regcamp_host_hSeq) {
		this.regcamp_host_hSeq = regcamp_host_hSeq;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

}

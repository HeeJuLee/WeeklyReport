package com.ncsoft.platform.report.domain;

import java.util.Date;

public class Reply {

	private Integer rno;
	private Integer bno;
	private String replyText;
	private String replyer;
	private Date regDate;
	private Date updateDate;
	
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplytext(String replyText) {
		this.replyText = replyText;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Reply [rno=" + rno + ", bno=" + bno + ", replyText=" + replyText + ", replyer=" + replyer + ", regDate="
				+ regDate + ", updateDate=" + updateDate + "]";
	}	
}

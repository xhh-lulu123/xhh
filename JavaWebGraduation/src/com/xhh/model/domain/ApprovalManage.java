package com.xhh.model.domain;

import java.util.Date;

public class ApprovalManage {
	private String id;                                  
	private String applyPerson;   //申请人              
	private Date applyDate;     //申请时间                     
	private String type;                         
	private String approvalPerson; //审批人                
	private int days;                          
	private String state;                             
	private String reason;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApplyPerson() {
		return applyPerson;
	}
	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getApprovalPerson() {
		return approvalPerson;
	}
	public void setApprovalPerson(String approvalPerson) {
		this.approvalPerson = approvalPerson;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
}
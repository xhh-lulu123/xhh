package com.xhh.model.domain;

import java.util.Date;

public class AllApproval {
	private String id;                                    
	private String createperson;                     
	private String applyperson;                        
	private Date applydate;                             
	private String result;                                
	private int days;                                
	private String type;                                  
	private String state;                             
	private String reason;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreateperson() {
		return createperson;
	}
	public void setCreateperson(String createperson) {
		this.createperson = createperson;
	}
	public String getApplyperson() {
		return applyperson;
	}
	public void setApplyperson(String applyperson) {
		this.applyperson = applyperson;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Date getApplydate() {
		return applydate;
	}
	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}       

}

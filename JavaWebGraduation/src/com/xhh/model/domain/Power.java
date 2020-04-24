package com.xhh.model.domain;

import java.util.Date;

/**
 * 对应POWER表，权限分类表
 * @author Administrator
 *
 */
public class Power {
	private String id;                                     
	private String name;         //权限名称                         
	private String descs;        //描述                        
	private String createperson; //创建人                       
	private Date createdate;   //创建时间 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public String getCreateperson() {
		return createperson;
	}
	public void setCreateperson(String createperson) {
		this.createperson = createperson;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
}

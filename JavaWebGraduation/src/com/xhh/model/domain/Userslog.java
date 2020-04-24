package com.xhh.model.domain;

import java.util.Date;

/**
 * 
 * 对应userlog表，用户操作日志表
 * @author Administrator
 *
 */
public class Userslog {
	private String id;                               
	private String name;                            
	private String type;   //用户类型                          
	private String result; //操作结果                          
	private String doinfo; //操作信息                     
	private Date dodate;   //操作时间                                   
	private String domod;  //操作模块
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDoinfo() {
		return doinfo;
	}
	public void setDoinfo(String doinfo) {
		this.doinfo = doinfo;
	}
	public Date getDodate() {
		return dodate;
	}
	public void setDodate(Date dodate) {
		this.dodate = dodate;
	}
	public String getDomod() {
		return domod;
	}
	public void setDomod(String domod) {
		this.domod = domod;
	}
	
}

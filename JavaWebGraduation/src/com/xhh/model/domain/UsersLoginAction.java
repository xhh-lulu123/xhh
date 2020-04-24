package com.xhh.model.domain;

import java.util.Date;

/**
 * 对应userslogin表，用户登录日志表
 * @author Administrator
 *
 */
public class UsersLoginAction {
	private String id;                                  
	private String name;                                  
	private String type;        //操作类型                         
	private Date logindate;   //登录时间                               
	private String loginip;     //登录ip                        
	private String loginresult; //登录状态（成功/失败）
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
	
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public String getLoginresult() {
		return loginresult;
	}
	public void setLoginresult(String loginresult) {
		this.loginresult = loginresult;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}

}

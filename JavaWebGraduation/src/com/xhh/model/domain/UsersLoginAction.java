package com.xhh.model.domain;

import java.util.Date;

/**
 * ��Ӧuserslogin���û���¼��־��
 * @author Administrator
 *
 */
public class UsersLoginAction {
	private String id;                                  
	private String name;                                  
	private String type;        //��������                         
	private Date logindate;   //��¼ʱ��                               
	private String loginip;     //��¼ip                        
	private String loginresult; //��¼״̬���ɹ�/ʧ�ܣ�
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

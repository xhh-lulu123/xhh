package com.xhh.model.domain;

import java.util.Date;

/**
 * ��ӦPOWER��Ȩ�޷����
 * @author Administrator
 *
 */
public class Power {
	private String id;                                     
	private String name;         //Ȩ������                         
	private String descs;        //����                        
	private String createperson; //������                       
	private Date createdate;   //����ʱ�� 
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

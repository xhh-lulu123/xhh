package com.xhh.model.domain;

import java.util.Date;

/**
 * ��Ӧrolesmanage����ɫ�����id�����û���Ϣ��Ȩ������Ȩ�޷���������
 * @author Administrator
 *
 */
public class RolesManage {
	private String id;                                     
	private String name;                                
	private String roledesc;     //��ɫ����                          
	private String relevancetab; //��Ӧ��Ȩ���б�                
	private Date createdate;   //��������                                    
	private String createperson; //������
	private RolePower rolePower;
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
	public String getRoledesc() {
		return roledesc;
	}
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	public String getRelevancetab() {
		return relevancetab;
	}
	public void setRelevancetab(String relevancetab) {
		this.relevancetab = relevancetab;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getCreateperson() {
		return createperson;
	}
	public void setCreateperson(String createperson) {
		this.createperson = createperson;
	}
	public RolePower getRolePower() {
		return rolePower;
	}
	public void setRolePower(RolePower rolePower) {
		this.rolePower = rolePower;
	}

}

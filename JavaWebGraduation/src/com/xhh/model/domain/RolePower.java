package com.xhh.model.domain;

import java.util.Date;

/**
 * ��Ӧrolepower����ɫȨ�޷������ɫ�������ý�ɫ�������������
 * @author Administrator
 *
 */
public class RolePower {
	private String name;         //��ɫ����                         
	private String power;        //Ȩ��                       
	private String quantity;     //����Ȩ�޸���                                 
	private String manageperson; //������                           
	private Date managedate;   //����ʱ��
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getManageperson() {
		return manageperson;
	}
	public void setManageperson(String manageperson) {
		this.manageperson = manageperson;
	}
	public Date getManagedate(){
		return managedate;
	}
	public void setManagedate(Date managedate) {
		this.managedate = managedate;
	}

	

}

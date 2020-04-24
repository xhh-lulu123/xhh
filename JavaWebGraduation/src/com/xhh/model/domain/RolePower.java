package com.xhh.model.domain;

import java.util.Date;

/**
 * 对应rolepower表，角色权限分类表，角色名称引用角色顾艳丽表做外键
 * @author Administrator
 *
 */
public class RolePower {
	private String name;         //角色名称                         
	private String power;        //权限                       
	private String quantity;     //所用权限个数                                 
	private String manageperson; //分配人                           
	private Date managedate;   //分配时间
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

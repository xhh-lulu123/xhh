package com.xhh.model.domain;

import java.util.Date;

/**
 * 对应rolesmanage表，角色管理表，id引用用户信息表。权限引用权限分类表做外键
 * @author Administrator
 *
 */
public class RolesManage {
	private String id;                                     
	private String name;                                
	private String roledesc;     //角色描述                          
	private String relevancetab; //对应的权限列表                
	private Date createdate;   //创建日期                                    
	private String createperson; //创建人
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

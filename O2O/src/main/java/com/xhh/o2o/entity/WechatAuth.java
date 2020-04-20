package com.xhh.o2o.entity;

import java.util.Date;

/**
 * 微信账号
 * @author Administrator
 *
 */
public class WechatAuth {
	private Long wechatAuthId;
	private String openID;
	private Date createTime;
	private PersonInfo personInfo;

	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	public Long getWechatAuthId() {
		return wechatAuthId;
	}
	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}

}

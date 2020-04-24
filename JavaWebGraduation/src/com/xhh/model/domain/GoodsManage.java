package com.xhh.model.domain;

import java.util.Date;

/**
 * 
 * 对应goodsmanage表，商品列表
 * @author Administrator
 *
 */
public class GoodsManage {
	private String id;                                 
	private String name;                          
	private double price;                        
	private double discount;    //商品折扣         
	private String type;     //  商品类型                     
	private String descs;      // 商品描述  
	private String state;		//商品状态
	private Date expirydate;   //商品有效期                   
	private String createperson;// 创建人                  
	private Date createdate;     //  创建时间                
	private String modifyperson;  //   修改人                
	private Date modifydate;   //修改时间
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
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
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
	public String getModifyperson() {
		return modifyperson;
	}
	public void setModifyperson(String modifyperson) {
		this.modifyperson = modifyperson;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}

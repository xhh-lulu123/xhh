package com.xhh.model.domain;
/**
 * �������飬��Ӧorderinfo
 * @author Administrator
 *
 */
public class OrderInfo {
	private String infoid;       //��������ID             
	private String orderid;      //����ID                      
	private String ordercode;    //�������                     
	private String goodid;       //��ƷID                        
	private String goodname;     //��Ʒ����                    
	private double goodprice;    //��Ʒ�۸�                       
	private double gooddiscount; //��Ʒ�ۿ�                        
	private String goodtype;     //��Ʒ����                       
	private String gooddescs;    //��Ʒ����                   
	private String address;      //�ջ��ַ                
	private String phone;        //�绰
	public String getInfoid() {
		return infoid;
	}
	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getGoodid() {
		return goodid;
	}
	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public double getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(double goodprice) {
		this.goodprice = goodprice;
	}
	public double getGooddiscount() {
		return gooddiscount;
	}
	public void setGooddiscount(double gooddiscount) {
		this.gooddiscount = gooddiscount;
	}
	public String getGoodtype() {
		return goodtype;
	}
	public void setGoodtype(String goodtype) {
		this.goodtype = goodtype;
	}
	public String getGooddescs() {
		return gooddescs;
	}
	public void setGooddescs(String gooddescs) {
		this.gooddescs = gooddescs;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}

package com.xhh.model.domain;
/**
 * 订单详情，对应orderinfo
 * @author Administrator
 *
 */
public class OrderInfo {
	private String infoid;       //订单详情ID             
	private String orderid;      //订单ID                      
	private String ordercode;    //订单编号                     
	private String goodid;       //商品ID                        
	private String goodname;     //商品名称                    
	private double goodprice;    //商品价格                       
	private double gooddiscount; //商品折扣                        
	private String goodtype;     //商品类型                       
	private String gooddescs;    //商品描述                   
	private String address;      //收获地址                
	private String phone;        //电话
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

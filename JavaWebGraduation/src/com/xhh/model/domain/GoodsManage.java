package com.xhh.model.domain;

import java.util.Date;

/**
 * 
 * ��Ӧgoodsmanage����Ʒ�б�
 * @author Administrator
 *
 */
public class GoodsManage {
	private String id;                                 
	private String name;                          
	private double price;                        
	private double discount;    //��Ʒ�ۿ�         
	private String type;     //  ��Ʒ����                     
	private String descs;      // ��Ʒ����  
	private String state;		//��Ʒ״̬
	private Date expirydate;   //��Ʒ��Ч��                   
	private String createperson;// ������                  
	private Date createdate;     //  ����ʱ��                
	private String modifyperson;  //   �޸���                
	private Date modifydate;   //�޸�ʱ��
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

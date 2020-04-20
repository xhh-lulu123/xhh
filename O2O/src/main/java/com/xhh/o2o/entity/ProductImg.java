package com.xhh.o2o.entity;

import java.util.Date;

/**
 * 商品详情图片
 * 
 * @author Administrator
 *
 */
public class ProductImg {
	private Long productImgId;
	private String imgAddr;
	private String imgDesc;
	private Integer priority;
	private Date createTime;
	private Long productId;

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}

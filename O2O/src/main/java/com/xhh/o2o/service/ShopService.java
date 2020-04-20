package com.xhh.o2o.service;

import java.io.InputStream;

import com.xhh.o2o.dto.ImageHolder;
import com.xhh.o2o.dto.ShopExecution;
import com.xhh.o2o.entity.Shop;
import com.xhh.o2o.exceptions.ShopOperationException;

public interface ShopService {
	
	/**
	 * 根据shopCondition分页返回相应店铺列表
	 * 
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

	/**
	 * 注册店铺信息
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	public ShopExecution addShop(Shop shop,ImageHolder thumbnail);
	/**
	 * 通过Id查询店铺
	 * @param shopId
	 * @return
	 */
	public Shop getByShopId(Long shopId);
	/**
	 * 更新店铺，包括对图片的处理
	 * @param shop  shop对象
	 * @param shopImgInputStream  图片处理流
	 * @param fileName 图片名称
	 * @return
	 */
	public ShopExecution modifyShop(Shop shop,ImageHolder thumbnail) throws ShopOperationException;

}

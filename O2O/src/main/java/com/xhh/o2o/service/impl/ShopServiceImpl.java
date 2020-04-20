package com.xhh.o2o.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xhh.o2o.dao.ShopDao;
import com.xhh.o2o.dto.ImageHolder;
import com.xhh.o2o.dto.ShopExecution;
import com.xhh.o2o.entity.Shop;
import com.xhh.o2o.enums.ShopStateEnum;
import com.xhh.o2o.exceptions.ShopOperationException;
import com.xhh.o2o.service.ShopService;
import com.xhh.o2o.util.ImageUtil;
import com.xhh.o2o.util.PageCalculator;
import com.xhh.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	
	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		//将页码转换成行码
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		//依据查询条件，调用dao层返回相关的店铺列表
		List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		//依据相同的查询条件，返回店铺总数
		int count = shopDao.queryShopCount(shopCondition);
		ShopExecution se = new ShopExecution();
		if (shopList != null) {
			se.setShopList(shopList);
			se.setCount(count);
		} else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}
	/**
	 * 添加店铺
	 */

	@Transactional//使用事务
	public ShopExecution addShop(Shop shop,ImageHolder thumbnail) {
		//控制判断
		if(shop==null){
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try{
			//给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectNum = shopDao.insertShop(shop);
			if(effectNum<=0){
				throw new ShopOperationException("店铺创建失败");
			}else{
				if(thumbnail.getImage()!=null){
					//存储图片
					try{
						addShopImg(shop,thumbnail);
						
					}catch(Exception e){
						throw new ShopOperationException("addShopImg error:"+ e.getMessage());
					}
					//更新店铺的图片地址
					effectNum = shopDao.updateShop(shop);
					if(effectNum<=0){
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		}catch(Exception e){
			throw new ShopOperationException("addShop error:"+ e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK,shop);
	}
	private void addShopImg(Shop shop, ImageHolder thumbnail) {
		//获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());//生成图片的相对路径（目录）
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail,dest);//处理缩略图，并返回新生成图片的相对值路径（文件名）
		shop.setShopImg(shopImgAddr);
		
	}
	@Override
	public Shop getByShopId(Long shopId) {
		
		return shopDao.queryByShopId(shopId);
	}
	@Override
	public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail)
			throws ShopOperationException {
		if (shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		} else {
			// 1.判断是否需要处理图片
			try {
				if (thumbnail.getImage()!= null&&thumbnail.getImage()!=null&& !"".equals(thumbnail.getImage())) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					System.out.println(tempShop.getShopImg()+"********");
					if (tempShop.getShopImg() != null) {
						ImageUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					addShopImg(shop,thumbnail);
				}
				// 2.更新店铺信息
				shop.setLastEditTime(new Date());
				int effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					return new ShopExecution(ShopStateEnum.INNER_ERROR);
				} else {
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExecution(ShopStateEnum.SUCCESS, shop);
				}
			} catch (Exception e) {
				throw new ShopOperationException("modifyShop error:" + e.getMessage());
			}
		}
	}
	

	
	
}

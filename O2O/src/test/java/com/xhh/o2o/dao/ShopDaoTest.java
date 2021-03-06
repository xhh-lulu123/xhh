package com.xhh.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xhh.o2o.BaseTest;
import com.xhh.o2o.entity.Area;
import com.xhh.o2o.entity.PersonInfo;
import com.xhh.o2o.entity.Shop;
import com.xhh.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	@Test
	public void testQueryShopList(){
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
		System.out.println("店铺列表的大小:"+shopList.size());
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺总数："+count);
	}
	@Test
	@Ignore
	public void testQueryByShopId(){
		Shop shop = shopDao.queryByShopId(1L);
		System.out.println("areaID:"+shop.getArea().getAreaId());
		System.out.println("areaName:"+shop.getArea().getAreaName());
	}
	@Test
	@Ignore
	public void testInsertShop(){
		Shop shop = new Shop();
		PersonInfo personInfo = new PersonInfo();
		ShopCategory shopCategory = new ShopCategory();
		Area area = new Area();
		area.setAreaId(1);
		personInfo.setUserId(1L);
		shopCategory.setShopCategoryId(1L);
		area.setAreaId(1);
		shop.setArea(area);
		shop.setOwner(personInfo);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试");
		shop.setShopDesc("测试");
		shop.setShopAddr("test");
		shop.setShopImg("test");
		shop.setPriority(1);
		shop.setPhone("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("test");
		int res = shopDao.insertShop(shop);
		assertEquals(1,res);
		
	}
	@Test
	@Ignore
	public void testUpdateShop(){
		Shop shop = new Shop();
		shop.setShopId(1L);
		
		shop.setShopAddr("测试修改");
		shop.setShopImg("测试修改");
		shop.setLastEditTime(new Date());
		
		int res = shopDao.updateShop(shop);
		assertEquals(1,res);
		
	}


}

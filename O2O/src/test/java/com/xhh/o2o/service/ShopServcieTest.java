package com.xhh.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xhh.o2o.BaseTest;
import com.xhh.o2o.dto.ImageHolder;
import com.xhh.o2o.dto.ShopExecution;
import com.xhh.o2o.entity.Area;
import com.xhh.o2o.entity.PersonInfo;
import com.xhh.o2o.entity.Shop;
import com.xhh.o2o.entity.ShopCategory;
import com.xhh.o2o.enums.ShopStateEnum;
import com.xhh.o2o.exceptions.ShopOperationException;

public class ShopServcieTest extends BaseTest{
	
	@Autowired
	private ShopService shopService;
	@Test
	
	public void testModifyShop() throws ShopOperationException,FileNotFoundException{
		Shop shop = new Shop();
		shop.setShopId(4L);
		shop.setShopName("修改后thumbnail");
		File shopImg = new File("D:/image/001.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder thumbnail = new ImageHolder("001.jpg",is);
		ShopExecution shopExecution = shopService.modifyShop(shop,thumbnail );
		System.out.println(shopExecution.getShop().getShopImg());
	}
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException{
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
		shop.setShopName("新增店铺thumbnail");
		shop.setShopDesc("测试");
		shop.setShopAddr("test");
		shop.setPriority(1);
		shop.setPhone("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("D:/image/001.jpg");
		System.out.println(shopImg);
		InputStream is = new FileInputStream(shopImg);
		ImageHolder thumbnail = new ImageHolder("001.jpg",is);
		ShopExecution se = shopService.addShop(shop,thumbnail);
		assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
	}
}

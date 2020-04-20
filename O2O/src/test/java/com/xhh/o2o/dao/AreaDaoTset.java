package com.xhh.o2o.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xhh.o2o.BaseTest;
import com.xhh.o2o.entity.Area;

public class AreaDaoTset extends BaseTest{
	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea(){
		List<Area> areaList = areaDao.queryArea();
		assertEquals(3,areaList.size());
		
	}

}

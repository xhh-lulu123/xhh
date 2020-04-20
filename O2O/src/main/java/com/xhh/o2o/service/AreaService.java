package com.xhh.o2o.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xhh.o2o.entity.Area;
@Service
public interface AreaService {
	public static final String AREALISTKEY = "arealist";
	/**
	 * 获取区域列表，优先从缓存获取
	 * 
	 * @return
	 */
	public List<Area> getAreaList();

}

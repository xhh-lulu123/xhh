package com.xhh.o2o.controller.superAdmian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xhh.o2o.entity.Area;
import com.xhh.o2o.service.AreaService;


@Controller
@RequestMapping("/superAdmin/")
public class AreaController {
	Logger logger = LoggerFactory.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;
	@RequestMapping(value="arealist",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> areaList(){
		logger.info("===start===");
		long startTime = System.currentTimeMillis();
		Map<String,Object> modelMap = new HashMap<String, Object>();
		List<Area> areaList = new ArrayList<Area>();
		try{
			areaList = areaService.getAreaList();
			modelMap.put("rows", areaList);
			modelMap.put("total", areaList.size());
			
		}catch(Exception e){
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		logger.error("test error");
		long endTime = System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",endTime-startTime);
		logger.info("===start===");
		return modelMap;
	}

}

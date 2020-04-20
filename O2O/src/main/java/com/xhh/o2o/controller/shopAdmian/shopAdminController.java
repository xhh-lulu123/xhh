package com.xhh.o2o.controller.shopAdmian;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/shopAdmin",method={RequestMethod.GET})
public class shopAdminController {
	@RequestMapping(value="/shopOperation")
	public String shopOperation(){
		return "shop/shopOperation";
	}
	
	@RequestMapping(value = "/shoplist")
	public String shopList() {
		// 转发至店铺列表页面
		return "shop/shoplist";
	}
	
	@RequestMapping(value = "/shopmanagement")
	public String shopManagement() {
		// 转发至店铺管理页面
		return "shop/shopmanagement";
	}
	@RequestMapping(value = "/productcategorymanagement")
	public String productCategoryManagement() {
		// 转发至商品类别管理
		return "shop/productcategorymanagement";
	}
	@RequestMapping(value = "/productmanagement")
	public String productManagement() {
		// 转发至商品管理页面
		return "shop/productmanagement";
	}
	@RequestMapping(value = "/productoperation")
	public String productOperation() {
		// 转发至商品添加/编辑页面
		return "shop/productoperation";
	}

}

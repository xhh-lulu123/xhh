package com.xhh.model.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xhh.model.domain.ApprovalManage;
import com.xhh.model.domain.GoodsManage;
import com.xhh.model.domain.Order;
import com.xhh.model.domain.Power;
import com.xhh.model.domain.RolePower;
import com.xhh.model.domain.RolesManage;
import com.xhh.model.domain.UsersLoginAction;
import com.xhh.model.domain.Usersinfo;
import com.xhh.model.domain.Userslog;
import com.xhh.model.service.IAdminManageService;

@Controller
@RequestMapping("/adminManage/")
public class AdminManageController {
	@Autowired
	private IAdminManageService service;
	@Autowired
	HttpServletRequest request;
	/**
	 * 添加用户登录账号及密码
	 * @param model
	 * @return
	 */
	@RequestMapping("addUserLogin")
	public ModelAndView addUserLogin(ModelAndView model){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String conpassword = request.getParameter("conpassword");
		//查找用户信息，并将此用户ID赋予给用户登录的ID
		Usersinfo user = service.queryUserLogin(name);
		Map<String,Object> map = new HashMap<>();
		map.put("password", password);
		map.put("name", name);
		map.put("id", user.getId());
		int res = service.addUserLogin(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","给予用户登录权限");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		if(res ==1&&password.equals(conpassword)){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/admin.jsp");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/adduser.jsp");
			model.addObject("reg", "error");
			return model;
				
		}
	}
	/**
	 * 添加用户详细信息
	 */
	@RequestMapping("addUserLoginInfo")
	public ModelAndView addUserLoginInfo(ModelAndView model){ 
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int qq = Integer.parseInt(request.getParameter("qq"));
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String job = request.getParameter("job");
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		String updateperson = userInfo.getName();
		Date createdate = new Date();
		Date updatedate = new Date();
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		map.put("sex", sex);
		map.put("phone", phone);
		map.put("email", email);
		map.put("qq", qq);
		map.put("type", type);
		map.put("address", address);
		map.put("updateperson", updateperson);
		map.put("createdate", createdate);
		map.put("updatedate", updatedate);
		map.put("job", job);
		int res = service.addUserLoginInfo(map);
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","添加用户");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			//查找新增的用户name，id
			//Usersinfo user = service.queryUserLogin(name);
			//把新增的用户id赋给角色管理表中的id			
			//service.addRoleID(user.getId());
			model.setViewName("redirect:../view/admin.jsp");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/adduserInfo.jsp");
			model.addObject("reg", "error");
			return model;
				
		}
	}
	/**
	 * 添加商品信息
	 */
	@RequestMapping("addGoods")
	public ModelAndView addGoods(ModelAndView model){ 
		String name = request.getParameter("name");                                                          
		double price= Double.parseDouble(request.getParameter("price"));                        
		double discount= Double.parseDouble(request.getParameter("discount"));         
		String type= request.getParameter("type");                  
		String descs= request.getParameter("descs");    
		String state= request.getParameter("state");		
		Date expirydate = null;
		try {
			expirydate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expirydate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		String createperson = userInfo.getName();
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		map.put("price", price);
		map.put("discount", discount);
		map.put("type", type);
		map.put("descs", descs);
		map.put("state", state);
		map.put("expirydate", expirydate);
		map.put("createperson", createperson);
		map.put("createdate", new Date());
		int res = service.addGoods(map);
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","添加商品");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/admin.jsp");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/addGoods.jsp");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 查询用户信息列表
	 */
	@RequestMapping("findUsers")
	public ModelAndView findUsers(ModelAndView model){ 
		List<Usersinfo> userList = service.findUsers();
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查询用户列表");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("userList", userList);
		model.setViewName("/view/usersList");
		
		return model;
	}
	/**
	 * 修改用户信息
	 */
	@RequestMapping("updateUserInfo")
	public ModelAndView updateUserInfo(ModelAndView model){ 
		String id = request.getParameter("id");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int qq = Integer.parseInt(request.getParameter("qq"));
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String job = request.getParameter("job");
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("sex", sex);
		map.put("phone", phone);
		map.put("email", email);
		map.put("qq", qq);
		map.put("type", type);
		map.put("address", address);
		map.put("job", job);
		int res = service.updateUserInfo(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","修改用户信息");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findUsers.action");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/updateUserInfo.jsp");
			model.addObject("reg", "error");
			return model;
		}
			
	}
	
	/**
	 * 查询用户信息列表
	 */
	@RequestMapping("findUsersByArg")
	public ModelAndView findUsersByName(ModelAndView model){ 
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		map.put("sex", sex);
		map.put("type", type);
		map.put("address", address);
		List<Usersinfo> userList = service.findUsersByName(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","条件查询用户信息");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("userList", userList);	
		
		model.setViewName("/view/usersList");
		
		return model;
	}
	/**
	 *删除用户信息 
	 * 
	 */
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(ModelAndView model){ 
		String id = request.getParameter("id");
		service.deleteUser(id);	
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","删除用户");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findUsers.action");
		return model;
	}
	/**
	 *删除用户登录信息，禁止登录 
	 * 
	 */
	@RequestMapping("deleteUserLogin")
	public ModelAndView deleteUserLogin(ModelAndView model){ 
		String id = request.getParameter("id");
		service.deleteUserLogin(id);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","禁用用户登录权限");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findUsers.action");
		return model;
	}
	/**
	 *分配角色
	 * 
	 */
	@RequestMapping("updateUserRoleName")
	public ModelAndView updateUserRoleName(ModelAndView model){ 
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println(name);
		if(name.equals("jingli")){
			name = "经理";
		}else if(name.equals("zhuguan")){
			name = "主管";
		}else if(name.equals("yuangong")){
			name = "员工";
		}else if(name.equals("guwen")){
			name = "顾问";
		}else if(name.equals("zuzhang")){
			name = "组长";
		}
		System.out.println(id);
		System.out.println(name);
		Map<String,Object> map  = new HashMap<>();
		map.put("id", id);
		map.put("rolename", name);
		service.updateUserRoleName(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","给用户分配角色");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findUsers.action");
		return model;
	}
	/**
	 * 查找用户登录日志
	 * @param model
	 * @return
	 */
	@RequestMapping("findUsersLoginInfo")
	public ModelAndView findUsersLoginInfo(ModelAndView model){ 
		List<UsersLoginAction> usersList = null;
		Map<String, Object> map = new HashMap<>();
		usersList = service.findUsersLoginInfo(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查看用户登录日志");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("usersList", usersList);	
		model.setViewName("/view/usersloginlog");
		return model;
	}
	/**
	 * 查找用户操作日志
	 * @param model
	 * @return
	 */
	@RequestMapping("findUsersLog")
	public ModelAndView findUsersLog(ModelAndView model){ 
		List<Userslog> usersList = null;
		Map<String, Object> map = new HashMap<>();
		usersList = service.findUsersLog(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查看用户操作日志");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("usersList", usersList);	
		model.setViewName("/view/usersLog");
		return model;
	}
	/**
	 * 显示订单列表
	 * @param model
	 * @return
	 */
	@RequestMapping("findOrder")
	public ModelAndView findOrder(ModelAndView model){ 
		List<Order> orderList = null;
		orderList = service.findOrder();
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查看订单");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("orderList", orderList);	
		model.setViewName("/view/adminOrderList");
		return model;
	}
	/**
	 * 提交订单
	 * @param model
	 * @return
	 */
	@RequestMapping("updateOrder")
	public ModelAndView updateOrder(ModelAndView model){ 
		String id = request.getParameter("id");
		service.updateOrder(id);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","提交订单");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findOrder.action");
		return model;
	}
	/**
	 * 删除订单
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteOrder")
	public ModelAndView deleteOrder(ModelAndView model){ 
		String id = request.getParameter("id");
		service.deleteOrder(id);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","删除订单");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findOrder.action");
		return model;
	}
	/**
	 * 条件查询订单
	 * @param model
	 * @return
	 */
	@RequestMapping("findOrderByArg")
	public ModelAndView findOrderByArg(ModelAndView model){ 
		List<Order> orderList = null;
		Map<String,Object> map = new HashMap<>();
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String createperson = request.getParameter("createperson");
		String pricestart = request.getParameter("pricestart");
		String priceend = request.getParameter("priceend");
		map.put("code", code); 
		map.put("name", name);
		map.put("createperson", createperson);
		map.put("pricestart", pricestart);
		map.put("priceend", priceend);
		orderList = service.findOrderByArg(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","条件查询订单");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("orderList", orderList);	
		model.setViewName("/view/adminOrderList");
		return model;
	}
	/**
	 * 查看商品列表
	 */
	@RequestMapping("findGoods")
	public ModelAndView findGoods(ModelAndView model){ 
		List<GoodsManage> goodsList = null;
		goodsList = service.findGoods();
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查看商品列表");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("goodsList", goodsList);	
		model.setViewName("/view/adminGoodsList");
		return model;
	}
	/**
	 * 通过名称/折扣/描述/种类查询商品
	 * @param model
	 * @return
	 */
	@RequestMapping("findGoodsByArg")
	public ModelAndView findGoodsByArg(ModelAndView model){ 
		List<GoodsManage> goodsList = null;
		Map<String,Object> map = new HashMap<>();
		String name = request.getParameter("name");
		String discount = request.getParameter("discount");
		String type = request.getParameter("type");
		String descs = request.getParameter("descs");
		map.put("name", name);
		map.put("discount", discount);
		map.put("type", type);
		map.put("descs", descs);
		goodsList = service.findGoodsByArg(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","条件查询商品");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("goodsList", goodsList);	
		model.setViewName("/view/adminGoodsList");
		return model;
	}
	/**
	 * 修改商品信息
	 */
	@RequestMapping("updateGood")
	public ModelAndView updateGood(ModelAndView model){ 
		Map<String,Object> map = new HashMap<>();
		//通过商品信息表获取商品的ID
		String id = request.getParameter("id");
		double price= Double.parseDouble(request.getParameter("price"));                        
		double discount= Double.parseDouble(request.getParameter("discount"));         
		String type= request.getParameter("type");                  
		String descs= request.getParameter("descs");    
		String state= request.getParameter("state");		
		Date expirydate = null;
		try {
			expirydate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expirydate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		map.put("id", id);
		map.put("price", price);
		map.put("discount", discount);
		map.put("type", type);
		map.put("descs", descs);
		map.put("state", state);
		map.put("expirydate", expirydate);
		int res = service.updateGood(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","修改商品");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findGoods.action");
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/updateGood.jsp");
			model.addObject("reg", "error");
		}
		return model;
	}
	/**
	 * 通过id查询商品信息
	 * @param model
	 * @return
	 */
	@RequestMapping("queryGoodById")
	public ModelAndView queryGoodById(ModelAndView model){ 
		//通过商品信息表获取商品的ID
		String id = request.getParameter("id");
		//通过ID查询该商品信息，商品对象放入request域中，修改商品信息时默认显示没修改时的数据
		GoodsManage good = service.findGoodById(id);
		model.addObject("good", good);
		model.setViewName("../view/updateGood");
		return model;	
	}
	/**
	 * 删除商品
	 */
	@RequestMapping("deleteGood")
	public ModelAndView deleteGood(ModelAndView model){ 
		//通过商品信息表获取商品的ID
		String id = request.getParameter("id");
		int res = service.deleteGood(id);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","删除商品");
		logMap.put("dodate", new Date());
		logMap.put("domod", "商品模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findGoods,action");
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findGoods,action");
		}
		return model;
	}
	/**
	 * 查询管理员信息列表
	 */
	@RequestMapping("findAdmin")
	public ModelAndView findAdmin(ModelAndView model){ 
		List<Usersinfo> userList = service.findAdmin();
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查询用户列表");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		model.addObject("userList", userList);
		model.setViewName("/view/usersList");
		model.addObject("text", "adminList");
		return model;
	}
	/**
	 * 查询角色信息列表
	 */
	@RequestMapping("findRoles")
	public ModelAndView findRoles(ModelAndView model){ 
		List<RolesManage> rolesList = service.findroles();
		System.out.println(rolesList.size());
		model.addObject("rolesList", rolesList);
		model.setViewName("/view/rolesList");
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查询用户列表");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		return model;
	}
	/**
	 * 添加角色
	 */
	@RequestMapping("addRole")
	public ModelAndView addRole(ModelAndView model){ 
		Map<String,Object> map = new HashMap<>();
		String name = request.getParameter("name");
		String roledescs = request.getParameter("roledescs");
		System.out.println(roledescs);
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");
		String createperson = user.getName();
		System.out.println(createperson);
		
		map.put("name", name);
		map.put("roledesc", roledescs);
		map.put("createperson", createperson);
		map.put("createdate", new Date());
		int res = service.addRole(map);
		//获取session对象
		HttpSession session2 = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session2.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","添加角色");
		logMap.put("dodate", new Date());
		logMap.put("domod", "系统管理模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			System.out.println(name+"/*******************");
			service.addRolePower(name);//角色创建成功，在权限管理表中创建此角色
			model.setViewName("redirect:findRoles.action");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/addRole.jsp");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 删除角色
	 */
	@RequestMapping("deleteRole")
	public ModelAndView deleteRole(ModelAndView model){ 
		String id = request.getParameter("id");
		int res = service.deleteRole(id);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","删除角色");
		logMap.put("dodate", new Date());
		logMap.put("domod", "系统管理模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRoles.action");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRoles.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 修改角色信息
	 */
	@RequestMapping("updateRole")
	public ModelAndView updateRole(ModelAndView model){ 
		String id = request.getParameter("id");
		String roledesc = request.getParameter("roledesc");
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("roledesc", roledesc);
		int res = service.updateRole(map);
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","修改角色信息");
		logMap.put("dodate", new Date());
		logMap.put("domod", "系统管理模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRoles.action");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:updateRolePro.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 查询权限列表
	 */
	@RequestMapping("findPower")
	public ModelAndView findPower(ModelAndView model){ 
		List<Power> powerList = service.findpower();
		model.addObject("powerList", powerList);
		model.setViewName("/view/powerList");
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查询用户列表");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		return model;
	}
	/**
	 * 添加权限
	 */
	@RequestMapping("addPower")
	public ModelAndView addPower(ModelAndView model){ 
		Map<String,Object> map = new HashMap<>();
		String name = request.getParameter("name");
		String descs = request.getParameter("descs");
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");
		String createperson = user.getName();
		System.out.println(createperson);
		
		map.put("name", name);
		map.put("descs", descs);
		map.put("createperson", createperson);
		map.put("createdate", new Date());
		int res = service.addPower(map);
		//获取session对象
		HttpSession session2 = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session2.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","添加权限");
		logMap.put("dodate", new Date());
		logMap.put("domod", "用户模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findPower.action");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/addPower.jsp");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 删除权限
	 */
	@RequestMapping("deletePower")
	public ModelAndView deletePower(ModelAndView model){ 
		String id = request.getParameter("id");
		int res = service.deletePower(id);
		//获取session对象
		HttpSession session2 = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session2.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","删除权限");
		logMap.put("dodate", new Date());
		logMap.put("domod", "系统管理模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findPower.action");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findPower.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 权限管理页面
	 */
	@RequestMapping("findRolePower")
	public ModelAndView findRolePower(ModelAndView model){ 
		List<Power> powerList = service.findpower();//查询所有权限，在jsp页面显示所有权限名称供选择
		model.addObject("powerList", powerList);
		List<RolePower> rolePowerList = service.findRolePower();
		model.addObject("rolePowerList", rolePowerList);
		model.setViewName("/view/rolePowerList");
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","查询权限");
		logMap.put("dodate", new Date());
		logMap.put("domod", "系统管理模块");
		logMap.put("result", "成功");
		service.insertUserLog(logMap);
		return model;
	}
	/**
	 * 权限管理页面，给角色赋权
	 */
	@RequestMapping("updateRolePowerByName")
	public ModelAndView updateRolePowerByName(ModelAndView model){ 
		
		String name = request.getParameter("name");
		String power = request.getParameter("power");
		//获取session对象
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		String manageperson = userInfo.getName();
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		map.put("power", power);
		map.put("manageperson", manageperson);
		map.put("managedate", new Date());
		int res  = service.updateRolePowerByName(map);
		
		//存放用户操作日志数据
		Map<String,Object> logMap = new HashMap<>();
		//获取操作的用户信息并放入logMap中
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","赋权");
		logMap.put("dodate", new Date());
		logMap.put("domod", "系统管理模块");
		if(res==1){
			logMap.put("result", "成功");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRolePower.action");
			return model;
		}else{
			logMap.put("result", "失败");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRolePower.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 修改权限描述
	 */
	@RequestMapping("updatePower")
	public ModelAndView updatePower(ModelAndView model){ 
		
		String id = request.getParameter("id");
		String descs = request.getParameter("descs");
		System.out.println(id);
		System.out.println(descs);
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("descs", descs);
		int res  = service.updatePower(map);
		if(res==1){
			model.setViewName("redirect:findPower.action");
			return model;
		}else{
			model.setViewName("redirect:../view/updatePower.jsp");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 按照id删除该角色权限
	 */
	@RequestMapping("deleteRolePower")
	public ModelAndView deleteRolePower(ModelAndView model){ 
		String id = request.getParameter("id");
		int res = service.deleteRolePower(id);
		if(res==1){
			model.setViewName("redirect:findRolePower.action");
			return model;
		}else{
			model.setViewName("redirect:findRolePower.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * 查看待审批申请
	 */
	@RequestMapping("findApprovalManage")
	public ModelAndView findApprovalManage(ModelAndView model){ 
		String state = "已提交";
		Map<String,Object> map = new HashMap<>();
		map.put("state", state);
		List<ApprovalManage> approvalManageList = service.findApprovalManage(map);
		model.addObject("approvalManageList", approvalManageList);
		model.setViewName("../view/approvalManageList");
		return model;
	}
	/**
	 * 查看待已审批申请
	 */
	@RequestMapping("findApprovalManageOver")
	public ModelAndView findApprovalManageOver(ModelAndView model){ 
		String state = "已审批";
		Map<String,Object> map = new HashMap<>();
		map.put("state", state);
		List<ApprovalManage> approvalManageList = service.findApprovalManage(map);
		model.addObject("approvalManageList", approvalManageList);
		model.setViewName("../view/approvalManageList");
		return model;
	}
}
















package com.xhh.model.controller;

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

import com.xhh.model.domain.AllApproval;
import com.xhh.model.domain.ApprovalManage;
import com.xhh.model.domain.GoodsManage;
import com.xhh.model.domain.Order;
import com.xhh.model.domain.OrderInfo;
import com.xhh.model.domain.Usersinfo;
import com.xhh.model.service.IUsersService;

@Controller
@RequestMapping("users")
public class UsersManagerController {
	@Autowired
	private IUsersService service;
	@Autowired
	HttpServletRequest request;
	/**
	 * 商品列表
	 * @param model
	 * @return
	 */
	@RequestMapping("findGoods")
	public ModelAndView findGoods(ModelAndView model){ 
		List<GoodsManage> goodsList = null;
		goodsList = service.findGoods();
		System.out.println(goodsList.size());
		model.addObject("goodsList", goodsList);	
		model.setViewName("/view/goodsList");
		return model;
	}
	/**
	 * 购买商品，创建订单，创建订单详情
	 * @param model
	 * @return
	 */
	@RequestMapping("insertOrder")
	public ModelAndView insertOrder(ModelAndView model){ 
		Map<String,Object> map = new HashMap<>();
		
		//通过商品信息表获取商品的ID
		String id = request.getParameter("id");
		
		//通过ID查询该商品信息
		GoodsManage good = service.findGoodById(id);
		//把商品信息传入到创建的订单中
		//查询已有订单数，创建订单编号
		List<Order> orderList = service.findOrder();
		String code = "code2222".concat(String.valueOf(orderList.size()+1));
		String name = good.getName();
		double price = good.getPrice();
		double discount = good.getDiscount();
		String state = "保存";
		String paytype = request.getParameter("paytype");
		Date createdate = new Date();//订单创建时间
		//获取session对象，生成此订单的创建人
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");
		String createperson = user.getName();
		//插入数据
		map.put("code", code);
		map.put("name", name);
		map.put("price", price);
		map.put("discount", discount);
		map.put("state", state);
		map.put("paytype", paytype);
		map.put("createperson", createperson);
		map.put("createdate", createdate);
		int res = service.insertOrder(map);
		Map<String,Object> infoMap = new HashMap<>();//订单详情参数map
		//订单详情参数
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		//购买商品创建订单，通过订单编号，生成订单ID，通过订单编号code查找该订单ID，赋予给订单详情的orderid
		Order order = service.findOrderByCode(code);
		if(res==1){
			//生成订单成功，创建订单详情
			infoMap.put("orderid", order.getId());
			infoMap.put("ordercode", code);
			infoMap.put("goodid", id);
			infoMap.put("goodname", name);
			infoMap.put("goodprice", price);
			infoMap.put("gooddiscount", discount);
			infoMap.put("goodtype", good.getType());
			infoMap.put("gooddescs", good.getDescs());
			infoMap.put("address", address);
			infoMap.put("phone", phone);
			service.insertOrderInfo(infoMap);
			model.setViewName("redirect:findGoods.action");
		}else{
			model.addObject("error", "error");
			model.setViewName("/view/buyGood");
		}
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
		model.addObject("goodsList", goodsList);	
		model.setViewName("/view/goodsList");
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
		model.addObject("orderList", orderList);	
		model.setViewName("/view/orderList");
		return model;
	}
	/**
	 * 显示订单详情列表
	 * @param model
	 * @return
	 */
	@RequestMapping("findOrderInfo")
	public ModelAndView findOrderInfo(ModelAndView model){ 
		List<OrderInfo> orderInfoList = null;
		orderInfoList = service.findOrderInfo();
		model.addObject("orderInfoList", orderInfoList);	
		model.setViewName("/view/orderInfoList");
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
		model.addObject("orderList", orderList);	
		model.setViewName("/view/orderList");
		return model;
	}
	/**
	 * 插入数据提交审批
	 * @param model
	 * @return
	 */
	@RequestMapping("addApproval")
	public ModelAndView addSubApproval(ModelAndView model){ 
		String type = request.getParameter("type");
		String approvalPerson = request.getParameter("approvalPerson");
		int days = Integer.parseInt( request.getParameter("days"));
		String state = request.getParameter("state");
		String reason = request.getParameter("reason");
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");//获取当前登录用户对象
		String applyPerson = user.getName();
		Map<String,Object> map = new HashMap<>();
		map.put("type", type);
		map.put("approvalPerson", approvalPerson);
		map.put("days", days);
		map.put("state", state);
		map.put("reason", reason);
		map.put("applyPerson", applyPerson);
		map.put("applyDate", new Date());
		int res = service.addApprovalManage(map);
		if(res==1){//如果插入成功，则包数据保存到审批管理表中
			model.setViewName("redirect:findApproval.action");
			return model;
			
		}else{
			model.addObject("error", "error");
			model.setViewName("/view/addApproval");
			return model;
		}	
	}
	/**
	 * 查询用户类型
	 */
	@RequestMapping("findUserManage")
	public ModelAndView findUserType(ModelAndView model){ 
		List<Usersinfo> usersList = service.findUsersManage();
		model.addObject("usersList", usersList);
		model.setViewName("/view/addApproval");
		return model;
	}
	/**
	 * 查询审批
	 */
	@RequestMapping("findApproval")
	public ModelAndView findApproval(ModelAndView model){ 
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");//获取当前登录用户对象
		String currentPerson = user.getName();
		String rolename = user.getRolename();
		System.out.println(currentPerson+"************");
		System.out.println(rolename+"*************");
		
		if(rolename!="经理"&&rolename!="admin"){//普通用户查询审批
			Map<String,Object> savedMap = new HashMap<>();
			savedMap.put("applyPerson", currentPerson);
			savedMap.put("approvalPerson", null);
			savedMap.put("state", "保存");
			List<ApprovalManage> savedList = service.findApproval(savedMap);//查询状态为保存的申请
			int savedNum = savedList.size();
			Map<String,Object> approvalMap = new HashMap<>();
			approvalMap.put("applyPerson", currentPerson);
			approvalMap.put("approvalPerson", null);
			approvalMap.put("state", "已提交");
			List<ApprovalManage> approvalList = service.findApproval(approvalMap);//查询状态为提交的申请
			int approvalNum = approvalList.size();
			Map<String,Object> pastMap = new HashMap<>();
			pastMap.put("applyPerson", currentPerson);
			pastMap.put("approvalPerson", null);
			pastMap.put("state", "已审批");
			model.addObject("savedNum", savedNum);
			model.addObject("approvalNum", approvalNum);
		}if(rolename.equals("经理")){//角色为经理的查询审批
			Map<String,Object> approvalMap = new HashMap<>();
			approvalMap.put("approvalPerson", currentPerson);
			approvalMap.put("applyperson", null);
			approvalMap.put("state", "已提交");
			List<ApprovalManage> approvalList = service.findApproval(approvalMap);//查询状态为提交的申请
			int approvalNum = approvalList.size();
			Map<String,Object> pastMap = new HashMap<>();
			pastMap.put("approvalPerson", currentPerson);
			pastMap.put("applyperson", null);
			pastMap.put("state", "已审批");	
			model.addObject("approvalNum", approvalNum);
		}
		model.setViewName("/view/officeOA");	
		return model;
	}
	/**
	 * 通过状态查询审批
	 */
	@RequestMapping("findApprovalManage")
	public ModelAndView findApprovalManage(ModelAndView model){ 
		String state = request.getParameter("state");
		if(state.equals("baocun")){
			state = "保存";
		}else if(state.equals("tijiao")){
			state = "已提交";
		}else if(state.equals("shenpi")){
			state = "已审批";
		}
		Map<String,Object> map = new HashMap<>();
		map.put("state", state);
		List<ApprovalManage> approvalManageList = service.findApproval(map);//查询状态为保存的审批
		model.addObject("approvalManageList", approvalManageList);
		model.setViewName("/view/approvalManageList");
		return model;
	}
	/**
	 *提交，审批申请（更改申请状态）
	 */
	@RequestMapping("updateApprovalState")
	public ModelAndView updateApprovalState(ModelAndView model){ 
		String state = request.getParameter("state");
		String id = request.getParameter("id");
		if(state.equals("tijiao")){
			state = "已提交";
		}else if(state.equals("shenpi")){
			state = "已审批";
		}
		Map<String,Object> map = new HashMap<>();
		map.put("state", state);
		map.put("id", id);
		int res = service.updateApprovalManage(map);
		if(res==1){
			model.setViewName("redirect:findApproval.action");
			if(state.equals("已审批")){
				String result = request.getParameter("result");
				if(result.equals("pizhun")){
					result = "批准";
				}else if(result.equals("bohui")){
					result = "驳回";
				}
				System.out.println(result+"*********************");
				ApprovalManage approval = service.findApprovalById(id);//查找此次审批的申请数据
				Map<String,Object> overMap = new HashMap<>();//存放审批结果
				String createperson = approval.getApplyPerson();
				String applyperson = approval.getApprovalPerson();
				int days = approval.getDays();
				String type = approval.getType();
				String reason = approval.getReason();
				System.out.println(id+"\t"+createperson+"\t"+applyperson+"\t"+new Date()
						+"\t"+days+"\t"+type+"\t"+reason+"\t"+result+"\t"+"state");
				overMap.put("id", id);
				overMap.put("createperson",createperson);
				overMap.put("applyperson",applyperson);
				overMap.put("applydate", new Date());
				overMap.put("result", result);
				overMap.put("days", days);
				overMap.put("type", type);
				overMap.put("state", "已审批");
				overMap.put("reason", reason);
				service.insertApprovalResult(overMap);//插入已审批申请表中
				
			}
			return model;
		}
		
		return model;
	}
	/**
	 *查询审批结果
	 */
	@RequestMapping("findApprovalResult")
	public ModelAndView findApprovalResult(ModelAndView model){ 
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");//获取当前登录用户对象
		String currentPerson = user.getName();
		String rolename = user.getRolename();
		if(rolename!="经理"&&rolename!="admin"){//普通用户查询审批
			Map<String,Object> map = new HashMap<>();
			map.put("createperson", currentPerson);
			map.put("applyperson", null);
			List<AllApproval> approvalResultList = service.findApprovalResult(map);
			model.addObject("approvalResultList", approvalResultList);
		}if(rolename.equals("经理")){//角色为经理的查询审批
			Map<String,Object> map = new HashMap<>();
			map.put("applyperson", currentPerson);
			map.put("createperson", null);
			List<AllApproval> approvalResultList = service.findApprovalResult(map);
			model.addObject("approvalResultList", approvalResultList);
		}	
		model.setViewName("/view/approvalResultList");
		return model;
	}
	
}

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
	 * ����û���¼�˺ż�����
	 * @param model
	 * @return
	 */
	@RequestMapping("addUserLogin")
	public ModelAndView addUserLogin(ModelAndView model){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String conpassword = request.getParameter("conpassword");
		//�����û���Ϣ���������û�ID������û���¼��ID
		Usersinfo user = service.queryUserLogin(name);
		Map<String,Object> map = new HashMap<>();
		map.put("password", password);
		map.put("name", name);
		map.put("id", user.getId());
		int res = service.addUserLogin(map);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","�����û���¼Ȩ��");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		if(res ==1&&password.equals(conpassword)){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/admin.jsp");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/adduser.jsp");
			model.addObject("reg", "error");
			return model;
				
		}
	}
	/**
	 * ����û���ϸ��Ϣ
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
		//��ȡsession����
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
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","����û�");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			//�����������û�name��id
			//Usersinfo user = service.queryUserLogin(name);
			//���������û�id������ɫ������е�id			
			//service.addRoleID(user.getId());
			model.setViewName("redirect:../view/admin.jsp");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/adduserInfo.jsp");
			model.addObject("reg", "error");
			return model;
				
		}
	}
	/**
	 * �����Ʒ��Ϣ
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
		//��ȡsession����
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
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","�����Ʒ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/admin.jsp");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/addGoods.jsp");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * ��ѯ�û���Ϣ�б�
	 */
	@RequestMapping("findUsers")
	public ModelAndView findUsers(ModelAndView model){ 
		List<Usersinfo> userList = service.findUsers();
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","��ѯ�û��б�");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("userList", userList);
		model.setViewName("/view/usersList");
		
		return model;
	}
	/**
	 * �޸��û���Ϣ
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
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","�޸��û���Ϣ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findUsers.action");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/updateUserInfo.jsp");
			model.addObject("reg", "error");
			return model;
		}
			
	}
	
	/**
	 * ��ѯ�û���Ϣ�б�
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
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","������ѯ�û���Ϣ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("userList", userList);	
		
		model.setViewName("/view/usersList");
		
		return model;
	}
	/**
	 *ɾ���û���Ϣ 
	 * 
	 */
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(ModelAndView model){ 
		String id = request.getParameter("id");
		service.deleteUser(id);	
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","ɾ���û�");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findUsers.action");
		return model;
	}
	/**
	 *ɾ���û���¼��Ϣ����ֹ��¼ 
	 * 
	 */
	@RequestMapping("deleteUserLogin")
	public ModelAndView deleteUserLogin(ModelAndView model){ 
		String id = request.getParameter("id");
		service.deleteUserLogin(id);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","�����û���¼Ȩ��");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findUsers.action");
		return model;
	}
	/**
	 *�����ɫ
	 * 
	 */
	@RequestMapping("updateUserRoleName")
	public ModelAndView updateUserRoleName(ModelAndView model){ 
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println(name);
		if(name.equals("jingli")){
			name = "����";
		}else if(name.equals("zhuguan")){
			name = "����";
		}else if(name.equals("yuangong")){
			name = "Ա��";
		}else if(name.equals("guwen")){
			name = "����";
		}else if(name.equals("zuzhang")){
			name = "�鳤";
		}
		System.out.println(id);
		System.out.println(name);
		Map<String,Object> map  = new HashMap<>();
		map.put("id", id);
		map.put("rolename", name);
		service.updateUserRoleName(map);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","���û������ɫ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findUsers.action");
		return model;
	}
	/**
	 * �����û���¼��־
	 * @param model
	 * @return
	 */
	@RequestMapping("findUsersLoginInfo")
	public ModelAndView findUsersLoginInfo(ModelAndView model){ 
		List<UsersLoginAction> usersList = null;
		Map<String, Object> map = new HashMap<>();
		usersList = service.findUsersLoginInfo(map);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","�鿴�û���¼��־");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("usersList", usersList);	
		model.setViewName("/view/usersloginlog");
		return model;
	}
	/**
	 * �����û�������־
	 * @param model
	 * @return
	 */
	@RequestMapping("findUsersLog")
	public ModelAndView findUsersLog(ModelAndView model){ 
		List<Userslog> usersList = null;
		Map<String, Object> map = new HashMap<>();
		usersList = service.findUsersLog(map);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","�鿴�û�������־");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("usersList", usersList);	
		model.setViewName("/view/usersLog");
		return model;
	}
	/**
	 * ��ʾ�����б�
	 * @param model
	 * @return
	 */
	@RequestMapping("findOrder")
	public ModelAndView findOrder(ModelAndView model){ 
		List<Order> orderList = null;
		orderList = service.findOrder();
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","�鿴����");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("orderList", orderList);	
		model.setViewName("/view/adminOrderList");
		return model;
	}
	/**
	 * �ύ����
	 * @param model
	 * @return
	 */
	@RequestMapping("updateOrder")
	public ModelAndView updateOrder(ModelAndView model){ 
		String id = request.getParameter("id");
		service.updateOrder(id);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","�ύ����");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findOrder.action");
		return model;
	}
	/**
	 * ɾ������
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteOrder")
	public ModelAndView deleteOrder(ModelAndView model){ 
		String id = request.getParameter("id");
		service.deleteOrder(id);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","ɾ������");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.setViewName("redirect:findOrder.action");
		return model;
	}
	/**
	 * ������ѯ����
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
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","������ѯ����");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("orderList", orderList);	
		model.setViewName("/view/adminOrderList");
		return model;
	}
	/**
	 * �鿴��Ʒ�б�
	 */
	@RequestMapping("findGoods")
	public ModelAndView findGoods(ModelAndView model){ 
		List<GoodsManage> goodsList = null;
		goodsList = service.findGoods();
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","�鿴��Ʒ�б�");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("goodsList", goodsList);	
		model.setViewName("/view/adminGoodsList");
		return model;
	}
	/**
	 * ͨ������/�ۿ�/����/�����ѯ��Ʒ
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
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","������ѯ��Ʒ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("goodsList", goodsList);	
		model.setViewName("/view/adminGoodsList");
		return model;
	}
	/**
	 * �޸���Ʒ��Ϣ
	 */
	@RequestMapping("updateGood")
	public ModelAndView updateGood(ModelAndView model){ 
		Map<String,Object> map = new HashMap<>();
		//ͨ����Ʒ��Ϣ���ȡ��Ʒ��ID
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
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","�޸���Ʒ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findGoods.action");
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/updateGood.jsp");
			model.addObject("reg", "error");
		}
		return model;
	}
	/**
	 * ͨ��id��ѯ��Ʒ��Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("queryGoodById")
	public ModelAndView queryGoodById(ModelAndView model){ 
		//ͨ����Ʒ��Ϣ���ȡ��Ʒ��ID
		String id = request.getParameter("id");
		//ͨ��ID��ѯ����Ʒ��Ϣ����Ʒ�������request���У��޸���Ʒ��ϢʱĬ����ʾû�޸�ʱ������
		GoodsManage good = service.findGoodById(id);
		model.addObject("good", good);
		model.setViewName("../view/updateGood");
		return model;	
	}
	/**
	 * ɾ����Ʒ
	 */
	@RequestMapping("deleteGood")
	public ModelAndView deleteGood(ModelAndView model){ 
		//ͨ����Ʒ��Ϣ���ȡ��Ʒ��ID
		String id = request.getParameter("id");
		int res = service.deleteGood(id);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","ɾ����Ʒ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "��Ʒģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findGoods,action");
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findGoods,action");
		}
		return model;
	}
	/**
	 * ��ѯ����Ա��Ϣ�б�
	 */
	@RequestMapping("findAdmin")
	public ModelAndView findAdmin(ModelAndView model){ 
		List<Usersinfo> userList = service.findAdmin();
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","��ѯ�û��б�");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		model.addObject("userList", userList);
		model.setViewName("/view/usersList");
		model.addObject("text", "adminList");
		return model;
	}
	/**
	 * ��ѯ��ɫ��Ϣ�б�
	 */
	@RequestMapping("findRoles")
	public ModelAndView findRoles(ModelAndView model){ 
		List<RolesManage> rolesList = service.findroles();
		System.out.println(rolesList.size());
		model.addObject("rolesList", rolesList);
		model.setViewName("/view/rolesList");
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","��ѯ�û��б�");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		return model;
	}
	/**
	 * ��ӽ�ɫ
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
		//��ȡsession����
		HttpSession session2 = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session2.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","��ӽ�ɫ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "ϵͳ����ģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			System.out.println(name+"/*******************");
			service.addRolePower(name);//��ɫ�����ɹ�����Ȩ�޹�����д����˽�ɫ
			model.setViewName("redirect:findRoles.action");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/addRole.jsp");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * ɾ����ɫ
	 */
	@RequestMapping("deleteRole")
	public ModelAndView deleteRole(ModelAndView model){ 
		String id = request.getParameter("id");
		int res = service.deleteRole(id);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","ɾ����ɫ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "ϵͳ����ģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRoles.action");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRoles.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * �޸Ľ�ɫ��Ϣ
	 */
	@RequestMapping("updateRole")
	public ModelAndView updateRole(ModelAndView model){ 
		String id = request.getParameter("id");
		String roledesc = request.getParameter("roledesc");
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("roledesc", roledesc);
		int res = service.updateRole(map);
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","�޸Ľ�ɫ��Ϣ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "ϵͳ����ģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRoles.action");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:updateRolePro.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * ��ѯȨ���б�
	 */
	@RequestMapping("findPower")
	public ModelAndView findPower(ModelAndView model){ 
		List<Power> powerList = service.findpower();
		model.addObject("powerList", powerList);
		model.setViewName("/view/powerList");
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","��ѯ�û��б�");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		return model;
	}
	/**
	 * ���Ȩ��
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
		//��ȡsession����
		HttpSession session2 = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session2.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "insert");
		logMap.put("doinfo","���Ȩ��");
		logMap.put("dodate", new Date());
		logMap.put("domod", "�û�ģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findPower.action");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:../view/addPower.jsp");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * ɾ��Ȩ��
	 */
	@RequestMapping("deletePower")
	public ModelAndView deletePower(ModelAndView model){ 
		String id = request.getParameter("id");
		int res = service.deletePower(id);
		//��ȡsession����
		HttpSession session2 = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session2.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "delete");
		logMap.put("doinfo","ɾ��Ȩ��");
		logMap.put("dodate", new Date());
		logMap.put("domod", "ϵͳ����ģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findPower.action");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findPower.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * Ȩ�޹���ҳ��
	 */
	@RequestMapping("findRolePower")
	public ModelAndView findRolePower(ModelAndView model){ 
		List<Power> powerList = service.findpower();//��ѯ����Ȩ�ޣ���jspҳ����ʾ����Ȩ�����ƹ�ѡ��
		model.addObject("powerList", powerList);
		List<RolePower> rolePowerList = service.findRolePower();
		model.addObject("rolePowerList", rolePowerList);
		model.setViewName("/view/rolePowerList");
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "select");
		logMap.put("doinfo","��ѯȨ��");
		logMap.put("dodate", new Date());
		logMap.put("domod", "ϵͳ����ģ��");
		logMap.put("result", "�ɹ�");
		service.insertUserLog(logMap);
		return model;
	}
	/**
	 * Ȩ�޹���ҳ�棬����ɫ��Ȩ
	 */
	@RequestMapping("updateRolePowerByName")
	public ModelAndView updateRolePowerByName(ModelAndView model){ 
		
		String name = request.getParameter("name");
		String power = request.getParameter("power");
		//��ȡsession����
		HttpSession session = request.getSession(false);
		Usersinfo userInfo = (Usersinfo) session.getAttribute("user");
		String manageperson = userInfo.getName();
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		map.put("power", power);
		map.put("manageperson", manageperson);
		map.put("managedate", new Date());
		int res  = service.updateRolePowerByName(map);
		
		//����û�������־����
		Map<String,Object> logMap = new HashMap<>();
		//��ȡ�������û���Ϣ������logMap��
		logMap.put("id", userInfo.getId());
		logMap.put("name", userInfo.getName());
		logMap.put("type", "update");
		logMap.put("doinfo","��Ȩ");
		logMap.put("dodate", new Date());
		logMap.put("domod", "ϵͳ����ģ��");
		if(res==1){
			logMap.put("result", "�ɹ�");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRolePower.action");
			return model;
		}else{
			logMap.put("result", "ʧ��");
			service.insertUserLog(logMap);
			model.setViewName("redirect:findRolePower.action");
			model.addObject("reg", "error");
			return model;
		}
	}
	/**
	 * �޸�Ȩ������
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
	 * ����idɾ���ý�ɫȨ��
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
	 * �鿴����������
	 */
	@RequestMapping("findApprovalManage")
	public ModelAndView findApprovalManage(ModelAndView model){ 
		String state = "���ύ";
		Map<String,Object> map = new HashMap<>();
		map.put("state", state);
		List<ApprovalManage> approvalManageList = service.findApprovalManage(map);
		model.addObject("approvalManageList", approvalManageList);
		model.setViewName("../view/approvalManageList");
		return model;
	}
	/**
	 * �鿴������������
	 */
	@RequestMapping("findApprovalManageOver")
	public ModelAndView findApprovalManageOver(ModelAndView model){ 
		String state = "������";
		Map<String,Object> map = new HashMap<>();
		map.put("state", state);
		List<ApprovalManage> approvalManageList = service.findApprovalManage(map);
		model.addObject("approvalManageList", approvalManageList);
		model.setViewName("../view/approvalManageList");
		return model;
	}
}
















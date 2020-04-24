package com.xhh.model.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xhh.model.domain.Admin;
import com.xhh.model.domain.UsersLogin;
import com.xhh.model.domain.Usersinfo;
import com.xhh.model.service.IAdminManageService;
import com.xhh.model.service.IUsersService;

@Controller
public class LoginController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	private IAdminManageService adminService;
	@Autowired
	private IUsersService userService;
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView model){
		String name = request.getParameter("name");
		System.out.println(name);
		String password = request.getParameter("password");
		System.out.println(password);
		String role = request.getParameter("role");
		//����Ա��¼
		if(role.equals("admin")){
			Map<String,Object> map = new HashMap<String, Object>();//��ŵ�¼�û���������
			map.put("name", name);
			map.put("password", password);
			Admin admin = adminService.queryAdmin(map);
			if(admin!=null){
				//��¼�ɹ��������û���¼ʱ�估IP
				Map<String,Object> userMap = new HashMap<String, Object>();
				userMap.put("name", name);
				Date lastdate = new Date();
				userMap.put("lastdate",lastdate);
				try {
					userMap.put("lastip", InetAddress.getLocalHost().getHostAddress());//����IP
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				adminService.updateUserDateIP(userMap);
				//�����û���Ϣ���������û�ID������û���¼��־���ID
				Usersinfo userInfo = adminService.queryUserLogin(name);
				Map<String,Object> logMap = new HashMap<String, Object>();//��ŵ�¼��־������
				logMap.put("id", userInfo.getId());
				logMap.put("name", name);
				logMap.put("type", userInfo.getType());
				logMap.put("logindate", new Date());
				try {
					logMap.put("loginip", InetAddress.getLocalHost().getHostAddress());
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				logMap.put("loginresult", "�ɹ�");
				adminService.insertUserLoginAction(logMap);
				
				
				HttpSession session = request.getSession();
				session.setAttribute("user", userInfo);//���û��������session����
				model.setViewName("redirect:view/admin.jsp");
				return model;
			}else{
				//�����û���Ϣ���������û�ID������û���¼��־���ID
				Usersinfo user = adminService.queryUserLogin(name);
				Map<String,Object> logMap = new HashMap<String, Object>();//��ŵ�¼��־������
				
				logMap.put("id", user.getId());
				logMap.put("name", name);
				logMap.put("type", user.getType());
				logMap.put("logindate", new Date());
				try {
					logMap.put("loginip", InetAddress.getLocalHost().getHostAddress());
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				logMap.put("loginresult", "ʧ��");
				adminService.insertUserLoginAction(logMap);
				model.setViewName("redirect:index.jsp");
				model.addObject("reg", "error");
				return model;
			}
		}else if(role.equals("user")){  //��Ա��¼
			//��¼�ɹ��������û���¼ʱ�估IP
			Map<String,Object> userMap = new HashMap<String, Object>();
			userMap.put("name", name);
			userMap.put("lastdate",new Date());
			try {
				userMap.put("lastip", InetAddress.getLocalHost().getHostAddress());//����IP
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			System.out.println();
			adminService.updateUserDateIP(userMap);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("name", name);
			map.put("password", password);
			UsersLogin user = userService.userLogin(map);
			if(user!=null){
				//�����û���Ϣ���������û�ID������û���¼��־���ID
				Usersinfo userInfo = adminService.queryUserLogin(name);
				Map<String,Object> logMap = new HashMap<String, Object>();//��ŵ�¼��־������
				
				logMap.put("id", userInfo.getId());
				logMap.put("name", name);
				logMap.put("type", userInfo.getType());
				logMap.put("logindate", new Date());
				try {
					logMap.put("loginip", InetAddress.getLocalHost().getHostAddress());
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				logMap.put("loginresult", "�ɹ�");
				adminService.insertUserLoginAction(logMap);
				HttpSession session = request.getSession();
				
				session.setAttribute("user", userInfo);//���û��������session����
				model.setViewName("redirect:view/user.jsp");
				return model;
			}else{
				//�����û���Ϣ���������û�ID������û���¼��־���ID
				Usersinfo userInfo = adminService.queryUserLogin(name);
				Map<String,Object> logMap = new HashMap<String, Object>();//��ŵ�¼��־������
				
				logMap.put("id", userInfo.getId());
				logMap.put("name", name);
				logMap.put("type", userInfo.getType());
				logMap.put("logindate", new Date());
				try {
					logMap.put("loginip", InetAddress.getLocalHost().getHostAddress());
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				logMap.put("loginresult", "ʧ��");
				adminService.insertUserLoginAction(logMap);
				model.setViewName("redirect:index.jsp");
				model.addObject("reg", "error");
				return model;
			}
			
		}
		return model;
	}

}

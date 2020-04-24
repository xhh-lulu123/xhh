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
	 * ��Ʒ�б�
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
	 * ������Ʒ������������������������
	 * @param model
	 * @return
	 */
	@RequestMapping("insertOrder")
	public ModelAndView insertOrder(ModelAndView model){ 
		Map<String,Object> map = new HashMap<>();
		
		//ͨ����Ʒ��Ϣ���ȡ��Ʒ��ID
		String id = request.getParameter("id");
		
		//ͨ��ID��ѯ����Ʒ��Ϣ
		GoodsManage good = service.findGoodById(id);
		//����Ʒ��Ϣ���뵽�����Ķ�����
		//��ѯ���ж������������������
		List<Order> orderList = service.findOrder();
		String code = "code2222".concat(String.valueOf(orderList.size()+1));
		String name = good.getName();
		double price = good.getPrice();
		double discount = good.getDiscount();
		String state = "����";
		String paytype = request.getParameter("paytype");
		Date createdate = new Date();//��������ʱ��
		//��ȡsession�������ɴ˶����Ĵ�����
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");
		String createperson = user.getName();
		//��������
		map.put("code", code);
		map.put("name", name);
		map.put("price", price);
		map.put("discount", discount);
		map.put("state", state);
		map.put("paytype", paytype);
		map.put("createperson", createperson);
		map.put("createdate", createdate);
		int res = service.insertOrder(map);
		Map<String,Object> infoMap = new HashMap<>();//�����������map
		//�����������
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		//������Ʒ����������ͨ��������ţ����ɶ���ID��ͨ���������code���Ҹö���ID����������������orderid
		Order order = service.findOrderByCode(code);
		if(res==1){
			//���ɶ����ɹ���������������
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
		model.addObject("goodsList", goodsList);	
		model.setViewName("/view/goodsList");
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
		model.addObject("orderList", orderList);	
		model.setViewName("/view/orderList");
		return model;
	}
	/**
	 * ��ʾ���������б�
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
	 * �ύ����
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
	 * ɾ������
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
		model.addObject("orderList", orderList);	
		model.setViewName("/view/orderList");
		return model;
	}
	/**
	 * ���������ύ����
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
		Usersinfo user = (Usersinfo) session.getAttribute("user");//��ȡ��ǰ��¼�û�����
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
		if(res==1){//�������ɹ���������ݱ��浽�����������
			model.setViewName("redirect:findApproval.action");
			return model;
			
		}else{
			model.addObject("error", "error");
			model.setViewName("/view/addApproval");
			return model;
		}	
	}
	/**
	 * ��ѯ�û�����
	 */
	@RequestMapping("findUserManage")
	public ModelAndView findUserType(ModelAndView model){ 
		List<Usersinfo> usersList = service.findUsersManage();
		model.addObject("usersList", usersList);
		model.setViewName("/view/addApproval");
		return model;
	}
	/**
	 * ��ѯ����
	 */
	@RequestMapping("findApproval")
	public ModelAndView findApproval(ModelAndView model){ 
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");//��ȡ��ǰ��¼�û�����
		String currentPerson = user.getName();
		String rolename = user.getRolename();
		System.out.println(currentPerson+"************");
		System.out.println(rolename+"*************");
		
		if(rolename!="����"&&rolename!="admin"){//��ͨ�û���ѯ����
			Map<String,Object> savedMap = new HashMap<>();
			savedMap.put("applyPerson", currentPerson);
			savedMap.put("approvalPerson", null);
			savedMap.put("state", "����");
			List<ApprovalManage> savedList = service.findApproval(savedMap);//��ѯ״̬Ϊ���������
			int savedNum = savedList.size();
			Map<String,Object> approvalMap = new HashMap<>();
			approvalMap.put("applyPerson", currentPerson);
			approvalMap.put("approvalPerson", null);
			approvalMap.put("state", "���ύ");
			List<ApprovalManage> approvalList = service.findApproval(approvalMap);//��ѯ״̬Ϊ�ύ������
			int approvalNum = approvalList.size();
			Map<String,Object> pastMap = new HashMap<>();
			pastMap.put("applyPerson", currentPerson);
			pastMap.put("approvalPerson", null);
			pastMap.put("state", "������");
			model.addObject("savedNum", savedNum);
			model.addObject("approvalNum", approvalNum);
		}if(rolename.equals("����")){//��ɫΪ����Ĳ�ѯ����
			Map<String,Object> approvalMap = new HashMap<>();
			approvalMap.put("approvalPerson", currentPerson);
			approvalMap.put("applyperson", null);
			approvalMap.put("state", "���ύ");
			List<ApprovalManage> approvalList = service.findApproval(approvalMap);//��ѯ״̬Ϊ�ύ������
			int approvalNum = approvalList.size();
			Map<String,Object> pastMap = new HashMap<>();
			pastMap.put("approvalPerson", currentPerson);
			pastMap.put("applyperson", null);
			pastMap.put("state", "������");	
			model.addObject("approvalNum", approvalNum);
		}
		model.setViewName("/view/officeOA");	
		return model;
	}
	/**
	 * ͨ��״̬��ѯ����
	 */
	@RequestMapping("findApprovalManage")
	public ModelAndView findApprovalManage(ModelAndView model){ 
		String state = request.getParameter("state");
		if(state.equals("baocun")){
			state = "����";
		}else if(state.equals("tijiao")){
			state = "���ύ";
		}else if(state.equals("shenpi")){
			state = "������";
		}
		Map<String,Object> map = new HashMap<>();
		map.put("state", state);
		List<ApprovalManage> approvalManageList = service.findApproval(map);//��ѯ״̬Ϊ���������
		model.addObject("approvalManageList", approvalManageList);
		model.setViewName("/view/approvalManageList");
		return model;
	}
	/**
	 *�ύ���������루��������״̬��
	 */
	@RequestMapping("updateApprovalState")
	public ModelAndView updateApprovalState(ModelAndView model){ 
		String state = request.getParameter("state");
		String id = request.getParameter("id");
		if(state.equals("tijiao")){
			state = "���ύ";
		}else if(state.equals("shenpi")){
			state = "������";
		}
		Map<String,Object> map = new HashMap<>();
		map.put("state", state);
		map.put("id", id);
		int res = service.updateApprovalManage(map);
		if(res==1){
			model.setViewName("redirect:findApproval.action");
			if(state.equals("������")){
				String result = request.getParameter("result");
				if(result.equals("pizhun")){
					result = "��׼";
				}else if(result.equals("bohui")){
					result = "����";
				}
				System.out.println(result+"*********************");
				ApprovalManage approval = service.findApprovalById(id);//���Ҵ˴���������������
				Map<String,Object> overMap = new HashMap<>();//����������
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
				overMap.put("state", "������");
				overMap.put("reason", reason);
				service.insertApprovalResult(overMap);//�����������������
				
			}
			return model;
		}
		
		return model;
	}
	/**
	 *��ѯ�������
	 */
	@RequestMapping("findApprovalResult")
	public ModelAndView findApprovalResult(ModelAndView model){ 
		HttpSession session = request.getSession(false);
		Usersinfo user = (Usersinfo) session.getAttribute("user");//��ȡ��ǰ��¼�û�����
		String currentPerson = user.getName();
		String rolename = user.getRolename();
		if(rolename!="����"&&rolename!="admin"){//��ͨ�û���ѯ����
			Map<String,Object> map = new HashMap<>();
			map.put("createperson", currentPerson);
			map.put("applyperson", null);
			List<AllApproval> approvalResultList = service.findApprovalResult(map);
			model.addObject("approvalResultList", approvalResultList);
		}if(rolename.equals("����")){//��ɫΪ����Ĳ�ѯ����
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

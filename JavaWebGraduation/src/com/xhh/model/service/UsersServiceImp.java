package com.xhh.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhh.model.dao.IUsersDao;
import com.xhh.model.domain.AllApproval;
import com.xhh.model.domain.ApprovalManage;
import com.xhh.model.domain.GoodsManage;
import com.xhh.model.domain.Order;
import com.xhh.model.domain.OrderInfo;
import com.xhh.model.domain.UsersLogin;
import com.xhh.model.domain.Usersinfo;
@Service
public class UsersServiceImp implements IUsersService {
	@Autowired
	private IUsersDao userDao;

	@Override
	public UsersLogin userLogin(Map<String, Object> map) {
		
		return userDao.userLogin(map);
	}
	@Override
	public List<GoodsManage> findGoods() {
		
		return userDao.findGoods();
	}
	@Override
	public int insertOrder(Map<String, Object> map) {
		return userDao.insertOrder(map);
		
	}
	@Override
	public GoodsManage findGoodById(String id) {
		
		return userDao.findGoodById(id);
	}
	@Override
	public List<GoodsManage> findGoodsByArg(Map<String, Object> map) {
		
		return userDao.findGoodsByArg(map);
	}
	@Override
	public int insertOrderInfo(Map<String, Object> map) {
		
		return userDao.insertOrderInfo(map);
	}
	@Override
	public List<Order> findOrder() {
		
		return userDao.findOrder();
	}
	@Override
	public Order findOrderByCode(String code) {
		
		return userDao.findOrderByCode(code);
	}
	@Override
	public List<OrderInfo> findOrderInfo() {
		
		return userDao.findOrderInfo();
	}
	@Override
	public int updateOrder(String id) {
		
		return userDao.updateOrder(id);
	}
	@Override
	public int deleteOrder(String id) {
		
		return userDao.deleteOrder(id);
	}
	@Override
	public List<Order> findOrderByArg(Map<String, Object> map) {
		
		return userDao.findOrderByArg(map);
	}
	@Override
	public int addApprovalManage(Map<String, Object> map) {
		return userDao.addApprovalManage(map);
	}
	@Override
	public List<Usersinfo> findUsersManage() {
		
		return userDao.findUsersManage();
	}
	@Override
	public List<ApprovalManage> findApproval(Map<String,Object> map) {
	
		return userDao.findApproval(map);
	}
	@Override
	public int updateApprovalManage(Map<String, Object> map) {
		
		return userDao.updateApprovalManage(map);
	}
	@Override
	public int insertApprovalResult(Map<String, Object> map) {
		
		return userDao.insertApprovalResult(map);
	}
	@Override
	public ApprovalManage findApprovalById(String id) {
		
		return userDao.findApprovalById(id);
	}
	@Override
	public List<AllApproval> findApprovalResult(Map<String,Object> map) {
		
		return userDao.findApprovalResult(map);
	}


}

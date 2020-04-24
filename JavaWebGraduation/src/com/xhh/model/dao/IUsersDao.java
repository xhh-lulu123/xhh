package com.xhh.model.dao;

import java.util.List;
import java.util.Map;

import com.xhh.model.domain.AllApproval;
import com.xhh.model.domain.ApprovalManage;
import com.xhh.model.domain.GoodsManage;
import com.xhh.model.domain.Order;
import com.xhh.model.domain.OrderInfo;
import com.xhh.model.domain.UsersLogin;
import com.xhh.model.domain.Usersinfo;

public interface IUsersDao {
	public UsersLogin userLogin(Map<String,Object> map);
	public List<GoodsManage> findGoods();
	public int insertOrder(Map<String,Object> map);
	public GoodsManage findGoodById(String id);
	public List<GoodsManage> findGoodsByArg(Map<String,Object> map);
	public int insertOrderInfo(Map<String,Object> map);
	public List<Order> findOrder();
	public Order findOrderByCode(String code);
	public List<OrderInfo> findOrderInfo();
	public int updateOrder(String id);
	public int deleteOrder(String id);
	public List<Order> findOrderByArg(Map<String,Object> map);
	public int addApprovalManage(Map<String,Object> map);
	public List<Usersinfo> findUsersManage();
	public List<ApprovalManage> findApproval(Map<String,Object> map);
	public int updateApprovalManage(Map<String,Object> map);
	public int insertApprovalResult(Map<String,Object> map);
	public ApprovalManage findApprovalById(String id);
	public List<AllApproval> findApprovalResult(Map<String,Object> map);
}

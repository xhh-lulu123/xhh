package com.xhh.model.dao;

import java.util.List;
import java.util.Map;

import com.xhh.model.domain.Admin;
import com.xhh.model.domain.ApprovalManage;
import com.xhh.model.domain.GoodsManage;
import com.xhh.model.domain.Order;
import com.xhh.model.domain.Power;
import com.xhh.model.domain.RolePower;
import com.xhh.model.domain.RolesManage;
import com.xhh.model.domain.UsersLoginAction;
import com.xhh.model.domain.Usersinfo;
import com.xhh.model.domain.Userslog;

public interface IAdminManageDao {
	public Admin queryAdmin(Map<String,Object> map);
	public int addUserLogin(Map<String,Object> map);
	public Usersinfo queryUserLogin(String name);
	public int addUserLoginInfo(Map<String,Object> map);	
	public int addGoods(Map<String,Object> map);
	public List<Usersinfo> findUsers();
	//public int addRoleID(String id);
	public int updateUserInfo(Map<String,Object> map);
	public List<Usersinfo> findUsersByName(Map<String,Object> map);
	public void deleteUser(String id);
	public void deleteUserLogin(String id);
	public void updateUserRoleName(Map<String,Object> map);
	public List<UsersLoginAction> findUsersLoginInfo(Map<String,Object> map);
	public List<Userslog> findUsersLog(Map<String,Object> map);
	public List<Order> findOrder();
	public int updateOrder(String id);
	public int deleteOrder(String id);
	public List<Order> findOrderByArg(Map<String,Object> map);
	public int insertUserLoginAction(Map<String,Object> map);
	public int insertUserLog(Map<String,Object> map);
	public void updateUserDateIP(Map<String,Object> map);
	public List<GoodsManage> findGoods();
	public GoodsManage findGoodById(String id);
	public List<GoodsManage> findGoodsByArg(Map<String,Object> map);
	public int updateGood(Map<String,Object> map);
	public int deleteGood(String id);
	public List<Usersinfo> findAdmin();
	public List<RolesManage> findroles();
	public RolesManage findRoleById(String id);
	public int addRole(Map<String,Object> map);
	public int deleteRole(String id);
	public int updateRole(Map<String,Object> map);
	public List<Power> findpower();
	public int addPower(Map<String,Object> map);
	public int deletePower(String id);
	public List<RolePower> findRolePower();
	public int addRolePower(String name);
	public int updateRolePowerByName(Map<String,Object> map);
	public int updatePower(Map<String,Object> map);
	public int deleteRolePower(String name);
	public List<ApprovalManage> findApprovalManage(Map<String,Object> map);
}


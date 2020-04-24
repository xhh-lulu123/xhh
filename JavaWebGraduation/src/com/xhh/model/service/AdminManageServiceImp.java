package com.xhh.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhh.model.dao.IAdminManageDao;
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

@Service
public class AdminManageServiceImp implements IAdminManageService {
	@Autowired
	private IAdminManageDao adminManageDao;
	@Override
	public Admin queryAdmin(Map<String, Object> map) {		
		return adminManageDao.queryAdmin(map);
	}
	@Override
	public int addUserLogin(Map<String,Object> map) {
		
		return adminManageDao.addUserLogin(map);
	}
	@Override
	public Usersinfo queryUserLogin(String name) {
		
		return adminManageDao.queryUserLogin(name);
	}
	@Override
	public int addUserLoginInfo(Map<String, Object> map) {
		
		return adminManageDao.addUserLoginInfo(map);
	}
	@Override
	public int addGoods(Map<String, Object> map) {
		
		return adminManageDao.addGoods(map);
	}
	public List<Usersinfo> findUsers(){
		return adminManageDao.findUsers();
	}
//	public int addRoleID(String id){
//		return adminManageDao.addRoleID(id);
//	}
	public int updateUserInfo(Map<String,Object> map){
		return adminManageDao.updateUserInfo(map);
	}
	@Override
	public List<Usersinfo> findUsersByName(Map<String,Object> map) {
		
		return adminManageDao.findUsersByName(map);
	}
	@Override
	public void deleteUser(String id) {
		adminManageDao.deleteUser(id);
	}
	public void deleteUserLogin(String id){
		adminManageDao.deleteUserLogin(id);
	}
	@Override
	public void updateUserRoleName(Map<String,Object> map) {
		adminManageDao.updateUserRoleName(map);
		
	}
	@Override
	public List<UsersLoginAction> findUsersLoginInfo(Map<String, Object> map) {
		return adminManageDao.findUsersLoginInfo(map);
		
	}
	public List<Userslog> findUsersLog(Map<String,Object> map){
		return adminManageDao.findUsersLog(map);
	}
	@Override
	public List<Order> findOrder() {
		
		return adminManageDao.findOrder();
	}
	@Override
	public int updateOrder(String id) {
		
		return adminManageDao.updateOrder(id);
	}
	@Override
	public int deleteOrder(String id) {
		
		return adminManageDao.deleteOrder(id);
	}
	@Override
	public List<Order> findOrderByArg(Map<String, Object> map) {
		
		return adminManageDao.findOrderByArg(map);
	}
	@Override
	public int insertUserLoginAction(Map<String, Object> map) {
		
		return adminManageDao.insertUserLoginAction(map);
	}
	@Override
	public int insertUserLog(Map<String, Object> map) {
		
		return adminManageDao.insertUserLog(map);
	}
	@Override
	public void updateUserDateIP(Map<String, Object> map) {
		adminManageDao.updateUserDateIP(map);
		
	}
	@Override
	public List<GoodsManage> findGoods() {
		
		return adminManageDao.findGoods();
	}
	@Override
	public GoodsManage findGoodById(String id) {
		
		return adminManageDao.findGoodById(id);
	}
	@Override
	public List<GoodsManage> findGoodsByArg(Map<String, Object> map) {
		
		return adminManageDao.findGoodsByArg(map);
	}
	@Override
	public int updateGood(Map<String, Object> map) {
		
		return adminManageDao.updateGood(map);
	}
	@Override
	public int deleteGood(String id) {
		
		return adminManageDao.deleteGood(id);
	}
	@Override
	public List<Usersinfo> findAdmin() {
		
		return adminManageDao.findAdmin();
	}
	@Override
	public List<RolesManage> findroles() {
		
		return adminManageDao.findroles();
	}
	@Override
	public int addRole(Map<String, Object> map) {
		
		return adminManageDao.addRole(map);
	}
	@Override
	public int deleteRole(String id) {
	
		return adminManageDao.deleteRole(id);
	}
	@Override
	public List<Power> findpower() {
		
		return adminManageDao.findpower();
	}
	@Override
	public int addPower(Map<String, Object> map) {
		
		return adminManageDao.addPower(map);
	}
	@Override
	public int deletePower(String id) {
		
		return adminManageDao.deletePower(id);
	}
	@Override
	public int updateRole(Map<String, Object> map) {
		
		return adminManageDao.updateRole(map);
	}
	@Override
	public RolesManage findRoleById(String id) {
		
		return adminManageDao.findRoleById(id);
	}
	@Override
	public List<RolePower> findRolePower() {
		return adminManageDao.findRolePower();
	}
	@Override
	public int addRolePower(String name) {
		return adminManageDao.addRolePower(name);
	}
	@Override
	public int updateRolePowerByName(Map<String, Object> map) {
		
		return adminManageDao.updateRolePowerByName(map);
	}
	@Override
	public int updatePower(Map<String, Object> map) {

		return adminManageDao.updatePower(map);
	}
	@Override
	public int deleteRolePower(String name) {
		return adminManageDao.deleteRolePower(name);
	}
	@Override
	public List<ApprovalManage> findApprovalManage(Map<String,Object> map) {
		
		return adminManageDao.findApprovalManage(map);
	}
	

}

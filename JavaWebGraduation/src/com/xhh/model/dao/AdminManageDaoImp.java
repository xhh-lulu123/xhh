package com.xhh.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

@Repository
public class AdminManageDaoImp implements IAdminManageDao {
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;
	/**
	 * 管理员登录
	 */
	@Override
	public Admin queryAdmin(Map<String, Object> map) {
		Admin admin = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			admin = session.selectOne("admin.queryAdmin", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	/**
	 * 管理员添加用户
	 */
	public int addUserLogin(Map<String,Object> map) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("admin.addUser", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	/**
	 * 查找会员登录的信息
	 */
	public Usersinfo queryUserLogin(String name) {
		Usersinfo user = new Usersinfo();
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			user = session.selectOne("admin.queryUser", name);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return user;
	}
	/**
	 * 添加用户详细信息
	 */
	@Override
	public int addUserLoginInfo(Map<String, Object> map) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("admin.addUserInfo", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 添加商品信息
	 */
	@Override
	public int addGoods(Map<String, Object> map) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("admin.addGoods", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 查询用户信息
	 */
	@Override
	public List<Usersinfo> findUsers() {
		List<Usersinfo> usersList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			usersList = session.selectList("admin.findUsers");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	/**
	 * 添加用户后，在角色管理表中创建用户
	 */
//	public int addRoleID(String id){
//		int res= 0;
//		try {
//			SqlSession session = sqlSessionFactory.getObject().openSession();
//			res = session.insert("admin.addRoleID", id);
//			session.commit();
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
	/**
	 * 更新用户信息
	 */
	public int updateUserInfo(Map<String,Object> map){
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.update("admin.updateUserInfo", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 按照名称查找用户
	 */
	@Override
	public List<Usersinfo> findUsersByName(Map<String,Object> map) {
		List<Usersinfo> usersList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			usersList = session.selectList("admin.findUsersByArg",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
		
	}
	/**
	 * 删除用户信息
	 */
	@Override
	public void deleteUser(String id) {
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
//			session.delete("admin.deleteRole", id);//先删除关联的外键
			session.delete("admin.deleteLogin", id);
			session.delete("admin.deleteUser", id);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * 删除用户登录
	 */
	@Override
	public void deleteUserLogin(String id) {
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();			
			session.delete("admin.deleteLogin", id);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 设置角色名称，分配角色
	 */
	@Override
	public void updateUserRoleName(Map<String,Object> map) {
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			session.update("admin.updateUserRoleName", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	/**
	 * 查找用户登录日志
	 */
	@Override
	public List<UsersLoginAction> findUsersLoginInfo(Map<String, Object> map) {
		List<UsersLoginAction> usersList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			usersList = session.selectList("admin.findUserslogin",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
		
	}
	/**
	 * 查找用户操作日志
	 */
	@Override
	public List<Userslog> findUsersLog(Map<String, Object> map) {
		List<Userslog> usersList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			usersList = session.selectList("admin.findUserslog",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	/**
	 * 订单列表
	 */
	@Override
	public List<Order> findOrder() {
		List<Order> orderList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			orderList = session.selectList("admin.findOrder");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	/**
	 * 审批订单
	 */
	@Override
	public int updateOrder(String id) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("admin.updateOrder",id);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
		
	}
	/**
	 * 删除订单
	 */
	@Override
	public int deleteOrder(String id) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.delete("admin.deleteOrder",id);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 条件查询订单
	 */
	@Override
	public List<Order> findOrderByArg(Map<String, Object> map) {
		List<Order> orderList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			orderList = session.selectList("admin.findOrderByArg",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	/**
	 * 记录用户登录信息
	 */
	@Override
	public int insertUserLoginAction(Map<String, Object> map) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res= session.insert("admin.insertUserLoginAction", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 记录用户操作信息
	 */
	@Override
	public int insertUserLog(Map<String, Object> map) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res= session.insert("admin.insertUserLog", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 更新用户登录时间和ip
	 */
	@Override
	public void updateUserDateIP(Map<String, Object> map) {
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			session.update("admin.updateUserDateIP", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 查询商品列表
	 */
	@Override
	public List<GoodsManage> findGoods() {
		List<GoodsManage> goodsList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			goodsList = session.selectList("admin.findGoods");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	
	/**
	 * 按照ID查找商品信息
	 */
	@Override
	public GoodsManage findGoodById(String id) {
		GoodsManage good = new GoodsManage();
		 
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			good = session.selectOne("admin.findGoodById",id);
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return good;
	}
	/**
	 * 通过名称/折扣/描述/种类查询商品
	 */
	@Override
	public List<GoodsManage> findGoodsByArg(Map<String, Object> map) {
		List<GoodsManage> goodsList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			goodsList = session.selectList("admin.findGoodsByArg",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	/**
	 * 修改商品信息
	 */
	@Override
	public int updateGood(Map<String, Object> map) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res= session.insert("admin.updateGood", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 删除商品
	 */
	@Override
	public int deleteGood(String id) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res= session.insert("admin.deleteGood", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 系统管理，查找管理员
	 */
	@Override
	public List<Usersinfo> findAdmin() {
		List<Usersinfo> usersList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			usersList = session.selectList("admin.findAdmin");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	/**
	 * 系统管理，角色管理列表
	 */
	@Override
	public List<RolesManage> findroles() {
		List<RolesManage> rolesList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			rolesList = session.selectList("admin.findRoles");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rolesList;
	}
	/**
	 * 添加角色
	 */
	@Override
	public int addRole(Map<String, Object> map) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("admin.addRole", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 删除角色
	 */
	@Override
	public int deleteRole(String id) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.delete("admin.deleteRole", id);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 查询权限
	 */
	@Override
	public List<Power> findpower() {
		List<Power> powerList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			powerList = session.selectList("admin.findPower");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return powerList;
	}
	/**
	 * 增加权限
	 */
	@Override
	public int addPower(Map<String, Object> map) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("admin.addPower", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 删除权限
	 */
	@Override
	public int deletePower(String id) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.delete("admin.deletePower", id);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 更新角色信息
	 */
	@Override
	public int updateRole(Map<String, Object> map) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.delete("admin.updateRole", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 按照ID查找角色信息
	 */
	@Override
	public RolesManage findRoleById(String id) {
		RolesManage role = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			role = session.selectOne("admin.findRoleById", id);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
	/**
	 * 权限管理页面
	 */
	@Override
	public List<RolePower> findRolePower() {
		List<RolePower> RolePowerList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			RolePowerList = session.selectList("admin.findRolePower");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RolePowerList;
	}
	/**
	 * 按照姓名添加权限管理
	 */
	@Override
	public int addRolePower(String name) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("admin.addRolePower",name);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public int updateRolePowerByName(Map<String, Object> map) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.update("admin.updateRolePowerByName",map);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 修改权限
	 */
	@Override
	public int updatePower(Map<String, Object> map) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.update("admin.updatePower",map);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 按照角色名称，删除该角色权限
	 */
	@Override
	public int deleteRolePower(String name) {
		int res = 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.delete("admin.deleteRolePower", name);
			session.commit();
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 查看待审批申请
	 * @param state
	 * @return
	 */
	@Override
	public List<ApprovalManage> findApprovalManage(Map<String,Object> map) {
		List<ApprovalManage> approvalManageList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			approvalManageList = session.selectList("admin.findApprovalManage", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return approvalManageList;
	}
	
	

}

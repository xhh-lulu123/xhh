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
	 * ����Ա��¼
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
	 * ����Ա����û�
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
	 * ���һ�Ա��¼����Ϣ
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
	 * ����û���ϸ��Ϣ
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
	 * �����Ʒ��Ϣ
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
	 * ��ѯ�û���Ϣ
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
	 * ����û����ڽ�ɫ������д����û�
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
	 * �����û���Ϣ
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
	 * �������Ʋ����û�
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
	 * ɾ���û���Ϣ
	 */
	@Override
	public void deleteUser(String id) {
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
//			session.delete("admin.deleteRole", id);//��ɾ�����������
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
	 * ɾ���û���¼
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
	 * ���ý�ɫ���ƣ������ɫ
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
	 * �����û���¼��־
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
	 * �����û�������־
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
	 * �����б�
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
	 * ��������
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
	 * ɾ������
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
	 * ������ѯ����
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
	 * ��¼�û���¼��Ϣ
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
	 * ��¼�û�������Ϣ
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
	 * �����û���¼ʱ���ip
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
	 * ��ѯ��Ʒ�б�
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
	 * ����ID������Ʒ��Ϣ
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
	 * ͨ������/�ۿ�/����/�����ѯ��Ʒ
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
	 * �޸���Ʒ��Ϣ
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
	 * ɾ����Ʒ
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
	 * ϵͳ�������ҹ���Ա
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
	 * ϵͳ������ɫ�����б�
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
	 * ��ӽ�ɫ
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
	 * ɾ����ɫ
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
	 * ��ѯȨ��
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
	 * ����Ȩ��
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
	 * ɾ��Ȩ��
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
	 * ���½�ɫ��Ϣ
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
	 * ����ID���ҽ�ɫ��Ϣ
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
	 * Ȩ�޹���ҳ��
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
	 * �����������Ȩ�޹���
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
	 * �޸�Ȩ��
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
	 * ���ս�ɫ���ƣ�ɾ���ý�ɫȨ��
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
	 * �鿴����������
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

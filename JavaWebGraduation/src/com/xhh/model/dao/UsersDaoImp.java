package com.xhh.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xhh.model.domain.AllApproval;
import com.xhh.model.domain.ApprovalManage;
import com.xhh.model.domain.GoodsManage;
import com.xhh.model.domain.Order;
import com.xhh.model.domain.OrderInfo;
import com.xhh.model.domain.UsersLogin;
import com.xhh.model.domain.Usersinfo;
@Repository
public class UsersDaoImp implements IUsersDao {
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;
	/**
	 * �û���¼
	 */
	@Override
	public UsersLogin userLogin(Map<String,Object> map) {
		UsersLogin user = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			user = session.selectOne("users.queryUser", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * ��ѯ��Ʒ����
	 */
	@Override
	public List<GoodsManage> findGoods() {
		List<GoodsManage> goodsList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			goodsList = session.selectList("users.findGoods");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	/**
	 * ��������
	 */
	@Override
	public int insertOrder(Map<String, Object> map) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("users.insertOrder",map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * ����ID������Ʒ��Ϣ
	 */
	@Override
	public GoodsManage findGoodById(String id) {
		GoodsManage good = new GoodsManage();
		 
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			good = session.selectOne("users.findGoodById",id);
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
			goodsList = session.selectList("users.findGoodsByArg",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	/**
	 * ������Ʒ�ǲ��봴����������
	 */
	@Override
	public int insertOrderInfo(Map<String, Object> map) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("users.insertOrderInfo",map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * ��ѯ�����б�
	 */
	@Override
	public List<Order> findOrder() {
		List<Order> orderList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			orderList = session.selectList("users.findOrder");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	/**
	 * ͨ���������code��ѯ����
	 */
	@Override
	public Order findOrderByCode(String code) {
		Order order = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			order = session.selectOne("users.findOrderByCode",code);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	/**
	 *��ѯ���������б�
	 */
	@Override
	public List<OrderInfo> findOrderInfo() {
		List<OrderInfo> orderInfoList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			orderInfoList = session.selectList("users.findOrderInfo");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoList;
	}
	/**
	 * �ύ����
	 */
	@Override
	public int updateOrder(String id) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("users.updateOrder",id);
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
			res = session.delete("users.deleteOrder",id);
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
			orderList = session.selectList("users.findOrderByArg",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	/**
	 * �ύ���������ݲ������������
	 */
	@Override
	public int addApprovalManage(Map<String, Object> map) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.delete("users.addApprovalManage",map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * ��ѯ��ɫΪ������û��б�
	 */
	@Override
	public List<Usersinfo> findUsersManage() {
		List<Usersinfo> userList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			userList = session.selectList("users.findUsersManage");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	/**
	 * ��ѯ�����˵�
	 */
	@Override
	public List<ApprovalManage> findApproval(Map<String,Object> map) {
		List<ApprovalManage> approvalList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			approvalList = session.selectList("users.findApproval",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return approvalList;
	}
	/**
	 *�ύ/��������˵�
	 */
	@Override
	public int updateApprovalManage(Map<String, Object> map) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.update("users.updateApprovalState", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * �����������
	 */
	@Override
	public int insertApprovalResult(Map<String, Object> map) {
		int res= 0;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			res = session.insert("users.insertApprovalResult", map);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * ����ID��������
	 */
	@Override
	public ApprovalManage findApprovalById(String id) {
		ApprovalManage approval = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			approval = session.selectOne("users.findApprovalById", id);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return approval;
	}
	/**
	 * ��ѯ�������
	 */
	@Override
	public List<AllApproval> findApprovalResult(Map<String,Object> map) {
		List<AllApproval> allApprovalList = null;
		try {
			SqlSession session = sqlSessionFactory.getObject().openSession();
			allApprovalList = session.selectList("users.findApprovalResult",map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allApprovalList;
	}
	

}

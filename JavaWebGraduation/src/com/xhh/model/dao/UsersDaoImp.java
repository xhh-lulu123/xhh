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
	 * 用户登录
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
	 * 查询商品购买
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
	 * 创建订单
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
	 * 按照ID查找商品信息
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
	 * 通过名称/折扣/描述/种类查询商品
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
	 * 购买商品是插入创建订单详情
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
	 * 查询订单列表
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
	 * 通过订单编号code查询订单
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
	 *查询订单详情列表
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
	 * 提交订单
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
	 * 删除订单
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
	 * 条件查询订单
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
	 * 提交审批后数据插入审批管理表
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
	 * 查询角色为经理的用户列表
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
	 * 查询审批菜单
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
	 *提交/审批申请菜单
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
	 * 插入审批结果
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
	 * 按照ID查找申请
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
	 * 查询审批结果
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

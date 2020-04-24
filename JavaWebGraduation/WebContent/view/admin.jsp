<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addUser(){  
	   window.open ('adduser.jsp'); 
	}
	function addUserInfo(){  
		   window.open ('adduserInfo.jsp'); 
		}
</script>
</head>
<body>
<h1>管理员:${sessionScope.user.name}</h1>

	
	<a href="adduser.jsp">添加用户</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="adduserInfo.jsp">添加用户详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="addGoods.jsp">添加商品</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../adminManage/findUsers.action">用户列表</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../adminManage/findUsersLoginInfo.action">用户登录日志管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../adminManage/findUsersLog.action">用户操作日志管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="orderManage.jsp">订单管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../adminManage/findGoods.action">商品管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="system.jsp">系统管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="officeOA.jsp">办公OA</a>&nbsp;&nbsp;&nbsp;&nbsp;
</body>
</html>
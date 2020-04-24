<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/admin.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
	<br>
	<a href="../adminManage/findAdmin.action">管理员列表</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../adminManage/findRoles.action">角色列表</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../adminManage/findPower.action">权限分类</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../adminManage/findRolePower.action">权限管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	
	<form action="" method="post">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name ="name"> <input type="submit" value="角色查询（未实现）">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name ="relevance"> <input type="submit" value="权限查询（未实现）">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name ="createperson"> <input type="submit" value="创建人查询（未实现）">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name ="datestart" size="10">-
	<input type="text" name ="dateend" size="10"> <input type="submit" value="时间查询（未实现）">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</form>
	<br>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="../view/addRole.jsp">添加角色</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<br>
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>角色ID</td>
			<td>角色名称</td>
			<td>角色描述</td>
			<td>拥有权限</td>
			<td>创建时间</td>
			<td>创建人</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.rolesList}" var="role" varStatus="sta">
		<tr style="background-color: pink">
			<td>${role.id}</td>
			<td>${role.name}</td>
			<td>${role.roledesc}</td>
			<td>${role.rolePower.name}</td>
			<td><fmt:formatDate value="${role.createdate}" pattern="yyyy-MM-dd"/></td>
			<td>${role.createperson}</td>	
			<td>
				<a href="../view/updateRole.jsp?id=${role.id}">修改</a>
				<a href="deleteRole.action?id=${role.id}">删除</a>
			</td>
		</tr>
		</c:forEach>	
	</table>
	<c:if test="${param.reg ne null and param.reg eq 'error' }">
		<p style="color:red" align="center">删除失败，角色在使用<p/>
	</c:if>
	
</body>
</html>
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
<h1 align="center">登录操作信息</h1>
	<hr>
	<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/admin.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	
	</div>
	
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>用户名</td>
			<td>操作类型</td>
			<td>操作结果</td>
			<td>操作信息</td>
			<td>操作时间</td>
			<td>操作模块</td>	
		</tr>
		<c:forEach items="${requestScope.usersList}" var="user" varStatus="sta">
		<tr style="background-color: pink">
			<td>${user.name}</td>
			<td>${user.type}</td>
			<td>${user.result}</td>
			<td>${user.doinfo}</td>
			<td><fmt:formatDate value="${user.dodate}" pattern="yyyy-MM-dd"/></td>
			<td>${user.domod}</td>		
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>
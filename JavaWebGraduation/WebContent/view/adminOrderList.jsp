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
<h1 align="center">订单管理</h1>
<hr>
	<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/admin.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	
	</div>

	<form action="../users/findOrderByArg.action" method="post">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name ="code"> <input type="submit" value="编号查询">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name ="createperson"> <input type="submit" value="下单人查询">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name ="name"> <input type="submit" value="商品名称">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name ="pricestart" size="5">-
	<input type="text" name ="priceend" size="5"> <input type="submit" value="价格查询">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</form>
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>订单ID</td>
			<td>订单编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品折扣</td>
			<td>创建人</td>
			<td>创建时间</td>
			<td>订单状态</td>
			<td>支付方式</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.orderList}" var="order" varStatus="sta">
		<tr style="background-color: pink">
			<td>${order.id}</td>
			<td>${order.code}</td>
			<td>${order.name}</td>
			<td>${order.price}</td>
			<td>${order.discount}</td>
			<td>${order.createperson}</td>
			<td><fmt:formatDate value="${order.createdate}" pattern="yyyy-MM-dd"/></td>
			<td>${order.state}</td>
			<td>${order.paytype}</td>	
			<td>
				<a href="updateOrder.action?id=${order.id}">审批</a>
				<a href="deleteOrder.action?id=${order.id}">删除</a>
			
			</td>
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>
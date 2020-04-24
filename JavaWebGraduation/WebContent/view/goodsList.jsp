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
<h1>用户:${sessionScope.user.name}</h1>
<a href="../view/user.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<form action="findGoodsByArg.action" method="post">
	<input type="text" name ="name"> <input type="submit" value="名称查询">
	<input type="text" name ="discount"> <input type="submit" value="折扣查询">
	<input type="text" name ="type"> <input type="submit" value="种类查询">
	<input type="text" name ="descs"> <input type="submit" value="描述查询">
	</form>
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>ID</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品折扣</td>
			<td>商品类型</td>
			<td>描述</td>
			<td>有效期</td>
			<td>状态</td>
			<td>操作</td>
		
		</tr>
		<c:forEach items="${requestScope.goodsList}" var="good" varStatus="sta">
		<tr style="background-color: pink">
			<td>${good.id}</td>
			<td>${good.name}</td>
			<td>${good.price}</td>
			<td>${good.discount}</td>
			<td>${good.type}</td>
			<td>${good.descs}</td>
			<td><fmt:formatDate value="${good.expirydate}" pattern="yyyy-MM-dd"/></td>
			<td>${good.state}</td>		
			<td>
				<a href="../view/buyGood.jsp?name=${good.name}&id=${good.id}">购买</a>
			</td>		
		</tr>
		</c:forEach>
		
	</table>


</body>
</html>
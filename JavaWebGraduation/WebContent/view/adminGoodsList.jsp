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
	<form action="../adminManage/findGoodsByArg.action" method="post">
	<input type="text" name ="name"> <input type="submit" value="名称查询">
	<input type="text" name ="discount"> <input type="submit" value="折扣查询">
	<input type="text" name ="type"> <input type="submit" value="种类查询">
	<input type="text" name ="descs"> <input type="submit" value="描述查询">
	</form>
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>商品ID</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品折扣</td>
			<td>商品类型</td>
			<td>描述</td>
			<td>有效期</td>
			<td>状态</td>
			<td>创建人</td>
			<td>创建日期</td>
			<td>修改人</td>
			<td>修改日期</td>
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
			<td>${good.createperson}</td>
			<td><fmt:formatDate value="${good.createdate}" pattern="yyyy-MM-dd"/></td>
			<td>${good.modifyperson}</td>
			<td>${good.modifydate}</td>
			
			<td>
				<a href="../adminManage/queryGoodById.action?&id=${good.id}">修改信息</a>
				<a href="../view/deleteGood.jsp?name=${good.name}&id=${good.id}">删除</a>
			</td>		
		</tr>
		</c:forEach>
		
	</table>


</body>
</html>
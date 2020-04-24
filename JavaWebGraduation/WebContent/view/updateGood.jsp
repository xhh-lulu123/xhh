<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3 align="center" >修改商品信息</h3>
		${requestScope.good.name}
	<hr/>
	<form action="../adminManage/updateGood.action?id=${requestScope.good.id}" method="post" >
		<table width="600px" height = "400px" align="center">
			<tr>
				<td align="right">商品名称：</td>
				<td align="left">${requestScope.good.name}</td>
			</tr>
			<tr>
				<td align="right">商品价格：</td>
				<td align="left"><input  name="price" value = "${requestScope.good.price}"></td>
			</tr>
			<tr>
				<td align="right">商品折扣：</td>
				<td align="left"><input name="discount" value = "${requestScope.good.discount}"></td>
			</tr>
			<tr>
				<td align="right">商品类型：</td>
				<td align="left"><input name="type" value = "${requestScope.good.type}"></td>
			</tr>
			<tr>
				<td align="right">商品描述：</td>
				<td align="left"><input name="descs" value = "${requestScope.good.descs}"></td>
			</tr>
			<tr>
				<td align="right">商品状态：</td>
				<td align="left"><input name="state" value = "${requestScope.good.state}"></td>
			</tr>
			<tr>
				<td align="right">商品有效期：</td>
				<td align="left"><input name="expirydate" 
				value = "<fmt:formatDate value="${good.expirydate}" pattern="yyyy-MM-dd"/>"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				    <input type="submit" value="确定">
				</td>
			</tr>		
		</table>
	</form>
	
	<c:if test="${param.reg ne null and param.reg eq 'error' }">
	
		<p style="color:red" align="center">更改失败<p/>
	</c:if>
	

</body>
</html>
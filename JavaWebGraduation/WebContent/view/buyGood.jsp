<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
	<h1 align="center">购买商品</h1>
	<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/user.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
${param.name}
	<hr/>
	<form action="../users/insertOrder.action?id=${param.id}&goodname=${param.name}" method="post">
		<table width="400px" height = "400px" align="center">
			<tr>
				<td align="right">商品名称：</td>
				<td align="left">${param.name}</td>
			</tr>
			<tr>
				<td align="right">收获地址：</td>
				<td align="left"><input type="text" name="address"></td>
			</tr>
			<tr>
				<td align="right">联系电话：</td>
				<td align="left"><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td align="right">支付方式：</td>
				<td>
					<input type="radio" name="paytype" value="支付宝">支付宝&nbsp;&nbsp;
					<input type="radio" name="paytype" value="微信">微信&nbsp;&nbsp;
					<input type="radio" name="paytype" value="银行卡">银行卡&nbsp;&nbsp;
				</td>
			</tr>
			<tr>			
				<td align="center" colspan="2">
				    <input type="submit" value="确定">
				</td>
			</tr>		
		</table>
	</form>
	<c:if test="${param.error ne null and param.error eq 'error' }">
	
		<p style="color:red" align="center">购买失败<p/>
	</c:if>
	

</body>
</html>
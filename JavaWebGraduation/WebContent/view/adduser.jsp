<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3 align="center" >添加用户</h3>
	<hr/>
	<form action="../adminManage/addUserLogin.action" method="post" >
		<table width="600px" height = "400px" align="center">
			<tr>
				<td align="right">用户名：</td>
				<td align="left"><input type="text" name="name"  size="25" maxlength="6" placeholder="请输入姓名" ></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td align="left"><input type="password" name="password" size="25" maxlength="6" placeholder="请输入密码"></td>
			</tr>
			<tr>
				<td align="right">确认密码：</td>
				<td align="left"><input type="password" name="conpassword" size="25" maxlength="6" placeholder="确认密码"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				    <input type="submit" value="添加">
				</td>
			</tr>		
		</table>
	</form>
	
	<c:if test="${param.reg ne null and param.reg eq 'error' }">
	
		<p style="color:red" align="center">添加失败，请重新添加<p/>
	</c:if>
	

</body>
</html>
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
		<h3 align="center" >修改用户详细信息</h3>
	<hr/>
	<form action="../adminManage/updateUserInfo.action?id=${param.id}" method="post" >
		<table width="600px" height = "400px" align="center">
			<tr>
				<td align="right">用户名：</td>
				<td align="left">${param.name}</td>
			</tr>
			<tr>
				<td align="right">性别：</td>
				<td align="left"><input  name="sex" size="25"  value="${param.sex}"></td>
			</tr>
			<tr>
				<td align="right">电话：</td>
				<td align="left"><input name="phone" size="25" value="${param.phone}"></td>
			</tr>
			<tr>
				<td align="right">邮箱：</td>
				<td align="left"><input name="email" size="25" value="${param.email}"></td>
			</tr>
			<tr>
				<td align="right">qq/wx：</td>
				<td align="left"><input name="qq" size="25" value="${param.qq}"></td>
			</tr>
			<tr>
				<td align="right">用户类型：</td>
				<td align="left"><input name="type" size="25" value="${param.type}"></td>
			</tr>
			<tr>
				<td align="right">家庭住址：</td>
				<td align="left"><input name="address" size="25" value="${param.address}"></td>
			</tr>
			<tr>
				<td align="right">工作：</td>
				<td align="left"><input name="job" size="25" value="${param.job}"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				    <input type="submit" value="确定">
				</td>
			</tr>		
		</table>
	</form>
	
	<c:if test="${param.reg ne null and param.reg eq 'error' }">
	
		<p style="color:red" align="center">修改失败<p/>
	</c:if>
	

</body>
</html>
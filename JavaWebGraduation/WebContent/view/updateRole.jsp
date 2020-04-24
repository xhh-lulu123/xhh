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
		<h3 align="center" >修改角色信息</h3>
	<hr/>
	
	<form action="../adminManage/updateRole.action?id=${requestScope.id}" method="post" >
			
		<table width="600px" height = "400px" align="center">
			<tr>
				<td align="right">角色名称：</td>
				<td align="left">${requestScope.role.name}</td>
			</tr>
			
			<tr>
				<td align="right">角色描述：</td>
				<td align="left"><input  name="roledesc" value="${requestScope.role.roledesc}"></td>
			</tr>
			
			<tr>
				<td align="center" colspan="2">
				    <input type="submit" value="确定">
				</td>
			</tr>		
		</table>
	</form>
	
	<c:if test="${param.reg ne null and param.reg eq 'error' }">
	
		<p style="color:red" align="center">修改失败，请重新修改<p/>
	</c:if>
	

</body>
</html>
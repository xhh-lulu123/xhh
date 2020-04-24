<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
 <script type="text/javascript">
            function next(){
                window.location = "register.jsp";
            }
</script>
</head>
<body>
	<h1 align="center">欢迎访问本网站</h1>
	<hr/>
	<form action="login.action" method="post">
		<table width="400px" height = "400px" align="center">
			<tr>
				<td align="right">用户名：</td>
				<td align="left"><input type="text" name="name" size="25" maxlength="16" ></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td align="left"><input type="password" name="password" size="25" maxlength="6" ></td>
			</tr>
			<tr>
				<td align="right">您是：</td>
				<td align="left"><input type="radio" name="role" value = "admin" checked="checked">管理员
				<input type="radio" name="role" value = "user">会员</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				    <input type="submit" value="登录">
				</td>
			</tr>		
		</table>
	</form>
	<c:if test="${param.reg ne null and param.reg eq 'error' }">
	
		<p style="color:red" align="center">登录失败，请重新登录<p/>
	</c:if>
	<c:if test="${param.path ne null }">
	
		<p style="color:red" align="center">请登录<p/>
	</c:if>
	${requestScope.path}
	

</body>
</html>
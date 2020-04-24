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
<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/user.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
	<br>
	<form action="../users/addApproval.action" method="post" >
		<table width="600px" height = "400px" align="center">
			<tr>
				<td align="right">类型：</td>
				<td align="left">
					<select name = type>
						<option selected>--请选择--</option>
						<option value="事假">事假</option>
						<option value="病假">病假</option>
						<option value="出差">出差</option>
						<option value="接待">接待</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">审批人：</td>
				<td align="left">
					<select name = approvalPerson>
						<option selected>--请选择--</option>
						<c:forEach items="${requestScope.usersList}" var="user" varStatus="sta">
						<option value = "${user.name}">${user.name}</option>
						
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">天数：</td>
				<td align="left"><input type="text" name="days"></td>
			</tr>
			<tr>
				<td align="right">事因：</td>
				<td align="left"><input type="text" name="reason"></td>
			</tr>
			<tr>
				<td align="right" >
				    <input type="submit" name = "state" value="保存">
				</td>
				<td align="left" >
				    <input type="submit" name="state" value="提交">
				</td>
			</tr>		
		</table>
	</form>
	
	<c:if test="${param.reg ne null and param.reg eq 'error' }">
	
		<p style="color:red" align="center">添加失败，请重新添加<p/>
	</c:if>
	

</body>
</html>
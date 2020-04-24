<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function findUsersByName(){  
	   window.open ('findUsersByName.action'); 
	}

</script>
</head>
<body>
<h1 align="center">用户管理</h1>
<hr>
	<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/admin.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<c:if test="${requestScope.text eq null and param.text ne 'adminList' }">
	
	<form action="findUsersByArg.action" method="post">
	<input type="text" name ="name"> <input type="submit" value="名称查找">
	<input type="text" name ="sex"> <input type="submit" value="性别查找">
	<input type="text" name ="type"> <input type="submit" value="类型查找">
	<input type="text" name ="address"> <input type="submit" value="地址查找">
	</form>
	</c:if>
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>用户名</td>
			<td>性别</td>
			<td>电话</td>
			<td>邮箱</td>
			<td>qq/wx</td>
			<td>用户类型</td>
			<td>住址</td>
			<td>工作</td>
			<td>创建时间</td>
			<td>更新时间</td>
			<td>更新人</td>
			<td>最后一次登录时间</td>
			<td>最后一次登录IP</td>
			<td>角色</td>			
			<td>操作</td>			
		</tr>
		<c:forEach items="${requestScope.userList}" var="user" varStatus="sta">
		<tr style="background-color: pink">
			<td>${user.name}</td>
			<td>${user.sex}</td>
			<td>${user.phone}</td>
			<td>${user.email}</td>
			<td>${user.qq}</td>
			<td>${user.type}</td>
			<td>${user.address}</td>
			<td>${user.job}</td>
			<td><fmt:formatDate value="${user.createdate}" pattern="yyyy-MM-dd"/></td>
			<td><fmt:formatDate value="${user.updatedate}" pattern="yyyy-MM-dd"/></td>
			<td>${user.updateperson}</td>
			<td><fmt:formatDate value="${user.lastdate}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td>${user.lastip}</td>
			<td>${user.rolename}</td>
			<td>
			<c:if test="${user.type eq '会员'}">
			<a href="../view/updateUserInfo.jsp?id=${user.id}&name=${user.name}&email=${user.email}&address=${user.address}&phone=${user.phone}
			&job=${user.job}&type=${user.type}&qq=${user.qq}">更改</a>
			<a href="../adminManage/deleteUser.action?id=${user.id}">删除</a>
			<a href="../adminManage/deleteUserLogin.action?id=${user.id}">禁用</a>
			<form action="../adminManage/updateUserRoleName.action?id=${123}">
			<input type="hidden" name="id" value="${user.id}" >   
				<select name="name">
					<option selected>--请选择--</option>
						<option value="jingli">经理</option>
						<option value="zhuguan">主管</option>
						<option value="yuangong">员工</option>
						<option value="guwen">顾问</option>
				</select>
				<input type="submit" value="分配">
			</form>
			</c:if>
			<c:if test="${user.type eq '管理员'}">
			无权更改
			</c:if>
			</td>
			
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>
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
	function confirmd(){
		var mess = "确定要删除该数据吗？"
		if(confim(mess)==true){
			return true;
		}else{
			return false
		}
	}

</script>
</head>
<body>
<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/admin.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<br>
	<br>
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>角色名称</td>
			<td>权限名称</td>
			<td>所用权限个数</td>
			<td>分配人</td>
			<td>分配时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.rolePowerList}" var="rolePower" varStatus="sta">
		<tr style="background-color: pink">
			<td>${rolePower.name}</td>
			<td>${rolePower.power}</td>
			<td>${rolePower.quantity}</td>
			<td><fmt:formatDate value="${rolePower.managedate}" pattern="yyyy-MM-dd"/></td>
			<td>${rolePower.manageperson}</td>	
			<td>
				<form action="updateRolePowerByName.action" method="post">
					<input type="hidden" name = "name" value="${rolePower.name}">
					<select name = "power">
						<option>--选择权限--</option>
						<c:forEach items="${requestScope.powerList}" varStatus="sta" var="power">
							<option>${power.name}</option>
						</c:forEach>
					</select>
					<input type="submit" name ="fuquan" value="赋权">
				
				</form>
				<a href="adminManage/updateRolePower.action?id=${rolePower.name}">修改</a>
				<a href="deleteRolePower.action?id=${rolePower.name}" onblur="return confirmd()">删除</a>
			
			</td>
		</tr>
		</c:forEach>	
	</table>
	<c:if test="${param.reg ne null and param.reg eq 'error' }">
	
		<p style="color:red" align="center">删除失败，角色在使用<p/>
	</c:if>
	
</body>
</html>
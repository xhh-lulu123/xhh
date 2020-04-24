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
<c:if test="${sessionScope.user.type eq '管理员'}">
	<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/admin.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
</c:if>
<c:if test="${sessionScope.user.type ne '管理员'}">
	<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/user.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
</c:if>
	<br>
	
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>审批ID</td>
			<td>发起人</td>
			<td>审批人</td>
			<td>审批时间</td>
			<td>审批结果</td>
			<td>天数</td>
			<td>类型</td>
			<td>状态</td>
			<td>事因</td>
		</tr>
		<c:forEach items="${requestScope.approvalResultList}" var="approvalResult" varStatus="sta">
		<tr style="background-color: pink">
			<td>${approvalResult.id}</td>
			<td>${approvalResult.createperson}</td>
			<td>${approvalResult.applyperson}</td>
			<td><fmt:formatDate value="${approvalResult.applydate}" pattern="yyyy-MM-dd"/></td>
			<td>${approvalResult.result}</td>
			<td>${approvalResult.days}</td>
			<td>${approvalResult.type}</td>
			<td>${approvalResult.state}</td>
			<td>${approvalResult.reason}</td>	
			
		</tr>
		</c:forEach>	
	</table>
	
</body>
</html>
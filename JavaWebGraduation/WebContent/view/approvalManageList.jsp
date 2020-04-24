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
			<td>发起时间</td>
			<td>类型</td>
			<td>审批人</td>
			<td>天数</td>
			<td>状态</td>
			<td>事因</td>
			<c:if test="${sessionScope.user.type ne '管理员'}">
			<td>操作</td>
			</c:if>
		</tr>
		<c:forEach items="${requestScope.approvalManageList}" var="approvalManage" varStatus="sta">
		<tr style="background-color: pink">
			<td>${approvalManage.id}</td>
			<td>${approvalManage.applyPerson}</td>
			<td><fmt:formatDate value="${approvalManage.applyDate}" pattern="yyyy-MM-dd"/></td>
			<td>${approvalManage.type}</td>
			<td>${approvalManage.approvalPerson}</td>
			<td>${approvalManage.days}</td>
			<td>${approvalManage.state}</td>
			<td>${approvalManage.reason}</td>	
			<c:if test="${sessionScope.user.type ne '管理员'}">
			<td>
				<c:if test="${approvalManage.state eq '保存'}">
				<a href="../users/updateApprovalState.action?id=${approvalManage.id}&state=tijiao">提交</a>
				</c:if>
				<c:if test="${approvalManage.state eq '已提交'}">
				<c:if test="${sessionScope.user.rolename eq '经理'}">
				<a href="../users/updateApprovalState.action?id=${approvalManage.id}&state=shenpi&result=pizhun">批准</a>
				<a href="../users/updateApprovalState.action?id=${approvalManage.id}&state=shenpi&result=bohui">驳回</a>
				</c:if>
				<c:if test="${sessionScope.user.rolename ne '经理'}">
				待审批
				</c:if>
				</c:if>
			</td>
			</c:if>
		</tr>
		</c:forEach>	
	</table>
	
</body>
</html>
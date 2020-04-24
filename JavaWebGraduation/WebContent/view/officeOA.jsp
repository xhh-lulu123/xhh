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
	<c:if test="${sessionScope.user.type eq '管理员'}">
<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/admin.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
	<br>
	<a href="../adminManage/findApprovalManage.action">待审批</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../adminManage/findApprovalManageOver.action">已审批</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
	
	<c:if test="${sessionScope.user.rolename ne '经理' and sessionScope.user.type ne '管理员'}">
	<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/user.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
<br>
	<a href="../users/findUserManage.action">请假</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../users/findApprovalManage.action?state=baocun">已保存(${requestScope.savedNum})</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../users/findApprovalManage.action?state=tijiao">待审批(${requestScope.approvalNum})</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../users/findApprovalResult.action">已审批</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${sessionScope.user.rolename eq '经理'}">
	<div align="right">
	用户：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../view/user.jsp">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
<br>
	<a href="../users/findApprovalManage.action?state=tijiao">待审批(${requestScope.approvalNum})</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../users/findApprovalResult.action">已审批</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
</body>
</html>
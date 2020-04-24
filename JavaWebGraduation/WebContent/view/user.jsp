<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function buyGoods(){  
	   window.open ('../users/findGoods.action'); 
	}

</script>
</head>
<body>
<h1>会员：${sessionScope.user.name}</h1>
	<input type="button" value="商城" onclick="buyGoods()">
	<a href="../users/findGoods.action">商城</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../users/findOrder.action">我的订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../users/findOrderInfo.action">订单详情列表</a>&nbsp;&nbsp;&nbsp;&nbsp;
	
	<a href="../users/findApproval.action">办公OA</a>&nbsp;&nbsp;&nbsp;&nbsp;
	
	

</body>
</html>
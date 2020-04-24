<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="findOrderInfoByArg.action" method="post">
	<input type="text" name ="code"> <input type="submit" value="编号查询">
	<input type="text" name ="createperson"> <input type="submit" value="下单人查询">
	<input type="text" name ="name"> <input type="submit" value="商品名称">
	<input type="text" name ="price"> <input type="submit" value="价格查询">
	</form>
	<table style="width:80%" border="1" align="center">
		<tr style="background-color: blue;color:#ffffff">
			<td>订单详情ID</td>
			<td>订单ID</td>
			<td>订单编号</td>
			<td>商品ID</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品折扣</td>
			<td>商品类型</td>
			<td>商品描述</td>
			<td>收货地址</td>
			<td>联系电话</td>
		</tr>
		<c:forEach items="${requestScope.orderInfoList}" var="orderInfo" varStatus="sta">
		<tr style="background-color: pink">
			<td>${orderInfo.infoid}</td>
			<td>${orderInfo.orderid}</td>
			<td>${orderInfo.ordercode}</td>
			<td>${orderInfo.goodid}</td>
			<td>${orderInfo.goodname}</td>
			<td>${orderInfo.goodprice}</td>
			<td>${orderInfo.gooddiscount}</td>
			<td>${orderInfo.goodtype}</td>
			<td>${orderInfo.gooddescs}</td>
			<td>${orderInfo.address}</td>
			<td>${orderInfo.phone}</td>				
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>

<link href="<%= request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%= request.getContextPath()%>/css/cart.css" rel="stylesheet" type="text/css">


</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="<%= request.getContextPath()%>/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
	<%@ include file="menu.jsp" %>
	
</div>	<div class="container cart">
		<div class="span24">
			<div class="step step1">
				
			</div>
			
			
				<table>
					<tbody>
					<tr>
						<th>订单编号</th>
						<th>订单总价</th>
						<th>订单时间</th>
						<th>订单状态</th>
						
					</tr>
					<c:forEach var="order" items="${orderList}">
						<tr>
							<td width="60">
								<span>${order.orderId }</span>
							</td>
							<td>
								<span>${order.totalPrice }</span>
							</td>
							<td>
								<span>${order.createTime }</span>
							</td>
							
							<td class="quantity" width="60">
								<span>${order.stateDescription }</span>
							</td>
						</tr>
					</c:forEach>
				</tbody></table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
							
					
				</div>
				<div class="bottom">
					
				</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="<%= request.getContextPath()%>/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>
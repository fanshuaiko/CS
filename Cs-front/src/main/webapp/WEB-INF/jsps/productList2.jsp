<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>传智网上商城</title>
<link href="<%= request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css"/>
<link href="<%= request.getContextPath()%>/css/product.css" rel="stylesheet" type="text/css"/>

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
	
</div>	
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				 <c:forEach var="class2" items="${class2List}">
						<dl>
							<dt>
							<%-- 	<a href="<%= request.getContextPath()%>/CommodityController/pageByClass2Id?page=1&size=1&class2Id=${class2.class2Id}"></a> --%>
							</dt>
									<dd>
										<a href="<%= request.getContextPath()%>/CommodityController/pageByClass2Id?page=0&size=3&class2Id=${class2.class2Id}">${class2.class2Name}</a>
									</dd>
									
						</dl>
					</c:forEach> 
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="<%= request.getContextPath()%>/image/蔬菜 - Powered By Mango Team.htm" method="get">
				<input type="hidden" id="brandId" name="brandId" value="">
				<input type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">
					
				<div id="result" class="result table clearfix">
						<ul>
						<c:forEach var="commodity" items="${pg.content}">
						<li>
						
						
										<a href="<%= request.getContextPath()%>/CommodityController/findById?id=${commodity.commodityId}">
											<img src="<%= request.getContextPath()%>/${commodity.commodityImage}" width="170" height="170"  style="display: inline-block;">
											   
											<span style='color:green'>
											 ${commodity.commodityName}
											</span>
											 
											<span class="price">
												商城价： ￥ ${commodity.commodityPrice}
											</span>
											 
										</a>
						</li>
						</c:forEach>			
						</ul>
				</div>
	<div class="pagination">
			<span class="firstPage">&nbsp;</span>
		
			<a class="previousPage" href="<%= request.getContextPath()%>/CommodityController/pageByClass2Id?page=${pg.number-1}&size=1&class2Id=${class2Id}">&nbsp;</a>
				<!-- <span class="currentPage">1</span>
				<a href="javascript: $.pageSkip(2);">2</a> -->
			<a class="nextPage" href="<%= request.getContextPath()%>/CommodityController/pageByClass2Id?page=${pg.number+1}&size=1&class2Id=${class2Id}">&nbsp;</a>
			<a class="lastPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
	</div>
			</form>
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
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
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
						<a >官网</a>
						|
					</li>
					<li>
						<a >论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>
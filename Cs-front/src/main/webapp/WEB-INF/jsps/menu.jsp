<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
		<c:choose>
		<c:when test="${sessionScope.currentUser==null }">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="<%=request.getContextPath()%>/UserController/forwordPage?page=login">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="<%=request.getContextPath()%>/UserController/forwordPage?page=register">注册</a>|
				</li>
				</c:when>
				<c:otherwise>
				 <li id="headerLogin" class="headerLogin" style="display: list-item;">
					${sessionScope.currentUser.userName }|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="<%=request.getContextPath()%>/UserController/quit">退出</a>|
				</li>
				<li>
							<a href="<%=request.getContextPath()%>/UserController/findById">修改信息</a>
							|
				</li>
				<li>
							<a href="<%=request.getContextPath()%>/OrderController/findByUid">我的订单</a>
							|
						</li>
				</c:otherwise> 
		</c:choose>	
						
						
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="<%= request.getContextPath()%>/CartController/myCart">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="<%= request.getContextPath()%>/IndexController/index">首页</a>
						|
					</li>
			<c:forEach var="c" items="${sessionScope.list1}">
					<li>
						<a href="<%= request.getContextPath()%>/Class2Controller/findByClass1Id?class1Id=${c.class1Id}">${c.class1Name }</a>
						|
					</li>
					
				</c:forEach>	
		</ul>
	</div>

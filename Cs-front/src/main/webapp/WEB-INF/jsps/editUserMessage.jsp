<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>会员注册</title>
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/register.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="<%=request.getContextPath()%>/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
	<%@ include file="menu.jsp" %>

</div>	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>会员信息修改</strong>USER EDIT
					</div>
					<form id="registerForm"  method="post" novalidate="novalidate" action="<%=request.getContextPath()%>/UserController/update">
						
						<table>
							<tbody>
							<tr>
								<td>
									<input type="hidden" name="userId"  value="${sessionScope.currentUser.userId }" class="text" maxlength="20">
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>用户名:
								</th>
								<td>
									<input type="text" id="username" name="userName"  value="${sessionScope.currentUser.userName }" class="text" maxlength="20">
								</td>
							</tr>
							
							<tr>
								<th>
									<span class="requiredField">*</span>用户电话:
								</th>
								<td>
									<input type="text" id="email" name="userTel"  value="${sessionScope.currentUser.userTel }"  class="text" maxlength="200">
								</td>
							</tr>
									<tr>
										<th>
											地址:
										</th>
										<td>
												<input type="text" name="userAddress"  value="${sessionScope.currentUser.userAddress }" class="text" maxlength="200">
										</td>
									</tr>
							<tr>
										<th>
											
										</th>
										<td>
										<input type="submit" value="确认"">
										</td>
									</tr>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">	
</div>	</div>
</div>
<div id="_my97DP" style="position: absolute; top: -1970px; left: -1970px;"><iframe style="width: 190px; height: 191px;" src="<%=request.getContextPath()%>/会员注册 - Powered By Mango Team_files/My97DatePicker.htm" frameborder="0" border="0" scrolling="no"></iframe></div></body></html>
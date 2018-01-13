<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery-2.2.3.min.js"></script>
<nav class="navbar  navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="toIndex.do">我的论坛</a>
	</div>

	<ul class="nav navbar-nav navbar-left">
		<li class="active"><a href="toIndex.do">首 页</a></li>
	</ul>

	<ul class="nav navbar-nav navbar-right">
		<c:if test="${sessionScope.customer==null}">
			<li><a href="toLogin.do">登录</a>
			</li>
			<li><a href="toRegist.do">注册</a>
			</li>
		</c:if>
		<c:if test="${sessionScope.customer!=null}">
	  			欢迎您:${sessionScope.customer.name}
	  			<li><a href="logout.do">注销</a>
			</li>
		</c:if>
		<li><a href="">后台入口</a>
		</li>
	</ul>
</nav>




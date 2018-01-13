<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript" src="/MyBBS/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="/MyBBS/js/jquery-logincheck.js"></script>
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<strong>${shouldLoginMsg}</strong>
						</h3>
						<h3 class="panel-title">
							<strong>论坛账号登录</strong>
						</h3>
					</div>
					<div class="panel-body">
						<form method="post" action="login.do">
							<div class="input-group">
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-user"></span>
								</span> 
								<input type="text"
									id="username" name="name" class="form-control">
							</div>

							<div class="input-group">
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-lock"></span> </span> 
									<input type="password" id="password" name="password" 
									class="form-control" placeholder="密码">
							</div>

							<div class="input-group">
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-ok"></span> 
								</span> 
								<input type="text" id="imageCode" name="imageCode" class="form-control" placeholder="验证码"> 
								<span class="input-group-addon" id="checkCode">
								<img id="randImage" alt="看不清楚换一个" src="getImageCode.do"/>
								</span>
							</div>
							<div style="padding-top:10px">
								<button type="button submit" id="loginBtn" class="btn btn-primary">登录</button>
								<button type="button reset"  class="btn btn-success">取消</button>
								<span style="color:red;padding-left:20px;">${errorMsg}</span>
							</div>
						</form>
						<div class="col-xs-6 link">
							<p class="text-center remove-margin">
								<small>还没注册?</small> 
								<a href="toRegist.do"><small>注册</small></a>
							</p>
						</div>
					</div>
				</div>

			</div>
			<div class="col-md-4"></div>
		</div>
	</div>

</body>
</html>

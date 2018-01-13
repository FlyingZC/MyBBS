<%@ page  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  </head>
  <body>
	<%@include file="../common/top.jsp"%>
	<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="panel panel-primary"> 
						<div class="panel-heading"> 
							<h3 class="panel-title"><strong>论坛注册</strong></h3>
						</div>
						<div class="panel-body"> 
							<form action="regist.do" class="form" method="post">	
								<div class="input-group">
									<span class="input-group-addon"><span><strong>用户名&nbsp;&nbsp;</strong></span></span>
									<input type="text" class="form-control" name="name" onblur="checkNickname(this)" onfocus="enterNickname()" />
									<span class="input-group-addon"><span id="nicknamediv"> *请填写用户名</span></span>
								</div>
								<br/>
								<div class="input-group">
									<span class="input-group-addon"><span><strong>密&nbsp;&nbsp;&nbsp;&nbsp;码</strong></span></span>
									<input type="password" class="form-control" name="password" onblur="checkPassword(this)" onfocus="enterPassword()" />
									<span class="input-group-addon"><span id="passworddiv"> *6~16个字符，区分大小写</span></span>
								</div>
								<br/>
								<div class="input-group">
									<span class="input-group-addon"><span><strong>确认密码</strong></span></span>
									<input type="password" class="form-control name="repassword" onblur="checkRepassword(this)" onfocus="enterRepassword()" />
									<span class="input-group-addon"><span id="repassworddiv">*请再次填写密码</span></span>
								</div>
								<br/>
								<div class="input-group">
									<span class="input-group-addon"><span><strong>电话&nbsp;&nbsp;&nbsp;&nbsp;</strong></span></span>
									<input type="password" class="form-control name="phone" onblur="checkRepassword(this)" onfocus="enterRepassword()" />
									<span class="input-group-addon"><span id="repassworddiv">*请填写电话</span></span>
								</div>
								<br/>
								<div class="input-group">
									<span class="input-group-addon"><span><strong>收货地址</strong></span></span>
									<input type="password" class="form-control name="address" onblur="checkRepassword(this)" onfocus="enterRepassword()" />
									<span class="input-group-addon"><span id="repassworddiv">*请填写收货地址</span></span>
								</div>
								<br/>
								<div class="input-group">
									<span class="input-group-addon"><span><strong>邮箱&nbsp;&nbsp;&nbsp;&nbsp;</strong></span></span>
									<input type="password" class="form-control name="email" onblur="checkRepassword(this)" onfocus="enterRepassword()" />
									<span class="input-group-addon"><span id="repassworddiv">*请填写邮箱</span></span>
								</div>
								<div>
									<div><strong>条款</strong></div>
					   				<label class="checkbox-inline">
					     				<input type="checkbox" id="" value="" name="tiaokuan" checked="checked"onclick= "checkTiaokuan(this);"> 
					     					同意"服务条款"和"用户须知"、"隐私权相关政策"
					  				</label>
					  				<div id="tiaokuandiv"></div>
					  			</div>
				  				<br/>
							<button type="button submit" class="btn btn-primary col-md-offset-5">免费注册</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
		
	</div>
	
  </body>
</html>

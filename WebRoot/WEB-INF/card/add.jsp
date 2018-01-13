<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="utf-8">    
  </head>
  <body>
  	<%@include file="../common/top.jsp" %>
  	<div class="container">
  	<div class="row">
  			<div class="col-md-1"></div>
  			<div class="col-md-10">
	  			<div class="panel panel-default">
					  <div class="panel-heading">
					    <h3 class="panel-title">发表帖子</h3>
					  </div>
					  <div class="panel-body">
						<form role="form" method="post" action="addCard.do">
							<div class="form-group has-success">
								<label for="name">标题:</label>	
								<input type="input" class="form-control" id="name" name="name" placeholder="请输入帖子标题"/>	
							</div>
					<div class="form-group">
						<label for="txt">内容</label>
						<textarea class="form-control" rows="5" id="txt" name="txt"></textarea>	
					</div>
					<input type="hidden" name="moduleId" value="${moduleId}"/>
					<div class="form-group">
						<button type="button submit" class="btn btn-primary">发表</button>	
						<button type="button reset" class="btn btn-danger">取消</button>
					</div>
				</form> 							
					  </div><!-- End panel-body -->
				</div><!-- End panel-default -->
  			</div><!-- End col-md-8 -->
  	</div><!-- End row -->
  	</div>
  </body>
</html>

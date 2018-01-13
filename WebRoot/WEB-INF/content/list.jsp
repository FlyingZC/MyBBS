<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="utf-8"> 
	<script src="js/jquery-2.2.3.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script>
	$(function(){
		 $('#myModal').modal({
			 show:false,//初始化时不显示
		     backdrop:false//背景不可点击 
		 });
		 $("#myModal").draggable({
			 handle: ".modal-header"
		 });
	});
	</script> 
  </head>
  <body>
  	<%@include file="../common/top.jsp" %>
  	<div class="container">
  	<div class="row">
  		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					${cardName}
				</div>
			</div>
		</div>
  	</div><!-- End row -->
  	<c:forEach items="${page.data}" var="content">
  		<div class="row">
  			<div class="col-md-2"></div>
  			<div class="col-md-8">
  				<div class="panel panel-primary">
					  <div class="panel-body">
						  <div class="row" style="height:200px">
						  	<div class="col-md-2">${content.customer.id}${content.customer.name}${content.customer.icon}</div>
						  	<div class="col-md-8">${content.txt}</div>
						  	<div class="col-md-1">${content.floor}</div>
  							<div class="col-md-1">${content.come}</div>
						  </div><!-- End row -->
					 </div>
				</div>
  			</div>
  		</div><!-- End row -->
  	</c:forEach>
  	<div class="row">
  		<%@include file="../common/page.jsp" %>
  	</div><!-- End row -->
  	<div class="row">
  		<button type='button' id='' class='btn btn-primary btn_tochange' data-toggle='modal' data-target='#myModal'>回帖</button>
  	</div><!-- End row -->
  		<!-- 模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
			    	<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        	<h4 class="modal-title" id="myModalLabel">发表回复</h4>
			      	</div>
				    <form role="form" action="addContent.do?cardId=${page.data[0].cardId}&target=${page.data[0].id}" method="post" class="form-horizontal">
				    <div class="modal-body">
							<div class="form-group">
								<textarea name="txt" class="form-control" rows="3"></textarea>	
							</div>
				    </div>
				    <div class="modal-footer">
				        <button type="button" class="btn btn-default"  data-dismiss="modal">关闭</button>
				        <button type="button submit" class="btn btn-primary" id="mySubmit">保存</button>
				    </div>
					</form>
			 	</div>
			</div>
		</div><!-- End 模态框 -->
  	</div>
  </body>
</html>

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
					    <h3 class="panel-title">全部主题 作者 回复/查看 最后发表</h3>
					  </div>
					  <div class="panel-body">
						<table class="table table-striped table-hover table-condensed">
							<thead>
								<tr class="active">
									<td>帖子</td>
									<td>作者</td>
									<td>浏览量</td>
									<td>回复量</td>
								</tr>
							</thead>
							<tbody>
						  		<c:forEach items="${page.data}" var="card">
								<tr class="warning">
									<td><a href="toContent.do?cardId=${card.id}&cardName=${card.name}">${card.name}</a></td>
									<td>${card.editorName}</td>
									<td>${card.replayNum}</td>
									<td>2</td>
								</tr>
						  		</c:forEach>
								<tr><td><a type="button" class="btn btn-success" href="toAddCard.do?moduleId=${moduleId}">发帖</a></td></tr>
							</tbody>
							<tfoot>
								<tr>
								</tr>
							</tfoot>
						</table>
					  </div><!-- End panel-body -->
				</div><!-- End panel-default -->
  			</div><!-- End col-md-8 -->
  	</div><!-- End row -->
  	<div class="row">
  		<%@include file="../common/page.jsp" %>
  	</div><!-- End row -->
  	</div>
  </body>
</html>

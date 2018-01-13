<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="utf-8">    
  </head>
  <body>
  	<%@include file="top.jsp" %>
  	<div class="container">
  	<c:forEach items="${parts}" var="part">
  		<div class="row">
  			<div class="col-md-10 col-md-offset-1">
  				<div class="panel panel-primary">
					  <div class="panel-heading">
					     <h3 class="panel-title">${part.name}</h3>
					  </div>
					  <div class="panel-body">
						  <div class="row">
							  <c:forEach items="${modules}" var="module"> 
								<c:if test="${module.partId==part.id}">
									<div class="col-md-3">
										<a class="btn btn-primary" href="toCard.do?moduleId=${module.id}">${module.name}</a>
									</div>
								</c:if>	
							  </c:forEach>
						  </div><!--End row-->
					  </div><!-- End pandel-body -->
				</div><!-- End panel -->
  			</div><!-- End col -->
  		</div><!-- End row -->
  	</c:forEach>
  	</div><!-- End container -->
  </body>
</html>

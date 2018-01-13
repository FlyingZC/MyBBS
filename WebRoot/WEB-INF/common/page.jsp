<%@page pageEncoding="UTF-8"%>
<ul class="pager">
  <li><a href="/MyBBS${requestScope.page.url}&currentPage=1">首页</a></li>	
  <li><a href="/MyBBS${requestScope.page.url}&currentPage=${page.currentPage-1>0?page.currentPage-1:1}">上一页</a></li>
	<li class="btn btn-default">第${page.currentPage}页</li>
	<li class="btn btn-default">共${page.totalPages}页</li>
  <li><a href="/MyBBS${requestScope.page.url}&currentPage=${page.currentPage+1<=page.totalPages?page.currentPage+1:page.currentPage}">下一页</a></li>
  <li><a href="/MyBBS${requestScope.page.url}&currentPage=${page.totalPages}">尾页</a></li>
</ul>
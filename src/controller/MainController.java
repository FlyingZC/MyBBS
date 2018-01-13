package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Card;
import entity.Content;
import entity.Customer;
import service.MainService;
import service.impl.MainServiceImpl;
import util.ImageUtil;
import util.PageUtil;

public class MainController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MainService ms=new MainServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path=request.getServletPath();
		if("/toIndex.do".equals(path)){
			this.toIndex(request,response);
		}else if("/toCard.do".equals(path)){
			this.toCard(request,response);
		}else if("/findCardPage.do".equals(path)){//帖子分页查询
			this.findCardPage(request,response);
		}else if("/toContent.do".equals(path)){
			this.toContent(request,response);
		}else if("/findContentPage.do".equals(path)){
			this.findContentPage(request,response);
		}else if("/addContent.do".equals(path)){
			this.addContent(request,response);
		}else if("/toLogin.do".equals(path)){
			this.toLogin(request,response);
		}else if("/login.do".equals(path)){
			this.login(request,response);
		}else if("/regist.do".equals(path)){
			this.regist(request,response);
		}else if("/toRegist.do".equals(path)){
			this.toRegist(request,response);
		}else if("/getImageCode.do".equals(path)){//获取验证码
			this.getImageCode(request,response);
		}else if("/logout.do".equals(path)){
			this.logout(request,response);
		}else if("/toAddCard.do".equals(path)){
			this.toAddCard(request,response);
		}else if("/addCard.do".equals(path)){
			this.addCard(request,response);
		}
	}
	private void addCard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");//帖名
		String txt=request.getParameter("txt");//内容
		String moduleId=request.getParameter("moduleId");
		Customer c=(Customer) request.getSession().getAttribute("customer");
		Integer editorId=c.getId();//come
		Card card=new Card();
		card.setEditorId(editorId);
		card.setName(name);
		System.out.println("moduleId:"+moduleId);
		card.setModuleId(Integer.parseInt(moduleId));
		card.setTime(new Timestamp(new Date().getTime()));
		
		Content content=new Content();
		content.setCome(editorId);
		content.setFloor(1);
		content.setTxt(txt);
		ms.addCard(card,content);
		response.sendRedirect("toCard.do?moduleId="+moduleId);
	}
	private void toAddCard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//判断是否登录
		Customer c=(Customer) request.getSession().getAttribute("customer");
		if(c==null){
			request.setAttribute("shouldLoginMsg","抱歉，您尚未登录，没有权限在该版块发帖");
			request.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(request, response);
			return;
		}
		//发帖时需要将具体添加到哪个模块传过去
		String moduleId = request.getParameter("moduleId");
		request.setAttribute("moduleId",moduleId);
		//无法重定向到WEB-INF下的页面,转发
		request.getRequestDispatcher("WEB-INF/card/add.jsp").forward(request, response);;
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("customer");
		response.sendRedirect("toIndex.do");
	}
	private void getImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//生成验证码以及图片
		Object[] objs = ImageUtil.createImage();
		//将验证码存入session
		request.getSession().setAttribute("imageCode", objs[0]);
		//将图片输出到浏览器
		response.setContentType("image/png");
		//tomcat创建的输出流,目标就是本次访问的那个浏览器
		OutputStream os=response.getOutputStream();
		BufferedImage img=(BufferedImage)objs[1];
		ImageIO.write(img, "png", os);
		os.close();
	}
	private void toRegist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/customer/regist.jsp").forward(request, response);
	}
	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name=request.getParameter("name");
			String password = request.getParameter("password");
			Customer c=new Customer();
			c.setName(name);
			c.setPassword(password);
			ms.regist(c);
			request.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(request, response);	
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String imageCode = request.getParameter("imageCode");
		HttpSession session = request.getSession();
		String sImageCode = (String) session.getAttribute("imageCode");
		if(imageCode==null||!imageCode.equalsIgnoreCase(sImageCode)){
			request.setAttribute("errorMsg","验证码错误");
			request.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(request, response);
			return;
		}
		Customer c = ms.login(name,password);
		if(c==null||!c.getPassword().equals(password)){
			request.setAttribute("errorMsg", "账号或密码错误");
			request.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("customer",c);
			request.getRequestDispatcher("toIndex.do").forward(request, response);
		}
	}
	//前往登录页面
	private void toLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(request, response);
	}
	//添加回帖内容
	private void addContent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cardId = request.getParameter("cardId");
		String target = request.getParameter("target");
		String txt=request.getParameter("txt");
		Content content=new Content();
		content.setCardId(Integer.parseInt(cardId));
		content.setTarget(Integer.parseInt(target));
		content.setTxt(txt);
		Customer c = (Customer)request.getSession().getAttribute("customer");
		if(c==null){//未登陆
			request.setAttribute("shouldLoginMsg","抱歉，您尚未登录，没有权限在此回帖");
			request.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(request, response);
			return;
		}
		Integer comeId = c.getId();
		System.out.println(comeId);
		content.setCome(comeId);//回帖默认是来自当前用户
		ms.addContent(content);
		response.sendRedirect("toContent.do?cardId="+cardId);
	}
	private void findContentPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String _cardId=request.getParameter("cardId");
		String _currentPage=request.getParameter("currentPage");
		Long currentPage=null;
		if(_currentPage==null||"".equals(_currentPage)){
			currentPage=1L;
		}else{
			currentPage=Long.parseLong(_currentPage);
		}
		Integer cardId = Integer.parseInt(_cardId);
		PageUtil<Content> data = ms.findAllContentByCardId(cardId,currentPage,10L);
		request.setAttribute("page", data);
		String cardName=ms.findCardNameById(cardId);
		request.setAttribute("cardName", cardName);
		request.getRequestDispatcher("WEB-INF/content/list.jsp").forward(request, response);
	}
	//帖子具体内容页面
	private void toContent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String _cardId=request.getParameter("cardId");
		if(_cardId==null||"".equals(_cardId)){
			System.out.println("toContent中cardId为空");
			return;
		}
		int cardId = Integer.parseInt(_cardId);
		String cardName=ms.findCardNameById(cardId);
		System.out.println(cardName);
		PageUtil<Content> data = ms.findAllContentByCardId(cardId,1L,10L);
		request.setAttribute("cardName", cardName);
		request.setAttribute("page", data);
		request.getRequestDispatcher("WEB-INF/content/list.jsp").forward(request, response);
	}
	private void findCardPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String _currentPage=request.getParameter("currentPage");
		Long currentPage=null;
		if(_currentPage==null||"".equals(_currentPage)){
			currentPage=1L;
		}else{
			currentPage=Long.parseLong(_currentPage);
		}
		String _moduleId=request.getParameter("moduleId");
		System.out.println(_moduleId);
		int moduleId=Integer.parseInt(_moduleId);
		PageUtil<Card> page= ms.findCardsPageByModuleId(moduleId, currentPage, 10L);
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/card/list.jsp").forward(request, response);
	}
	//跳转到帖子页面,默认显示第一页
	private void toCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String moduleId=request.getParameter("moduleId");
		System.out.println(moduleId);
		if(moduleId!=null&&!moduleId.equals("")){
			PageUtil<Card> pageUtil=ms.findCardsPageByModuleId(Integer.parseInt(moduleId));
			request.setAttribute("page",pageUtil);
			request.setAttribute("moduleId",moduleId);
			request.getRequestDispatcher("WEB-INF/card/list.jsp").forward(request, response);
		}
	}

	private void toIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("parts",ms.findAllPart());
		request.setAttribute("modules",ms.findAllModule());
		request.getRequestDispatcher("WEB-INF/common/main.jsp").forward(request, response);
	}
}

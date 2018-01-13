package service.impl;

import java.util.List;

import service.MainService;
import util.PageUtil;
import dao.CardDao;
import dao.ContentDao;
import dao.CustomerDao;
import dao.ModuleDao;
import dao.PartDao;
import dao.impl.CardDaoImpl;
import dao.impl.ContentDaoImpl;
import dao.impl.CustomerDaoImpl;
import dao.impl.ModuleDaoImpl;
import dao.impl.PartDaoImpl;
import entity.Card;
import entity.Content;
import entity.Customer;
import entity.Module;
import entity.Part;

public class MainServiceImpl implements MainService{
	private PartDao partDao=new PartDaoImpl();
	private ModuleDao moduleDao=new ModuleDaoImpl();
	private CardDao cardDao=new CardDaoImpl();
	private ContentDao contentDao=new ContentDaoImpl();
	private CustomerDao customerDao=new CustomerDaoImpl();
	public List<Part> findAllPart() {
		return partDao.findAllPart();
	}

	public List<Module> findAllModule() {
		return moduleDao.findAllModule();
	}

	public PageUtil<Card> findCardsPageByModuleId(int moduleId) {
		return this.findCardsPageByModuleId(moduleId, 1L, 10L); 
	}

	public PageUtil<Card> findCardsPageByModuleId(int moduleId,
			Long currentPage, Long pageSize){
		PageUtil<Card> pageUtil=new PageUtil<Card>(currentPage,pageSize);
		pageUtil.setTotalRecords(cardDao.countCardsByModuleId(moduleId));
		List<Card> data=cardDao.findCardsPageByModuleId(pageUtil.getStart(),pageUtil.getEnd(),moduleId);
		pageUtil.setData(data);
		//下一次分页请求时,会将该信息写入地址栏
		pageUtil.setUrl("/findCardPage.do?moduleId="+moduleId);
		return pageUtil;
	}

	public PageUtil<Content> findAllContentByCardId(int cardId,
			Long currentPage, Long pageSize) {
		PageUtil<Content> pageUtil=new PageUtil<Content>(currentPage,pageSize);
		pageUtil.setTotalRecords(contentDao.countContentsByCardId(cardId));
		List<Content> data=contentDao.findContentsPageByCardId(pageUtil.getStart(),pageUtil.getEnd(),cardId);
		pageUtil.setData(data);
		pageUtil.setUrl("/findContentPage.do?cardId="+cardId);
		return pageUtil;
	}

	public Customer login(String name, String password) {
		return customerDao.login(name,password);
	}

	public void regist(Customer c) {
		customerDao.saveCustomer(c);
	}

	public boolean addContent(Content content) {
		Integer floorCount=contentDao.countFloorsByCardId(content.getCardId());
		content.setFloor(floorCount+1);//新回复应在所有楼+1
		contentDao.addContent(content);
		return true;
	}

	public void addCard(Card card, Content content) {
		cardDao.addCard(card);
		Integer cardId=cardDao.findCardId(card);
		content.setCardId(cardId);
		contentDao.addContent(content);
	}

	public String findCardNameById(int cardId) {
		return cardDao.findCardNameById(cardId);
	}

}

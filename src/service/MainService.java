package service;

import java.util.List;

import util.PageUtil;
import entity.Card;
import entity.Content;
import entity.Customer;
import entity.Module;
import entity.Part;

public interface MainService {
	/**
	 * 查询所有分区
	 * @return
	 */
	public List<Part> findAllPart();
	/**
	 * 查询所有模块
	 * @return
	 */
	public List<Module> findAllModule();
	/**
	 * 根据模块id分页查询帖子
	 * @param parseInt
	 * @return
	 */
	public PageUtil<Card> findCardsPageByModuleId(int moduleId);
	public PageUtil<Card> findCardsPageByModuleId(int moduleId,Long currentPage,Long pageSize);
	/**
	 * 根据帖子id分页查询内容
	 * @param cardId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageUtil<Content> findAllContentByCardId(int cardId,Long currentPage,Long pageSize);
	//用户
	public Customer login(String name, String password);
	public void regist(Customer c);
	public boolean addContent(Content content);
	/**
	 * 发表帖子,需要新建一个帖子,和向帖子中添加一个content
	 * @param card
	 * @param content
	 */
	public void addCard(Card card, Content content);
	public String findCardNameById(int cardId);
	
	
}

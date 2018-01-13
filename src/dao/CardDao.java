package dao;

import java.util.List;

import entity.Card;
import entity.Content;

public interface CardDao {

	List<Card> findCardsPageByModuleId(Long start, Long end,int moduleId);

	Long countCardsByModuleId(int moduleId);

	void addCard(Card card);

	/**
	 * 根据card内容查询其id
	 * @param card
	 * @return
	 */
	Integer findCardId(Card card);

	String findCardNameById(int cardId);

}

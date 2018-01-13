package dao;

import java.util.List;

import entity.Content;

public interface ContentDao {

	Long countContentsByCardId(int cardId);

	List<Content> findContentsPageByCardId(Long start, Long end, int cardId);

	boolean addContent(Content content);

	Integer countFloorsByCardId(Integer cardId);

}

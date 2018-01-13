package dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import util.DBUtil;
import util.PageUtil;
import dao.CardDao;
import entity.Card;

public class CardDaoImpl implements CardDao {
	private QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
	public List<Card> findCardsPageByModuleId(Long start, Long end,int moduleId) {
		String sql="select  x.id,x.theme_id themeId,x.editor_id editorId,x.name,x.time,x.replay_num replayNum "
				+" ,x.watch_num watchNum,x.module_id moduleId ,x.editorName " 
				+" from(select rownum rn,card.*,c.name editorName  "
				+" from card inner join customer c on module_id=?  and card.editor_id=c.id and rownum<? )x where rn>=?";
		try {
			List<Card> data = runner.query(sql,new BeanListHandler<Card>(Card.class),moduleId,end,start);
			System.out.println(data);
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("CardDaoImpl类中findCardsPageByModuleId查询失败!");
		}
	}
	public Long countCardsByModuleId(int moduleId) {
		try {//oracle查出来是BigDecimal类型,toString
			BigDecimal result = runner.query("select count(*) from card where module_id=?", new ScalarHandler<BigDecimal>(1),moduleId);
			return Long.parseLong(result.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("CardDaoImpl类中countCardsByModuleId查询失败!");
		}
	}
	public void addCard(Card card) {
		System.out.println(card);
		String sql="insert into card values(seq_card.nextVal,null,?,?,?,0,0,?)";
		try {
			runner.update(sql,card.getEditorId(),card.getName(),card.getTime(),card.getModuleId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Integer findCardId(Card card) {
		try {
			BigDecimal result = runner.query("select id from card where editor_id=? and time=?"
					,new ScalarHandler<BigDecimal>(),card.getEditorId(),card.getTime());
			return Integer.parseInt(result.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("CardDaoImpl类中findCardId查询失败!");
		}
	}
	public String findCardNameById(int cardId) {
		try {
			return runner.query("select name from card where id=?",new ScalarHandler<String>(1),cardId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("CardDaoImpl类中findCardNameById查询失败!");
		}
	}
	
}

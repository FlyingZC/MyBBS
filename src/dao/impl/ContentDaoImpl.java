package dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import util.DBUtil;
import dao.ContentDao;
import entity.Content;
import entity.Customer;

public class ContentDaoImpl implements ContentDao {
	private QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
	public Long countContentsByCardId(int cardId) {
		try {//oracle查出来是BigDecimal类型,toString
			BigDecimal result = runner.query("select count(*) from content where card_id=?", new ScalarHandler<BigDecimal>(1),cardId);
			return Long.parseLong(result.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("CardDaoImpl类中countCardsByModuleId查询失败!");
		}
	}
	public List<Content> findContentsPageByCardId(Long start, Long end,
			int cardId) {
		/*String sql="select x.id,x.card_id cardId,x.floor,x.come,x.target,x.time,x.txt from" +
				"(select rownum rn,content.* from content where card_id=? and rownum<?)x where rn>?";*/
		String sql="select x.id,x.card_id,x.floor,x.come,x.target,x.time,x.txt,c.id,c.name,c.icon from "
				+" (select rownum rn,content.* from content where card_id=? and rownum<=?)x inner join "+  
				" customer c on c.id=x.come  where rn>=?";
		try {
			Connection conn=DBUtil.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setObject(1, cardId);
			psmt.setObject(2, end);
			psmt.setObject(3, start);
			ResultSet rs = psmt.executeQuery();
			List<Content> data=new ArrayList<Content>();
			while(rs.next()){
				Customer customer=new Customer();
				Content c=new Content();
				c.setId(rs.getInt(1));
				c.setCardId(rs.getInt(2));
				c.setFloor(rs.getInt(3));
				c.setCome(rs.getInt(4));
				c.setTarget(rs.getInt(5));
				c.setTime(rs.getTimestamp(6));
				c.setTxt(rs.getString(7));
				
				customer.setId(rs.getInt(8));
				customer.setName(rs.getString(9));
				customer.setIcon(rs.getString(10));
				c.setCustomer(customer);
				data.add(c);
			}
			System.out.println(data);
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("CardDaoImpl类中findCardsPageByModuleId查询失败!");
		}
	}
	public boolean addContent(Content content) {
		System.out.println(content);
		try {
			runner.update("insert into content(id,card_id,floor,come,target,time,txt) " +
					" values(seq_content.nextVal,?,?,?,?,sysdate,?)",content.getCardId(),content.getFloor()
					,content.getCome(),content.getTarget(),content.getTxt());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Integer countFloorsByCardId(Integer cardId) {
		try {
			BigDecimal result = runner.query("select count(floor) from content", new ScalarHandler<BigDecimal>(1));
			return Integer.parseInt(result.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("CardDaoImpl类中countFloorsByCardId查询失败!");
		}
	}

}

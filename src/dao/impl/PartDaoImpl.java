package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.DBUtil;
import dao.PartDao;
import entity.Part;

public class PartDaoImpl implements PartDao {
	private QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
	public List<Part> findAllPart() {
		try {
			return runner.query("select * from part", new BeanListHandler<Part>(Part.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询findAllPart失败!");
		}
	}

}

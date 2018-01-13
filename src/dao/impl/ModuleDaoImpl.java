package dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import util.DBUtil;
import dao.ModuleDao;
import entity.Module;

public class ModuleDaoImpl implements ModuleDao {
	
	private QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
	public List<Module> findAllModule() {
		try {
			List<Map<String, Object>> rs = runner.query("select id,imgsrc,theme_id themeId,card_num cardNum,last_post lastPost,part_id partId,name from module"
					, new MapListHandler());
			return runner.query("select id,imgsrc,theme_id themeId,card_num cardNum,last_post lastPost,part_id partId,name from module"
					, new BeanListHandler<Module>(Module.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询findAllPart失败!");
		}
	}

}

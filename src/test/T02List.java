package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;


public class T02List {
	public static void main(String[] args) throws SQLException {
		String sql="select id,theme_id themeId,editor_id editorId,name,time,replay_num replayNum " +
				" ,watch_num watchNum,module_id moduleId  " +
				" from(select rownum rn,card.* from card where module_id=? and rownum<?) where rn>?";
		Connection conn=DBUtil.getConnection();
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setObject(1, 210542);
		psmt.setObject(2,10);
		psmt.setObject(3,1);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getObject(1));
		}
		System.out.println("heh");
	}
}

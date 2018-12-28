package web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.TagDao;
import web.entity.Tag;
import web.util.HandlerDBUtil;

/**
* @ClassName: BlogTagImp
* @Description: 博客分类操作
* @author 李勇超
* @date 2018年12月27日下午5:12:54
*
*/
public class TagDaoImp implements TagDao {
	@Override
	public List<Tag> getTagList() {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "select * from tag_table";
		// 结果集
		ResultSet rSet = null;
		ArrayList<Tag> list = new ArrayList<>();
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		try {
			rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				Tag tag=new Tag();
				tag.setTagName(rSet.getString("tag_title"));
				list.add(tag);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, rSet);
		}
		return list;
	}
}

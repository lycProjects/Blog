package web.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import web.dao.BlogDao;
import web.entity.Blog;
import web.util.HandlerDBUtil;

/**
 * @ClassName: BlogImp
 * @Description: 博客操作
 * @author 李勇超
 * @date 2018年12月27日下午5:11:13
 *
 */
public class BlogDaoImp implements BlogDao {
	// 增加
	@Override
	public boolean insertBlog(Blog blog) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "insert into blog_table (title, tag, content, lasttime, status, readnum, good, uid) values (?,?,?,now(),?,?,?,?)";
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		try {
			preparedStatement.setString(1, blog.getTitle());
			preparedStatement.setInt(2, blog.getTag());
			preparedStatement.setString(3, blog.getContent());
			preparedStatement.setInt(4, blog.getStatus());
			preparedStatement.setInt(5, 0);
			preparedStatement.setInt(6, blog.getUid());
			preparedStatement.setInt(7, blog.getUid());

			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, null);
		}

		return false;
	}

	// 修改
	@Override
	public boolean updateBlog(Blog blog) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "update blog_table set title = ?, tag = ?, content = ?,status=? where id = ?";
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		try {
			preparedStatement.setString(1, blog.getTitle());
			preparedStatement.setInt(2, blog.getTag());
			preparedStatement.setString(3, blog.getContent());
			preparedStatement.setInt(4, blog.getStatus());
			preparedStatement.setInt(5, blog.getId());

			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, null);
		}

		return true;
	}

	// 通过id删除
	@Override
	public boolean deleteBlog(int id) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "delete from blog_table where id = ?";
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		try {
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, null);
		}

		return false;
	}

	@Override
	public List<Blog> queryBlog(int tag,int uidd) {
		ArrayList<Blog> list = new ArrayList<>();
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "select * from blog_table where tag = ? and uid=? and status != 0";
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		ResultSet rSet = null;
		try {
			preparedStatement.setInt(1, tag);
			preparedStatement.setInt(2, uidd);
			rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				int id = rSet.getInt("id");
				String title = rSet.getString("title");
				int t = rSet.getInt("tag");
				String content = rSet.getString("content");
				Date date = rSet.getDate("lasttime");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-dd hh:mm:ss");
				String lasttime = simpleDateFormat.format(date);
				int status = rSet.getInt("status");
				int good = rSet.getInt("good");
				int readNum = rSet.getInt("readnum");
				int uid = rSet.getInt("uid");

				Blog blog = new Blog(id, title, t, content, lasttime, status, good, readNum, uid);
				list.add(blog);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, rSet);
		}

		return list;
	}

	// 通过id查询
	@Override
	public Blog selectBlog(int id) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "select * from blog_table where id = ?";
		ResultSet rSet = null;
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		Blog blog = null;
		try {
			preparedStatement.setInt(1, id);
			rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				String title = rSet.getString("title");
				int t = rSet.getInt("tag");
				String content = rSet.getString("content");
				Date date = rSet.getDate("lasttime");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-dd hh:mm:ss");
				String lasttime = simpleDateFormat.format(date);
				int status = rSet.getInt("status");
				int good = rSet.getInt("good");
				int readNum = rSet.getInt("readnum");
				int uid = rSet.getInt("uid");
				blog = new Blog(id, title, t, content, lasttime, status, good, readNum, uid);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, null);
		}

		return blog;
	}

}

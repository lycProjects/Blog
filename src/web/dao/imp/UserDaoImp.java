package web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dao.UserDao;
import web.entity.*;
import web.util.HandlerDBUtil;

/**
 * @ClassName: BlogUserImp
 * @Description: 用户操作类
 * @author 李勇超
 * @date 2018年12月27日下午5:14:11
 *
 */
public class UserDaoImp implements UserDao {
	// 查询用户名是否存在
	private boolean isExists(User user) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		String sql = "select * from user_table where username = ?";
		// 获取预编译对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		ResultSet rs = null;
		try {
			preparedStatement.setString(1, user.getUsername());
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, rs);
		}
		return false;
	}

	// 注册
	@Override
	public boolean register(User user) {
		if (isExists(user)) {
			return false;
		}
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// 编写sql语句
		String sql = "insert into user_table (username, pwd,nickname,email) values (?,?,?,?)";
		// 获取预编译对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		try {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPwd());
			preparedStatement.setString(3, user.getNickname());
			preparedStatement.setString(4, user.getEmail());

			// 执行编译
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

	// 登录
	@Override
	public boolean login(User user) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		String sql = "select * from user_table where username = ? and pwd = ?";
		// 获取预编译对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		ResultSet rs = null;
		try {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPwd());
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, rs);
		}
		return false;
	}

	// 通过用户名和密码获取id
	public int getId(User user) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		String sql = "select * from user_table where username = ? and pwd = ?";
		// 获取预编译对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		ResultSet rs = null;
		try {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPwd());
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, rs);
		}
		
		return Integer.valueOf(user.getId());
	}
}

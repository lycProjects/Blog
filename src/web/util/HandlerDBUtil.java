package web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
* @ClassName: HandlerDBUtil
* @Description: 使用单例的方式
* @author 李勇超
* @date 2018年12月27日下午5:17:56
*
*/
public class HandlerDBUtil {
	// 静态私有不可更改的对象 hdbUtil
	private static final HandlerDBUtil hdbUtil = new HandlerDBUtil();

	// 线程同步，保证操作数据库的安全性
	public synchronized static HandlerDBUtil getInstance() {
		return hdbUtil;
	}

	// 构造方法私有化
	private HandlerDBUtil() {
	}

	// 静态代码块
	static {
		try {
			// 加载驱动
			Class.forName(PropertiesUtil.getValue("jdbcName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取数据库连接对象
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					PropertiesUtil.getValue("dbUrl"), PropertiesUtil.getValue("dbUserName"), PropertiesUtil.getValue("dbPassword"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取预编译对象
	public PreparedStatement getStatement(Connection con, String sql) {
		try {
			return con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 关闭所有的连接对象
	public void closeDB(Connection con, PreparedStatement st, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
			}
			if (st != null) {
				st.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

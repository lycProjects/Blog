package web.dao;


import web.entity.*;
/**
* @ClassName: BlogUserDao
* @Description: 用户操作接口
* @author 李勇超
* @date 2018年12月27日下午5:13:41
*
*/
public interface UserDao {
	
	//注册
	public boolean register(User user);
	
	//登录
	public boolean login(User user);	
	
	//通过用户名和密码获取id
	public int getId(User user);
	
}

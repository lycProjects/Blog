package web.test;

import org.junit.Test;

import web.dao.UserDao;
import web.dao.imp.UserDaoImp;
import web.entity.User;

public class UserTest {

	private UserDao userdao=new UserDaoImp();
	
	@Test
	public void registertest() {
		User user=new User();
		user.setUsername("黄洪");
		user.setNickname("老黄");
		user.setEmail("lao.com");
		user.setPwd("123");
		userdao.register(user);
	}

}

package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import web.dao.UserDao;
import web.dao.imp.UserDaoImp;
import web.entity.User;
import web.util.MD5Utils;

/**
* @ClassName: Login
* @Description: 登录
* @author 李勇超
* @date 2018年12月27日下午4:59:13
*
*/
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String pass=MD5Utils.md5(password);
		
		HttpSession session=request.getSession();
		User user=new User(username,pass);
		UserDao userDao = new UserDaoImp();
		
		boolean login = userDao.login(user);
		int id = userDao.getId(user);
		System.out.println(id);
		if (id!=0) {
			session.setAttribute("idss", id);
		}
		
		String jsonStr = JSON.toJSONString(login);
		response.getWriter().write(jsonStr);
		
		
	}
}

package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import web.dao.UserDao;
import web.dao.imp.UserDaoImp;
import web.entity.*;
import web.util.MD5Utils;

/**
* @ClassName: RegisterServlet
* @Description: 注册
* @author 李勇超
* @date 2018年12月27日下午5:29:46
*
*/
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String pass=MD5Utils.md5(password);
		
		User user = new User(username, pass, nickname, email);
		
		UserDao userDao=new UserDaoImp();
		boolean isSuccess = userDao.register(user);
		
		String jsonStr = JSON.toJSONString(isSuccess);
		response.getWriter().write(jsonStr);
	}
}

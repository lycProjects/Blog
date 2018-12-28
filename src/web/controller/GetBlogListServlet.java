package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import web.dao.BlogDao;
import web.dao.imp.*;
import web.entity.Blog;

/**
* @ClassName: GetBlogListServlet
* @Description: 获取博客列表
* @author 陈辉
* @date 2018年12月27日下午5:29:11
*
*/
@WebServlet("/GetBlogList")
public class GetBlogListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int uid=(int) session.getAttribute("idss");
		System.out.println(uid);
		//获取id
		String id = request.getParameter("id");
		BlogDao blogDao=new BlogDaoImp();
		//当id不为空时执行
		if (id!=null) {
			List<Blog> list = blogDao.queryBlog(Integer.valueOf(id),uid);
			String jsonStr = JSON.toJSONString(list);
			response.getWriter().write(jsonStr);
		}
	}

}

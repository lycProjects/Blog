package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import web.dao.BlogDao;
import web.dao.imp.BlogDaoImp;
import web.entity.Blog;

/**
* @ClassName:SelectBlogServlet
* @Description: 查询博客
* @author 蒋慧娇
* @date 2018年12月27日下午5:27:54
*
*/
@WebServlet("/selectBlog")
public class SelectBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取id
		String id = request.getParameter("id");
		BlogDao blogDao = new BlogDaoImp();
		
		Blog selectBlog = blogDao.selectBlog(Integer.valueOf(id));
		String jsonStr = JSON.toJSONString(selectBlog);
		response.getWriter().write(jsonStr);
			
	}
}

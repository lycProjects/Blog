package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import web.dao.BlogDao;
import web.dao.imp.BlogDaoImp;
import web.entity.Blog;

/**
* @ClassName: AddBlogServlet
* @Description: 增加博客
* @author 梁一亮
* @date 2018年12月27日下午5:25:09
*
*/
@WebServlet("/AddBlog")
public class InsertBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int uid=(int) session.getAttribute("idss");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String blogType = request.getParameter("blogType");
		String status=request.getParameter("status");
		int tag = Integer.valueOf(blogType);
		Blog blog = new Blog(title, tag, content,uid,Integer.valueOf(status));
		
		BlogDao blogDao=new BlogDaoImp();
		boolean isSuccess = blogDao.insertBlog(blog);
		
		String jsonStr = JSON.toJSONString(isSuccess);
		if (isSuccess) {
			response.getWriter().write(jsonStr);
		}else {
			response.getWriter().write(jsonStr);
		}
		
	}
	

}

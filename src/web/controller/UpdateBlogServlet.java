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
* @ClassName: UpdateBlogServlet
* @Description: 修改博客
* @author 李雷
* @date 2018年12月27日下午5:28:12
*
*/
@WebServlet("/UpdateBlog")
public class UpdateBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String id=request.getParameter("id");
    	String title = request.getParameter("title");
		String content = request.getParameter("content");
		String blogType = request.getParameter("blogType");
		String status=request.getParameter("status");
		int tag = Integer.valueOf(blogType);
		Blog blog = new Blog(Integer.valueOf(id),title, tag, content,Integer.valueOf(status));
		
		BlogDao blogDao=new BlogDaoImp();
		boolean isSuccess = blogDao.updateBlog(blog);
		String jsonStr = JSON.toJSONString(isSuccess);
		if (isSuccess) {
			response.getWriter().write(jsonStr);
		}else {
			response.getWriter().write(jsonStr);
		}
		
    }
}

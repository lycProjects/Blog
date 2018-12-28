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

/**
* @ClassName: DeleteBlogServlet
* @Description: 删除博客
* @author 黄洪
* @date 2018年12月27日下午5:27:54
*
*/
@WebServlet("/DeleteBlog")
public class DeleteBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取id
		String id = request.getParameter("id");
		BlogDao blogDao = new BlogDaoImp();
		//当id不为空时执行
		if (id!=null) {
			boolean isSuccess =  blogDao.deleteBlog(Integer.valueOf(id));
			String jsonStr = JSON.toJSONString(isSuccess);
			if (isSuccess) {
				response.getWriter().write(jsonStr);
			}else {
				response.getWriter().write(jsonStr);
			}
		}		
	}
}

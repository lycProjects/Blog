package web.test;



import org.junit.Test;

import web.dao.BlogDao;
import web.dao.imp.BlogDaoImp;
import web.entity.Blog;

public class BlogTest {

	private BlogDao blogDao=new BlogDaoImp();
	
	@Test
	public void test() {
		
		Blog blog = new Blog("za", 1, "as");
		boolean insertBlog = blogDao.insertBlog(blog);
		System.out.println(insertBlog);
		
	}
	
	@Test
	public void updatetest() {
		
		Blog selectBlog = blogDao.selectBlog(6);
		System.out.println(selectBlog);
		
	}

}

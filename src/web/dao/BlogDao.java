package web.dao;

import java.util.List;

import web.entity.*;
/**
* @ClassName: BlogDao
* @Description: 博客操作接口
* @author 李勇超
* @date 2018年12月27日下午5:10:20
*
*/
public interface BlogDao {
	
	//添加	
	public boolean insertBlog(Blog blog);
	
	//修改
	public boolean updateBlog(Blog blog);
	
	//通过id删除
	public boolean deleteBlog(int id);
	
	//列表查询
	public List<Blog> queryBlog(int tag,int uidd);
	
	// 通过id查询
	public Blog selectBlog(int id);
}

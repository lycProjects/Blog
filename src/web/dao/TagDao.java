package web.dao;

import java.util.List;

import web.entity.Tag;

/**
* @ClassName: BlogTagDao
* @Description: 博客分类接口
* @author 李勇超
* @date 2018年12月27日下午5:12:06
*
*/
public interface TagDao {
	
	//分类查询
	public List<Tag> getTagList(); 
}

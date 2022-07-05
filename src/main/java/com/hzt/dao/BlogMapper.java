package com.hzt.dao;

import com.hzt.pojo.Blog;
import com.hzt.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BlogMapper {
    List<Blog> get();

    List<Blog> getFirstPageBlog();

    Blog getById(long id);

    @Insert("insert into tb_blog values (0,#{title},#{content},#{firstPicture},#{views},#{createDate},#{type.id},#{user.id })")
    int save(Blog blog);

    @Delete("delete from tb_blog where id=#{id}")
    int delete(long id);
    @Select("SELECT COUNT(id) FROM tb_blog")
    int count();
}

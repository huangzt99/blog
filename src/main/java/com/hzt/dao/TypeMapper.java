package com.hzt.dao;

import com.hzt.pojo.Type;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper {
    @Insert("insert into tb_type values (0,#{name})")
    int save(String name);


    @Select("select * from tb_type")
    List<Type> get();

    @Delete("delete from tb_type where id = #{id}")
    int delete(long id);
}

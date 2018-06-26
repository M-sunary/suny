package com.suny.blog.mapper;

import com.suny.blog.model.Combine;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 【mybaties映射类】
 *
 * @author yu.sun
 * @content 映射combine实体和数据库字段
 * @date 2018/4/8 22:19
 */
@Mapper
public interface CombineMapper {
    @Select("select * from a_sir_combine where id = #{combineId}")
    Combine findByCombineId(Integer combineId);

    @Insert("insert into a_sir_combine values(#{id},#{name},#{combineType},#{price},#{content},#{thumbUrl},#{params},#{memo})")
    int addNewCombine(Combine combine);
}

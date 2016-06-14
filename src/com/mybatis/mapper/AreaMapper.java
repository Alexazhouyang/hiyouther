package com.mybatis.mapper;

import com.mybatis.entity.Area;
import com.mybatis.entity.AreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaMapper {
    int countByExample(AreaExample example);

    int deleteByExample(AreaExample example);

    int deleteByPrimaryKey(Integer arid);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectByExample();

    Area selectByPrimaryKey(Integer arid);

    Area selectByAddress(@Param("name") String name);
    
    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}
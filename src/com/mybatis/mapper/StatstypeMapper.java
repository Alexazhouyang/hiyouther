package com.mybatis.mapper;

import com.mybatis.entity.Statstype;
import com.mybatis.entity.StatstypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatstypeMapper {
    int countByExample(StatstypeExample example);

    int deleteByExample(StatstypeExample example);

    int deleteByPrimaryKey(Integer stid);

    int insert(Statstype record);

    int insertSelective(Statstype record);

    List<Statstype> selectByExample(StatstypeExample example);

    Statstype selectByPrimaryKey(Integer stid);

    int updateByExampleSelective(@Param("record") Statstype record, @Param("example") StatstypeExample example);

    int updateByExample(@Param("record") Statstype record, @Param("example") StatstypeExample example);

    int updateByPrimaryKeySelective(Statstype record);

    int updateByPrimaryKey(Statstype record);
}
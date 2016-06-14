package com.mybatis.mapper;

import com.mybatis.entity.Statsdate;
import com.mybatis.entity.StatsdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatsdateMapper {
    int countByExample(StatsdateExample example);

    int deleteByExample(StatsdateExample example);

    int deleteByPrimaryKey(Integer sdid);

    int insert(Statsdate record);

    int insertSelective(Statsdate record);

    List<Statsdate> selectByExample(StatsdateExample example);

    Statsdate selectByPrimaryKey(Integer sdid);

    int updateByExampleSelective(@Param("record") Statsdate record, @Param("example") StatsdateExample example);

    int updateByExample(@Param("record") Statsdate record, @Param("example") StatsdateExample example);

    int updateByPrimaryKeySelective(Statsdate record);

    int updateByPrimaryKey(Statsdate record);
}
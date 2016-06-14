package com.mybatis.mapper;

import com.mybatis.entity.Push;
import com.mybatis.entity.PushExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PushMapper {
    int countByExample(PushExample example);

    int deleteByExample(PushExample example);

    int deleteByPrimaryKey(Integer pid);

    int deleteByB(@Param("uid") int uid);
    int deleteByM(@Param("uid") int uid);
    int insert(Push record);
    List<Push> selectPush(@Param("page") int page, @Param("rows") int rows);
    int insertSelective(Push record);
    List<Push> selectByB(@Param("uid") int uid, @Param("page") int page, @Param("rows") int rows);
    List<Push> selectByM(@Param("uid") int uid, @Param("page") int page, @Param("rows") int rows);
    int countByB(@Param("uid") int uid, @Param("option") String option);
    int countByM(@Param("uid") int uid, @Param("option") String option);

    Push selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Push record, @Param("example") PushExample example);

    int updateByExampleWithBLOBs(@Param("record") Push record, @Param("example") PushExample example);

    int updateByExample(@Param("record") Push record, @Param("example") PushExample example);

    int updateByPrimaryKeySelective(Push record);

    int updateByPrimaryKeyWithBLOBs(Push record);

    int updateByPrimaryKey(Push record);
}
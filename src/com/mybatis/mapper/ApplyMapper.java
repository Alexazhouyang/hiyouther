package com.mybatis.mapper;

import com.mybatis.entity.Answer;
import com.mybatis.entity.Apply;
import com.mybatis.entity.ApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {
    int countByExample(ApplyExample example);

    int deleteByExample(ApplyExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Apply record);

    int insertSelective(Apply record);
    int countByapply(@Param("mid") int mid, @Param("state") String state);
    List<Apply> selectByExample(@Param("state") String state, @Param("mid") int mid, @Param("page") int page, @Param("rows") int rows);
    List<Apply> selectByRid(@Param("rid") int rid, @Param("state") String state);
    int countByRid(@Param("rid") int rid);
    int countByHid(@Param("hid") int hid, @Param("state") String state);
    List<Apply> ifApply(@Param("mid") String mid, @Param("rid") String rid);

    Apply selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByExample(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}
package com.mybatis.mapper;

import com.mybatis.entity.Collect;
import com.mybatis.entity.CollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    int countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);
    
    int deleteByHotel(Integer id);
    int countByMid(@Param("mid") int mid);
    List<Integer> selectByHid(@Param("hid") int hid);
    List<Collect> selectByExample(@Param("mid") int mid, @Param("page") int page, @Param("rows") int rows);
    List<Collect> ifCollect(@Param("mid") String mid, @Param("hid") String hid);
    Collect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}
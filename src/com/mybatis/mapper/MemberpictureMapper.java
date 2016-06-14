package com.mybatis.mapper;

import com.mybatis.entity.Memberpicture;
import com.mybatis.entity.MemberpictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberpictureMapper {
    int countByExample();

    int deleteByExample(MemberpictureExample example);

    int deleteByPrimaryKey(Integer mpid);

    int insert(Memberpicture record);

    int insertSelective(Memberpicture record);

    List<Memberpicture> selectByExample(@Param("mid") int mid);

    Memberpicture selectByPrimaryKey(Integer mpid);

    int updateByExampleSelective(@Param("record") Memberpicture record, @Param("example") MemberpictureExample example);

    int updateByExample(@Param("record") Memberpicture record, @Param("example") MemberpictureExample example);

    int updateByPrimaryKeySelective(Memberpicture record);

    int updateByPrimaryKey(Memberpicture record);
}
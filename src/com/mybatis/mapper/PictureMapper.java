package com.mybatis.mapper;

import com.mybatis.entity.Picture;
import com.mybatis.entity.PictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureMapper {
    int countByExample();

    int deleteByExample(PictureExample example);

    int deleteByPrimaryKey(Integer picid);

    int insert(Picture record);

    int insertSelective(Picture record);
    List<Picture> selectByFile();
    List<Picture> selectByExample(@Param("hid") String hid);
    List<Picture> selectByAll();
    Picture selectByRid(@Param("rid") int rid);
    Picture selectByPrimaryKey(Integer picid);

    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByPrimaryKeySelective(Picture record);
    int updateByHidSelective(Picture record);

    int updateByPrimaryKey(Picture record);
}
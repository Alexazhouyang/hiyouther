package com.mybatis.mapper;

import com.mybatis.entity.Otherpush;
import com.mybatis.entity.OtherpushExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtherpushMapper {
    int countByExample(OtherpushExample example);

    int deleteByExample(OtherpushExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Otherpush record);

    int insertSelective(Otherpush record);

    List<Otherpush> selectByExample(OtherpushExample example);

    Otherpush selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Otherpush record, @Param("example") OtherpushExample example);

    int updateByExample(@Param("record") Otherpush record, @Param("example") OtherpushExample example);

    int updateByPrimaryKeySelective(Otherpush record);

    int updateByPrimaryKey(Otherpush record);
    /*用于根据type查找老板的推送情况*/
    Otherpush selectByTypeForUserid(@Param("userid") Integer userid, @Param("usertype") String type);
}
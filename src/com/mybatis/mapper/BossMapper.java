package com.mybatis.mapper;

import com.mybatis.entity.Boss;
import com.mybatis.entity.BossExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BossMapper {
    int countByExample(BossExample example);

    int deleteByExample(BossExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Boss record);

    int insertSelective(Boss record);

    List<Boss> selectByExample();

    Boss selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Boss record, @Param("example") BossExample example);

    int updateByExample(@Param("record") Boss record, @Param("example") BossExample example);

    int updateByPrimaryKeySelective(Boss record);

    int updateByPrimaryKey(Boss record);
    /*forvoid*/
    List<Boss> selectAllConfirm(Integer bcancel);
  	Boss selectByPhone(@Param("bphone") String bphone);

  	Boss selectByEmail(@Param("bemail") String bemail);

  	Boss selectByQQ(@Param("bqq") String bqq);

  	Boss selectByWeiBo(@Param("bweibo") String bweibo);

  	Boss selectByWechat(@Param("bwechat") String bwechat);
  	Boss selectByQQLink(@Param("bqq") String bqq);
}